package com.majiang.statistics.controller;

import com.majiang.statistics.service.LoginService;
import com.majiang.statistics.vo.BaseBO;
import com.majiang.statistics.vo.UserBO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/25 &{TIME}
 */

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("/signOut")
    @ResponseBody
    public BaseBO signOut() {
        BaseBO baseBO = new BaseBO();
        baseBO.setStatus(1);
        baseBO.setMessage("退出成功");
        return baseBO;

    }

    @PostMapping("/login")
    @ResponseBody
    public BaseBO login(@RequestBody UserBO userBO) {
        System.out.println(userBO.getPassWord() + "-------" + userBO.getUserName());
        BaseBO baseBO = new BaseBO();
        baseBO.setStatus(1);
        // baseBO.setMessage("登录成功");

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userBO.getUserName(), userBO.getPassWord());
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            baseBO.setMessage("未知账户");
        } catch (IncorrectCredentialsException ice) {
            baseBO.setMessage("密码不正确");
        } catch (LockedAccountException lae) {
            baseBO.setMessage("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            baseBO.setMessage("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            baseBO.setMessage("用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            baseBO.setMessage("登录成功");
        } else {
            token.clear();
            baseBO.setMessage("登录失败");
        }
        return baseBO;
    }



}