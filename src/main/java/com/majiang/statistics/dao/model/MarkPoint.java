package com.majiang.statistics.dao.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/26 &{TIME}
 */
@Data
public class MarkPoint {
   private List<Label> data;
public MarkPoint(){
     List<Label> labels=new ArrayList<>();
    labels.add(new Label("max","最大值"));
    labels.add(new Label("min","最小值"));
    this.data=labels;
}
}
