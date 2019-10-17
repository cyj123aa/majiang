package com.majiang.statistics.service;

import com.alibaba.fastjson.JSONArray;
import com.majiang.statistics.vo.LabelBO;
import com.majiang.statistics.vo.TableLableBO;
import java.util.List;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
public interface EntryService {


    /**
     * 插入当天开局数据
     * @return
     */
    Long installDay();

    /**
     * 获取用户下拉框
     * @return
     */
    List<LabelBO> getUser();

    /**
     * 获取列表的 标头
     * @return
     */

    List<TableLableBO>   getTable();

    /**
     * 获取列表的数据
     * @return
     */
    JSONArray getTableData();
}
