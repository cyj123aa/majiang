package com.majiang.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.majiang.statistics.BO.Row;
import com.majiang.statistics.dao.model.User;
import com.majiang.statistics.service.IDemoViewService;
import java.util.ArrayList;
import java.util.List;

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
        return "index2.html";
    }

    @RequestMapping("/entry")
    public String entry(Model model) {
        List<Row> rows =new ArrayList<>();
        Row r1=new Row("cyj","陈岳军");
        Row r2=new Row("rwg","任炜刚");
        Row r3=new Row("cjb","陈加倍");
        Row r4=new Row("qs","钱松");
        Row r5=new Row("scj","孙灿杰");
        Row r6=new Row("tb","台版");


        rows.add(r1);
        rows.add(r2);
        rows.add(r3);
        rows.add(r4);
        rows.add(r5);
        rows.add(r6);
        String jsonToArray = JSONObject.toJSONString(rows);
        JSONArray jsonArray = JSONObject.parseArray(jsonToArray);
        model.addAttribute("rows", jsonArray);
        return "entry.html";
    }

    @RequestMapping("/excel")
    public String excel(Model model) {
        return "excel.html";
    }


    @RequestMapping("/tu")
    public String tu(Model model) {
        List aa=new ArrayList<>();
        aa.add("陈岳军");
        aa.add("任炜刚");
        aa.add("陈加倍");
        aa.add("钱江松");
        aa.add("孙灿杰");
        String jsonToArray = JSONObject.toJSONString(aa);
        JSONArray js=JSONObject.parseArray(jsonToArray);

        List dataAll=new ArrayList<>();
        dataAll.add(124);
        dataAll.add(-1234);
        dataAll.add(-161);
        dataAll.add(80);
        dataAll.add(-410);


        List dataAverage=new ArrayList<>();
        dataAverage.add(124/4);
        dataAverage.add(-1234/5);
        dataAverage.add(-161/4);
        dataAverage.add(80/5);
        dataAverage.add(-410/3);

        model.addAttribute("tuName", js);
        model.addAttribute("dataAll", JSONObject.parseArray(JSONObject.toJSONString(dataAll)));
        model.addAttribute("dataAverage", JSONObject.parseArray(JSONObject.toJSONString(dataAverage)));


        return "data.html";
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



}
