package com.majiang.statistics.dao.model;

import java.util.List;
import lombok.Data;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/18 &{TIME}
 */
@Data
public class Echarts {

    /**
     * 图例
     */

    private List<String> legend;
    /**
     * 横坐标的值
     */

    private List<String> axis;

    /**
     * 纵坐标的值
     */
    private List<Series> series;

    public Echarts(List<String> legend, List<String> axis, List<Series> series) {
        this.legend = legend;
        this.axis = axis;
        this.series = series;
    }
}
