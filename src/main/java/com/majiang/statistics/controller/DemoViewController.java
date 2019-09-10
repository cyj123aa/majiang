package com.majiang.statistics.controller;

import com.majiang.statistics.dao.model.User;
import com.majiang.statistics.service.IDemoViewService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/9 &{TIME}
 */


@Controller
@RequestMapping("/demoView")

public class DemoViewController {

    @Autowired
    IDemoViewService demoViewService;

    @RequestMapping("/index")
    public String index(Model model) {
        return "index.html";
    }

    @RequestMapping("/entry")
    public String entry(Model model) {
        return "entry.html";
    }

    @PostMapping("/getList")
    @ResponseBody
    public List<User> getList(){
        System.out.println("come getList");
        // mock 数据
        List<User> users=new ArrayList<>();
        User cyj=new User();
        cyj.setMaJiang(100);
        cyj.setName("陈岳军");
        cyj.setRedEnvelope(30);
        cyj.setTotal(100+30);

        User rwg=new User();
        rwg.setMaJiang(200);
        rwg.setName("任炜刚");
        rwg.setRedEnvelope(20);
        rwg.setTotal(200+20);

        User cjb=new User();
        cjb.setMaJiang(300);
        cjb.setName("陈加倍");
        cjb.setRedEnvelope(30);
        cjb.setTotal(200+30);

        users.add(cyj);
        users.add(rwg);
        users.add(cjb);
        return users;
    }



    @PostMapping("/getList2")
    @ResponseBody
    public List<User> getList2(){
        System.out.println("come getList");
        // mock 数据
        List<User> users=new ArrayList<>();
        User cyj=new User();
        cyj.setMaJiang(100);
        cyj.setName("陈岳军");
        cyj.setRedEnvelope(30);
        cyj.setTotal(100+30);

        User rwg=new User();
        rwg.setMaJiang(200);
        rwg.setName("任炜刚");
        rwg.setRedEnvelope(20);
        rwg.setTotal(200+20);

        User cjb=new User();
        cjb.setMaJiang(300);
        cjb.setName("陈加倍");
        cjb.setRedEnvelope(30);
        cjb.setTotal(200+30);

        users.add(cyj);
        users.add(rwg);
        users.add(cjb);
        return users;
    }
}
