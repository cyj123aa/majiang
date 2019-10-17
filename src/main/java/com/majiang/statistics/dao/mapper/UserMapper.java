package com.majiang.statistics.dao.mapper;

import com.majiang.statistics.vo.LabelBO;
import com.majiang.statistics.vo.TableLableBO;
import java.util.List;

/**
 * @Author: chenyuejun
 * @Date: 2019/4/10 18:01
 */

public interface UserMapper {

   List<LabelBO> getUsers();

    List<TableLableBO> getTable();

}
