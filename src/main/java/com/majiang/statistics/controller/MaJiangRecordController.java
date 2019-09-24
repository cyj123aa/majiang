package com.majiang.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.majiang.statistics.dao.model.Message;
import com.majiang.statistics.dao.model.TrainData;
import com.majiang.statistics.dao.model.User;
import com.majiang.statistics.service.MaJiangRecordService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/fetch")
    public String fetch(Model model) {

       // maJiangRecordService.setModel(model);

        return "fetch.html";
    }


    @PostMapping("/trainData")
    @ResponseBody
    public Message trainData(@RequestBody TrainData trainData) {
        Message message=new Message();
        message.setMsg(maJiangRecordService.trainData(trainData));
        return  message;
    }

    @PostMapping("/insertTrainData")
    @ResponseBody
    public Message insertTrainData(@RequestBody TrainData trainData) {

        Message message=new Message();
        maJiangRecordService.insertTrainData(trainData);
        message.setMsg("入库成功");
        return  message;
    }
}
