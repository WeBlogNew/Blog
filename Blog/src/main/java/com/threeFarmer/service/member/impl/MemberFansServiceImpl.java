package com.threeFarmer.service.member.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.dao.member.IMemberFansDao;
import com.threeFarmer.model.member.MemberFans;
import com.threeFarmer.service.member.IMemberFansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberFansServiceImpl")
public class MemberFansServiceImpl implements IMemberFansService {
    @Resource
    private IMemberFansDao memberFansDao;

    @Override
    public MemberFans find(Integer whoFollowId, Integer followWhoId) {
        return memberFansDao.find(whoFollowId,followWhoId);
    }

    /**
     * 关注
     */
    @Override
    public ResponseModel save(Integer whoFollowId, Integer followWhoId) {
        if(memberFansDao.find(whoFollowId,followWhoId) == null){
            if(memberFansDao.save(whoFollowId,followWhoId) == 1){
                return new ResponseModel(1,"关注成功");
            }
        }else {
            //已经关注了
            return new ResponseModel(0,"关注成功");
        }
        return new ResponseModel(-1,"关注失败");
    }

    /**
     * 取消关注
     */
    @Override
    public ResponseModel delete(Integer whoFollowId, Integer followWhoId) {
        if(memberFansDao.delete(whoFollowId,followWhoId) > 0){
            return new ResponseModel(1,"取消关注成功");
        }
        return new ResponseModel(-1,"取消关注失败");
    }

    /**
     * 查询关注的会员信息
     * @param page
     * @param whoFollowId
     * @return
     */
    @Override
    public ResponseModel followsList(Page page, Integer whoFollowId) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<MemberFans> list = memberFansDao.followsList(whoFollowId);
        ResponseModel model = new ResponseModel(0);
        PageInfo<MemberFans> pageInfo = new PageInfo<>(list);
        model.setData(pageInfo);
        return model;
    }

    /**
     * 查询粉丝的信息
     * @param page
     * @param followWhoId
     * @return
     */
    @Override
    public ResponseModel fansList(Page page, Integer followWhoId) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<MemberFans> list = memberFansDao.fansList(followWhoId);
        PageInfo<MemberFans> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setData(pageInfo);
        return model;
    }


}
