package com.majiang.statistics.service;

import com.majiang.statistics.dao.model.TrainData;
import org.springframework.ui.Model;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
public interface MaJiangRecordService {

    /**
     * 塞入需要展示数据  总战绩 平均战绩  折线图
     * @param model
     */
    void  setModel(Model model);


   String trainData(TrainData trainData);


   void insertTrainData(TrainData trainData);

}
