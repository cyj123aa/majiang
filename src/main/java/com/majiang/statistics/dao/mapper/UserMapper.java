package com.majiang.statistics.dao.mapper;

import com.majiang.statistics.BO.LabelBO;
import com.majiang.statistics.BO.TableLableBO;
import com.majiang.statistics.dao.model.MjHistoryBO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenyuejun
 * @Date: 2019/4/10 18:01
 */

public interface UserMapper {

   List<LabelBO> getUsers();

    List<TableLableBO> getTable();

}
