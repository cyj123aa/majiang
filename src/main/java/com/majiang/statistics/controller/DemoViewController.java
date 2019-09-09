package com.majiang.statistics.controller;

import com.majiang.statistics.service.IDemoViewService;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String index() {
        return "index.html";
    }
}
