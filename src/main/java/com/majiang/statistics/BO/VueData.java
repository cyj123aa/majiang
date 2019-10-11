package com.majiang.statistics.BO;

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
private List<String> tuName;
    private List<Series> series;

    private  List<String> time;

}
