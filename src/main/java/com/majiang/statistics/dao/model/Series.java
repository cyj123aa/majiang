package com.majiang.statistics.dao.model;

import java.util.List;
import lombok.Data;

/**
 * @author chenyuejun
 * @descripption 前端 series    data 类  纵坐标的内容
 * @date 2019/9/18 &{TIME}
 */
@Data
public class Series {

    /**
     * 线的名字
     */
    private String name;
    /**
     * line
     */
    private String type;
    /**
     * 线的点数值
     */
    private List<Integer> data;
    /**
     * 线的样式
     */
    private ItemStyle itemStyle;

    public Series(String name, String type, List<Integer> data) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.itemStyle = new ItemStyle();
    }


}
