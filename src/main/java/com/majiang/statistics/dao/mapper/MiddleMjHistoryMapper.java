package com.majiang.statistics.dao.mapper;

import com.majiang.statistics.dao.model.MiddleMjHistoryBO;
import com.majiang.statistics.dao.model.MjHistoryBO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenyuejun
 * @Date: 2019/4/10 18:01
 */

public interface MiddleMjHistoryMapper {

   /**
    * 创建当天对局
    * @return
    */
 Long installDay(@Param("mjHistoryBO") MjHistoryBO mjHistoryBO);


}
