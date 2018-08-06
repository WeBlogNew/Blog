package com.threeFarmer.controller.member;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.utils.MemberUtil;
import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.StringUtils;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleService;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller("memberIndexController")
@RequestMapping("/member")
public class MemberController extends BaseController{
    private static final String MEMBER_JSP_PATH = "/member/";
    @Resource
    private IMemberService memberService;
    @Resource
    private IArticleService articleService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        //需要重新查询用户信息，更新信息
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
        }
        return MEMBER_JSP_PATH + "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model,@RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){
        //System.out.println("login-get method is executed!");
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            return "redirect:/member/index";
        }
        model.addAttribute("redirectUrl",redirectUrl);
        return MEMBER_JSP_PATH + "login";
    }

    /**
     * 登录
     * @param member
     * @param redirectUrl
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Member> login(Member member, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){
        //System.out.println("login-post method is executed!");
        ResponseModel responseModel = memberService.login(member,request);
        if (StringUtils.isEmpty(redirectUrl) && responseModel.getCode() >= 0){
            responseModel.setCode(3);
            responseModel.setUrl(redirectUrl);
        }
        return responseModel;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        MemberUtil.setLoginMember(request,null);
        return "redirect:/member/login";
    }


    /**
     * 注册
     * @param member
     * @param repassword
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel register(Member member,String repassword){
        if(member == null){
            return new ResponseModel(-1,"参数错误");
        }
        if(member.getName().length() < 6){
            return new ResponseModel(-1,"用户名长度最少6位");
        }
        if(!StringUtils.checkNickname(member.getName())){
            return new ResponseModel(-1,"用户名只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if(!StringUtils.isEmail(member.getEmail())){
            return new ResponseModel(-1,"邮箱格式错误");
        }
        if(member.getPassword().length() < 6){
            return new ResponseModel(-1,"密码长度最少6位");
        }
        if(!member.getPassword().equals(repassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
        return memberService.register(member,request);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            return "redirect:/member/index";
        }
        return MEMBER_JSP_PATH + "register";
    }
    @RequestMapping(value = "/forgetpwd",method = RequestMethod.GET)
    public String forgetpwd(){
        return MEMBER_JSP_PATH + "/forgetpwd";
    }

    @RequestMapping(value = "/forgetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel forgetpwd(String name,String email){
        return memberService.forgetpwd(name, email, request);
    }


    @RequestMapping(value = "/editInfo",method = RequestMethod.GET)
    public String editInfo(Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
            return MEMBER_JSP_PATH + "editInfo";
        }
        return MEMBER_JSP_PATH + "login";
    }

    @RequestMapping(value = "/editBaseInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel editBaseInfo(String name,String sex,String introduce){
        Member loginMember = MemberUtil.getLoginMember(request);
        return memberService.editBaseInfo(loginMember,name,sex,introduce);
    }

    @RequestMapping(value = "/editOtherInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel editOtherInfo(String birthday,String qq,String wechat,String contactPhone,
                                       String contactEmail,String website){
        Member loginMember = MemberUtil.getLoginMember(request);
        return memberService.editOtherInfo(loginMember,birthday,qq,wechat,contactPhone,contactEmail,website);
    }

    @RequestMapping(value = "/avatar",method = RequestMethod.GET)
    public String avatar(){
        return MEMBER_JSP_PATH + "avatar";
    }

    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String password(Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
            return MEMBER_JSP_PATH + "changePassword";
        }
        return MEMBER_JSP_PATH + "login";
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel password(String oldPassword, String newPassword, String renewPassword){
        if(StringUtils.isEmpty(oldPassword)){
            return new ResponseModel(-1,"旧密码不能为空");
        }
        if(StringUtils.isEmpty(newPassword)){
            return new ResponseModel(-1,"新密码不能为空");
        }
        if(!newPassword.equals(renewPassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        return memberService.changepwd(loginMember,oldPassword,newPassword);
    }


    /**
     * 关注、取消关注
     * @param followWhoId
     * @return
     */
    @RequestMapping(value = "/follows/{followWhoId}",method = RequestMethod.GET)
    @ResponseBody
    public Object follows(@PathVariable(value = "followWhoId") Integer followWhoId){
        Member loginMember = MemberUtil.getLoginMember(request);
        return memberService.follows(loginMember,followWhoId);
    }


    /**
     * 查询某一用户的所有博客
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}/articles",method = RequestMethod.GET)
    public String allArticles(@PathVariable(value = "memberId") Integer memberId, Model model){
        ResponseModel articleModel = articleService.listByPage(new Page(request),null,0,memberId);
        model.addAttribute("articleModel",articleModel);
        return MEMBER_JSP_PATH + "allArticles";
    }



}
