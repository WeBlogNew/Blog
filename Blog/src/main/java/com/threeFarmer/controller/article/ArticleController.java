package com.threeFarmer.controller.article;

import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.MemberUtil;
import com.threeFarmer.core.utils.StringUtils;
import com.threeFarmer.model.article.Article;
import com.threeFarmer.model.article.ArticleTag;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleCommentService;
import com.threeFarmer.service.article.IArticleService;
import com.threeFarmer.service.article.IArticleTagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller("frontArticleController")
@RequestMapping("/article")
public class ArticleController extends BaseController {
    private static final String ARTICLE_JSP_PATH = "/article";

    @Resource
    private IArticleTagService articleTagService;
    @Resource
    private IArticleService articleService;
    @Resource
    private IArticleCommentService articleCommentService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(String key, Model model) {
        if (StringUtils.isNotEmpty(key)){
            try {
                key = new String(key.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Page page = new Page(request);
        ResponseModel responseModel = articleService.listByPage(page,key,1,null);
        model.addAttribute("model",responseModel);
        List<ArticleTag> articleTagList = articleTagService.list();
        model.addAttribute("articleTagList",articleTagList);
        return  ARTICLE_JSP_PATH + "/list";
    }


    @RequestMapping(value="/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id, Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        Article article = articleService.findById(id);
        //文章不存在或者访问未审核的文章，跳到错误页面，提示文章不存在
        if(article == null || article.getStatus() == 0){
            //return jeesnsConfig.getFrontTemplate() + ErrorUtil.error(model,-1009, Const.INDEX_ERROR_FTL_PATH);
        }
        //更新文章访问次数
        articleService.updateViewCount(article.getId());
        model.addAttribute("article",article);
        /*List<ArticleTag> articleTagList = articleTagService.list();
        model.addAttribute("articleTagList",articleTagList);*/
        model.addAttribute("loginUser",loginMember);
        return ARTICLE_JSP_PATH + "/detail";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    //@Before(UserLoginInterceptor.class)
    public String add(Model model) {

        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
            return ARTICLE_JSP_PATH + "/add";
        }
       /* List<ArticleTag> TagList = articleTagService.list();
        model.addAttribute("TagList",TagList);
        String judgeLoginJump = MemberUtil.judgeLoginJump(request, "/article/add");
        if(StringUtils.isNotEmpty(judgeLoginJump)){
            return judgeLoginJump;
        }*/
        return "/member/login";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(@Valid Article article, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("there are some errors");
            //return new ResponseModel(-1,getErrorMessages(bindingResult));
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        ResponseModel responseModel = articleService.save(loginMember,article);
        if(responseModel.getCode() == 0){
            responseModel.setCode(2);
            //文章需要审核就跳转到列表页面
            if(article.getStatus() == 0){
                responseModel.setUrl(request.getContextPath()+"/article/list");
            }else {
                responseModel.setUrl(request.getContextPath()+"/article/detail/"+article.getId());
            }
        }
        return responseModel;
    }

    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    //@Before(UserLoginInterceptor.class)
    public String edit(@PathVariable("id") int id, Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        String judgeLoginJump = MemberUtil.judgeLoginJump(request, "/article/edit/"+id);
        if(StringUtils.isNotEmpty(judgeLoginJump)){
            return judgeLoginJump;
        }
        Article article = articleService.findById(id);
        if(article.getMemberId().intValue() != loginMember.getId().intValue()){
            //return jeesnsConfig.getFrontTemplate() + ErrorUtil.error(model,-1001,Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("article",article);
        List<ArticleTag> TagList = articleTagService.list();
        model.addAttribute("TagList",TagList);
        model.addAttribute("loginUser", loginMember);
        return ARTICLE_JSP_PATH + "/edit";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@Valid Article article, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //new ResponseModel(-1,getErrorMessages(bindingResult));
        }
        if(article.getId() == null){
            return new ResponseModel(-2);
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        ResponseModel responseModel = articleService.update(loginMember,article);
        if(responseModel.getCode() == 0){
            responseModel.setCode(2);
            responseModel.setUrl(request.getContextPath() + "/article/detail/"+article.getId());
        }
        return responseModel;
    }

    /**
     * 评论文章
     * @param articleId
     * @param content
     * @return
     */
    @RequestMapping(value="/comment/{articleId}",method = RequestMethod.POST)
    @ResponseBody
    public Object comment(@PathVariable("articleId") Integer articleId, String content){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        return articleCommentService.save(loginMember,content,articleId);
    }


    @RequestMapping(value="/commentList/{articleId}.json",method = RequestMethod.GET)
    @ResponseBody
    public Object commentList(@PathVariable("articleId") Integer articleId){
        Page page = new Page(request);
        if(articleId == null){
            articleId = 0;
        }
        return articleCommentService.listByArticle(page,articleId);
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("id") int id){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        if(loginMember.getIsAdmin() == 0){
            return new ResponseModel(-1,"权限不足");
        }
        ResponseModel responseModel = articleService.delete(loginMember,id);
        if(responseModel.getCode() > 0){
            responseModel.setCode(2);
            responseModel.setUrl(request.getContextPath() + "/article/list");
        }
        return responseModel;
    }


    /**
     * 文章、喜欢
     * @param id
     * @return
     */
    @RequestMapping(value="/favor/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object favor(@PathVariable("id") Integer id){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        if(id == null) {
            return new ResponseModel(-1, "非法操作");
        }
        return articleService.favor(loginMember,id);
    }
}
