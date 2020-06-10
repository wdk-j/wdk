package com.macro.mall.app.service;

import com.macro.mall.app.pojo.MemberRequestParam;
import org.springframework.security.core.userdetails.UserDetails;

public interface UmsMemberService {
    UserDetails loadUserByUsername(String username);

    void register(MemberRequestParam requestParam);

    String login(MemberRequestParam memberRequestParam);
}
