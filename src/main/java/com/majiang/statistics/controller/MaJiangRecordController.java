package com.majiang.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.majiang.statistics.service.MaJiangRecordService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
@Controller
@RequestMapping("/mj")
public class MaJiangRecordController {
    @Autowired
    MaJiangRecordService maJiangRecordService;



    @RequestMapping("/record")
    public String tu(Model model) {



        maJiangRecordService.setModel(model);

        return "data.html";
    }

}
