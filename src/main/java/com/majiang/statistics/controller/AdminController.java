package com.majiang.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.majiang.statistics.BO.BaseBO;
import com.majiang.statistics.BO.LabelBO;
import com.majiang.statistics.BO.TableLableBO;
import com.majiang.statistics.BO.UserBO;
import com.majiang.statistics.BO.VueData;
import com.majiang.statistics.service.MaJiangRecordService;
import java.util.List;
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
public class AdminController {

    @Autowired
    MaJiangRecordService maJiangRecordService;


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

   // @RequiresPermissions("user:show")
    @PostMapping("/vueData")
    @ResponseBody
    public VueData vueData() {
        return maJiangRecordService.vueData();
    }
  //  @RequiresPermissions("user:admin")
    @PostMapping("/vueData2")
    @ResponseBody
    public VueData vueData2() {
        return maJiangRecordService.vueData();
    }


    @PostMapping("/installDay")
    @ResponseBody
    public BaseBO installDay() {
        Long id=  maJiangRecordService.installDay();
        System.out.println("id"+id);
        BaseBO baseBO=new BaseBO();
        baseBO.setStatus(1);
        baseBO.setMessage("插入成功");
         return  baseBO;
    }


    @PostMapping("/getUser")
    @ResponseBody
    public List<LabelBO> getUser() {

        return  maJiangRecordService.getUser();
    }


    @PostMapping("/getTable")
    @ResponseBody
    public List<TableLableBO> getTable() {

        return  maJiangRecordService.getTable();
    }


    @PostMapping("/getTableData")
    @ResponseBody
    public JSONArray getTableData() {

        return  maJiangRecordService.getTableData();
    }

}
