package com.threeFarmer.service.member;

import com.threeFarmer.core.Page;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.MemberFans;

public interface IMemberFansService {

    ResponseModel save(Integer whoFollowId, Integer followWhoId);

    ResponseModel delete(Integer whoFollowId, Integer followWhoId);

    ResponseModel followsList(Page page, Integer whoFollowId);

    ResponseModel fansList(Page page, Integer followWhoId);

    MemberFans find(Integer whoFollowId, Integer followWhoId);
}
