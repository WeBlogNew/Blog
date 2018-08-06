package com.threeFarmer.service.member;

import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.Member;

import javax.servlet.http.HttpServletRequest;

public interface IMemberService {

    /**
     * 会员登录
     * @param member
     * @param request
     * @return
     */
    ResponseModel login(Member member, HttpServletRequest request);

    Member findById(int id);

    ResponseModel register(Member member, HttpServletRequest request);
    Member findByName(String name);
    Member findByNameAndEmail(String name, String email);
    //Member manageLogin(Member member, HttpServletRequest request);
    ResponseModel update(Member member);

    ResponseModel delete(int id);

    ResponseModel listByPage(Page page, String key);

    ResponseModel changepwd(Member loginMember, int id, String password);

    ResponseModel changepwd(Member loginMember, String oldPassword, String newPassword);

    /**
     * 修改头像
     * @param member
     * @param oldAvatar 旧头像
     * @param request
     * @return
     */
    ResponseModel updateAvatar(Member member, String oldAvatar, HttpServletRequest request);

    ResponseModel editBaseInfo(Member member,String name,String sex,String introduce);

    ResponseModel editOtherInfo(Member loginMember,String birthday,String qq,String wechat,String contactPhone,
                                String contactEmail,String website);

    ResponseModel follows(Member loginMember, Integer followWhoId);

    ResponseModel isFollowed(Member loginMember, Integer followWhoId);

    ResponseModel forgetpwd(String name, String email, HttpServletRequest request);
}
