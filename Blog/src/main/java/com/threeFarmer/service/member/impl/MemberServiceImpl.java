package com.threeFarmer.service.member.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.threeFarmer.common.Const;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.utils.MemberUtil;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.Md5Util;
import com.threeFarmer.core.utils.StringUtils;
import com.threeFarmer.dao.member.IMemberDao;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberFansService;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    @Resource
    private IMemberDao memberDao;
    @Resource
    private IMemberFansService memberFansService;

    @Override
    public ResponseModel login(Member member, HttpServletRequest request) {
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        Member findMember = memberDao.login(member);
        if(findMember != null){
            if(findMember.getStatus() == -1){
                return new ResponseModel(-1,"该账户已被禁用");
            }
            //登录成功更新状态
            memberDao.loginSuccess(findMember.getId());
            findMember = this.findById(findMember.getId());
            MemberUtil.setLoginMember(request,findMember);
            return new ResponseModel(3,"登录成功",request.getServletContext().getContextPath()+"/member/");
        }
        return new ResponseModel(-1,"用户名或密码错误");
    }

    @Override
    public Member findById(int id) {
        return memberDao.findById(id);
    }

    @Override
    @Transactional
    public ResponseModel register(Member member, HttpServletRequest request) {
        Member m =memberDao.findByName(member.getName());
        if(memberDao.findByName(member.getName()) != null){
            return new ResponseModel(-1,"该用户名已被注册");
        }
        if(memberDao.findByEmail(member.getEmail()) != null){
            return new ResponseModel(-1,"该邮箱已被注册");
        }
        //加密密码
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        member.setAvatar(Const.DEFAULT_AVATAR);
        //member.setPassword(member.getPassword());
        if(memberDao.register(member) == 1){

            return new ResponseModel(2,"注册成功",request.getServletContext().getContextPath()+"/member/login");
        }
        return new ResponseModel(-1,"注册失败");
    }

    @Override
    public Member findByName(String name) {
        return memberDao.findByName(name);
    }
    @Override
    public Member findByNameAndEmail(String name, String email) {
        return memberDao.findByNameAndEmail(name, email);
    }

    @Override
    public ResponseModel update(Member member) {
        if(memberDao.update(member) == 1){
            return new ResponseModel(3,"更新成功");
        }
        return new ResponseModel(-1,"更新失败");
    }

    @Override
    public ResponseModel delete(int id) {
        if(memberDao.delete(id) == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public ResponseModel listByPage(Page page, String key) {
        if (StringUtils.isNotBlank(key)){
            key = "%"+key.trim()+"%";
        }
        //分页
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<Member> list = memberDao.listByPage(key);
        PageInfo<Member> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setData(pageInfo);
        return model;
    }

    /**
     * 后台修改密码
     * @param id
     * @param password
     * @return
     */
    @Override
    public ResponseModel changepwd(Member loginMember, int id, String password) {
        if(StringUtils.isBlank(password)){
            return new ResponseModel(-1,"密码不能为空");
        }
        if(password.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        password = Md5Util.getMD5Code(password);
        if(memberDao.changepwd(id,password) == 1){
            return new ResponseModel(3,"密码修改成功");
        }
        return new ResponseModel(-1,"密码修改失败");
    }

    /**
     * 会员修改密码
     * @param loginMember
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public ResponseModel changepwd(Member loginMember, String oldPassword, String newPassword) {
        if(StringUtils.isBlank(newPassword)){
            return new ResponseModel(-1,"密码不能为空");
        }
        if(newPassword.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        oldPassword = Md5Util.getMD5Code(oldPassword);
        Member member = memberDao.findById(loginMember.getId());
        if(!oldPassword.equals(member.getPassword())){
            return new ResponseModel(-1,"旧密码错误");
        }
        return this.changepwd(loginMember,member.getId(),newPassword);
    }

    /**
     * 修改头像
     * @param member
     * @param oldAvatar 旧头像
     * @param request
     * @return
     */
    @Override
    public ResponseModel updateAvatar(Member member,String oldAvatar,HttpServletRequest request) {
        int result = memberDao.updateAvatar(member.getId(),member.getAvatar());
        if(result == 1){
            if(StringUtils.isNotEmpty(oldAvatar) && !Const.DEFAULT_AVATAR.equals(oldAvatar)){
                //头像真实路径
                String realPath = request.getServletContext().getRealPath(oldAvatar);
                //删除旧头像
                File file = new File(realPath);
                if(file.exists()){
                    file.delete();
                }
            }
            return new ResponseModel(0,"头像修改成功");
        }
        return new ResponseModel(-1,"头像修改失败，请重试");
    }


    /**
     * 修改会员基本信息
     * @param member 登录会员
     * @param name  昵称
     * @param sex  性别
     * @param introduce  个人说明
     * @return
     */
    @Override
    public ResponseModel editBaseInfo(Member member,String name,String sex,String introduce) {
        if(!StringUtils.checkNickname(member.getName())){
            return new ResponseModel(-1,"昵称只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if (name != null && !name.equals(member.getName())){
            if(this.findByName(name) != null){
                return new ResponseModel(-1,"昵称已被占用，请更换一个");
            }
        }
        member.setName(name);
        member.setSex(sex);
        member.setIntroduce(introduce);
        if(memberDao.editBaseInfo(member) == 1){
            return new ResponseModel(0,"修改成功");
        }
        return new ResponseModel(-1,"修改失败");
    }

    /**
     * 修改会员其他信息
     * @param loginMember 登录会员
     * @param birthday
     * @param qq
     * @param wechat
     * @param contactPhone
     * @param contactEmail
     * @param website
     * @return
     */
    @Override
    public ResponseModel editOtherInfo(Member loginMember,String birthday,String qq,String wechat,String contactPhone,
                                       String contactEmail,String website) {
        loginMember.setBirthday(birthday);
        loginMember.setQq(qq);
        loginMember.setWechat(wechat);
        loginMember.setContactPhone(contactPhone);
        loginMember.setContactEmail(contactEmail);
        loginMember.setWebsite(website);
        if(memberDao.editOtherInfo(loginMember) == 1){
            return new ResponseModel(0,"修改成功");
        }
        return new ResponseModel(-1,"修改失败");
    }


    @Transactional
    @Override
    public ResponseModel follows(Member loginMember, Integer followWhoId) {
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        if(this.findById(followWhoId) == null){
            return new ResponseModel(-1,"关注的会员不存在");
        }
        if(loginMember.getId().intValue() == followWhoId.intValue()){
            return new ResponseModel(-1,"不能关注自己");
        }
        if(memberFansService.find(loginMember.getId(),followWhoId) == null){
            //关注
            memberFansService.save(loginMember.getId(),followWhoId);
            memberDao.follows(loginMember.getId());
            memberDao.fans(followWhoId);
            return new ResponseModel(1,"关注成功");
        }else {
            //取消关注
            memberFansService.delete(loginMember.getId(),followWhoId);
            memberDao.follows(loginMember.getId());
            memberDao.fans(followWhoId);
            return new ResponseModel(0,"取消关注成功");
        }
    }

    @Override
    public ResponseModel isFollowed(Member loginMember, Integer followWhoId) {
        int loginMemberId = 0;
        if(loginMember != null){
            loginMemberId = loginMember.getId();
        }
        if(memberFansService.find(loginMemberId,followWhoId) == null){
            return new ResponseModel(0,"未关注");
        }else {
            return new ResponseModel(1,"已关注");
        }
    }

    @Override
    public ResponseModel forgetpwd(String name, String email, HttpServletRequest request) {
        return null;
    }

}
