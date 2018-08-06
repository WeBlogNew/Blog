package com.threeFarmer.controller.front;

import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.MemberUtil;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.article.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController {
    private static final String FRONT_JSP_PATH = "/front/";
    @Resource
    private IArticleService articleService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            model.addAttribute("loginUser",loginMember);
        }
        ResponseModel articleModel = articleService.listByPage(new Page(request),null,0,null);
        model.addAttribute("articleModel",articleModel);
        return FRONT_JSP_PATH + "index";
    }
}
