package com.majiang.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.majiang.statistics.service.EntryService;
import com.majiang.statistics.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/25 &{TIME}
 */

@Controller
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    EntryService entryService  ;



    @PostMapping("/installDay")
    @ResponseBody
    public BaseBO installDay() {
        Long id = entryService.installDay();
        System.out.println("id" + id);
        BaseBO baseBO = new BaseBO();
        baseBO.setStatus(1);
        baseBO.setMessage("插入成功");
        return baseBO;
    }


    @PostMapping("/getUser")
    @ResponseBody
    public List<LabelBO> getUser() {

        return entryService.getUser();
    }


    @PostMapping("/getTable")
    @ResponseBody
    public List<TableLableBO> getTable() {

        return entryService.getTable();
    }


    @PostMapping("/getTableData")
    @ResponseBody
    public JSONArray getTableData() {

        return entryService.getTableData();
    }

}