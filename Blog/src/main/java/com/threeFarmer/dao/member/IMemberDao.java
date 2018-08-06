package com.threeFarmer.dao.member;

import com.threeFarmer.dao.common.IBaseDao;
import com.threeFarmer.model.member.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员DAO接口
 */
public interface IMemberDao extends IBaseDao<Member>{

    Member login(Member member);

    int loginSuccess(@Param("id") Integer id);

    int register(Member member);

    Member findById(@Param("id") Integer id);

    Member findByName(@Param("name") String name);

    Member findByEmail(@Param("email") String email);

    Member findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    int changepwd(@Param("id") Integer id, @Param("password") String password);

    List<Member> listByPage(@Param("key") String key);

    /**
     * 修改头像
     * @param id
     * @param avatar
     * @return
     */
    int updateAvatar(@Param("id") Integer id, @Param("avatar") String avatar);

    /**
     * 修改会员基本信息
     * @param member
     * @return
     */
    int editBaseInfo(Member member);

    /**
     * 修改会员其他信息
     * @param member
     * @return
     */
    int editOtherInfo(Member member);

    /**
     * 关注
     * @param id
     * @return
     */
    int follows(@Param("id") Integer id);

    /**
     * 粉丝
     * @param id
     * @return
     */
    int fans(@Param("id") Integer id);
}