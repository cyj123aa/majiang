package com.majiang.statistics.controller;

import com.majiang.statistics.service.HomeService;
import com.majiang.statistics.vo.VueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/10/17 &{TIME}
 */

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;



    // @RequiresPermissions("user:show")
    @PostMapping("/vueData")
    @ResponseBody
    public VueData vueData() {
        return homeService.vueData();
    }
}
