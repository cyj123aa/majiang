package com.majiang.statistics.dao.mapper;

import com.majiang.statistics.dao.model.MjHistoryBO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Author: chenyuejun
 * @Date: 2019/4/10 18:01
 */

public interface MjHistoryMapper {


   List<MjHistoryBO> getRecord();
}
