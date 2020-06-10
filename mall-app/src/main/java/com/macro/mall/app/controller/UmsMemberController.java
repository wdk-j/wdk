package com.macro.mall.app.controller;

import com.macro.mall.app.pojo.MemberRequestParam;
import com.macro.mall.app.service.UmsMemberService;
import com.macro.mall.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/app/ums")
public class UmsMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsMemberService memberService;

    //登入
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody MemberRequestParam requestParam) {
        System.out.println(requestParam.getUsername());
        memberService.register(requestParam);
        return CommonResult.success(null,"注册成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody MemberRequestParam requestParam) {
        String token = memberService.login(requestParam);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //System.out.println(requestParam.getUsername());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
