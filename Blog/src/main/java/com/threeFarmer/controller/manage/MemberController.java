package com.threeFarmer.controller.manage;

import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller("manageMemberController")
@RequestMapping("/")
public class MemberController extends BaseController{
    private static final String MANAGE_JSP_PATH = "/manage/member/";
    @Resource
    private IMemberService memberService;


    @RequestMapping("${managePath}/member/manageList")
    //@Before(AdminLoginInterceptor.class)
    public String index(String key,Model model) {
        System.out.println("Show all members!");
        Page page = new Page(request);
        ResponseModel responseModel = memberService.listByPage(page, key);
        model.addAttribute("model",responseModel);
        model.addAttribute("key",key);
        return MANAGE_JSP_PATH + "list";
    }

}
