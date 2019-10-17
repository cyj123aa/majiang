package com.majiang.statistics.dao.mapper;

import com.majiang.statistics.dao.model.TrainData;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenyuejun
 * @Date: 2019/4/10 18:01
 */

public interface TrainDataMapper {


   void insertTrainData(@Param("trainData") TrainData trainData);
}
