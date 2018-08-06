package com.threeFarmer.core.utils;

import com.threeFarmer.common.Const;
import com.threeFarmer.model.member.Member;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员 工具类
 */
public class MemberUtil {
    public static Member getLoginMember(HttpServletRequest request){
        return (Member) request.getSession().getAttribute(Const.SESSION_MEMBER);
    }

    public static void setLoginMember(HttpServletRequest request, Member member){
        request.getSession().setAttribute(Const.SESSION_MEMBER,member);
    }

    public static String judgeLoginJump(HttpServletRequest request, String redirectUrl){
        Member member = getLoginMember(request);
        if(member == null){
            String redirect = "redirect:/member/login";
            if(StringUtils.isNotEmpty(redirectUrl)){
                redirect += "?redirectUrl="+request.getContextPath() + redirectUrl;
            }
            return redirect;
        }
        return null;
    }
}
