package com.majiang.statistics.vo;

import com.majiang.statistics.dao.model.Series;
import java.util.List;
import lombok.Data;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/25 &{TIME}
 */
@Data
public class VueData {

    /**
     *  名字 一个名字一根线
     */
    private List<String> tuName;
    /**
     *  线条  y坐标集合
     */
    private List<Series> series;
    /**
     * 时间 x坐标
     */

    private  List<String> time;

}
