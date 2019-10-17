package com.majiang.statistics.controller;

import com.majiang.statistics.BO.SignOut;
import com.majiang.statistics.BO.UserBO;
import com.majiang.statistics.BO.VueData;
import com.majiang.statistics.service.MaJiangRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("info")
    @ResponseBody
    public Object getInfo() {
        SignOut signOut = new SignOut();
        signOut.setStatus(1);
        return signOut;
    }


    @PostMapping("/signOut")
    @ResponseBody
    public SignOut signOut() {
        SignOut signOut=new SignOut();
        signOut.setStatus(1);
        signOut.setMessage("退出成功");
        return signOut;

    }

    @PostMapping("/login")
    @ResponseBody
    public SignOut login(@RequestBody UserBO userBO) {
        System.out.println(userBO.getPassWord()+"-------"+userBO.getUserName());
        SignOut signOut=new SignOut();
        signOut.setStatus(1);
        signOut.setMessage("登录成功");
        return signOut;

    }


    @PostMapping("/vueData")
    @ResponseBody
    public VueData vueData() {
        return    maJiangRecordService.vueData();

    }


}
