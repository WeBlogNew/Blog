package com.threeFarmer.dao.member;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.member.MemberFans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员粉丝DAO接口
 */
public interface IMemberFansDao extends IBaseDao<MemberFans> {

    List<MemberFans> followsList(@Param("whoFollowId") Integer whoFollowId);

    List<MemberFans> fansList(@Param("followWhoId") Integer followWhoId);

    MemberFans find(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);

    Integer save(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);

    Integer delete(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);
}