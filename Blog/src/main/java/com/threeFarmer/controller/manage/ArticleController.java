package com.threeFarmer.controller.manage;

import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.MemberUtil;
import com.threeFarmer.model.article.Article;
import com.threeFarmer.model.article.ArticleTag;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleService;
import com.threeFarmer.service.article.IArticleTagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller("manageArticleController")
@RequestMapping("/")
//@Before(AdminLoginInterceptor.class)
public class ArticleController extends BaseController {
    private static final String MANAGE_JSP_PATH = "/manage/article/article/";
    @Resource
    private IArticleTagService articleTagService;
    @Resource
    private IArticleService articleService;

    @RequestMapping("${managePath}/cms/index")
    //@Before(AdminLoginInterceptor.class)
    public String index(String key, @RequestParam(value = "status",defaultValue = "2",required = false) Integer status,
                        @RequestParam(value = "memberId",defaultValue = "0",required = false) Integer memberId, Model model) {
        Page page = new Page(request);
        ResponseModel responseModel = articleService.listByPage(page,key,status,null);
        model.addAttribute("model",responseModel);
        model.addAttribute("key",key);
        return MANAGE_JSP_PATH + "index";
    }

    @RequestMapping(value="${managePath}/cms/article/add",method = RequestMethod.GET)
    public String add(Model model) {
        List<ArticleTag> TagList = articleTagService.list();
        model.addAttribute("TagList",TagList);
        return MANAGE_JSP_PATH + "add";
    }

    @RequestMapping(value="${managePath}/cms/article/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(@Valid Article article, BindingResult bindingResult) {
        /*if(bindingResult.hasErrors()){
            return new ResponseModel(-1,getErrorMessages(bindingResult));
        }*/
        Member loginMember = MemberUtil.getLoginMember(request);
        ResponseModel responseModel = articleService.save(loginMember,article);
        if(responseModel.getCode() == 0){
            responseModel.setCode(3);
        }
        return responseModel;
    }

    @RequestMapping(value="${managePath}/cms/article/list",method = RequestMethod.GET)
    public String list(String key, @RequestParam(value = "status",defaultValue = "2",required = false) Integer status,
                       @RequestParam(value = "memberId",defaultValue = "0",required = false) Integer memberId, Model model) {
        Page page = new Page(request);
        ResponseModel responseModel = articleService.listByPage(page,key,status,null);
        model.addAttribute("model",responseModel);
        return MANAGE_JSP_PATH + "list";
    }

    @RequestMapping(value="${managePath}/cms/article/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        List<ArticleTag> TagList = articleTagService.list();
        model.addAttribute("TagList",TagList);
        Article article = articleService.findById(id);
        model.addAttribute("article",article);
        return MANAGE_JSP_PATH + "/edit";
    }

    @RequestMapping(value="${managePath}/cms/article/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@Valid Article article, BindingResult bindingResult) {
        /*if(bindingResult.hasErrors()){
            new ResponseModel(-1,getErrorMessages(bindingResult));
        }*/
        if(article.getId() == null){
            return new ResponseModel(-2);
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        ResponseModel responseModel = articleService.update(loginMember,article);
        if(responseModel.getCode() == 0){
            responseModel.setCode(3);
        }
        return responseModel;
    }


    @RequestMapping(value = "${managePath}/cms/article/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("id") Integer id){
        Member loginMember = MemberUtil.getLoginMember(request);
        ResponseModel response = articleService.delete(loginMember,id);
        return response;
    }

    @RequestMapping(value = "${managePath}/cms/article/audit/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object audit(@PathVariable("id") Integer id){
        ResponseModel response = articleService.audit(id);
        return response;
    }

}
