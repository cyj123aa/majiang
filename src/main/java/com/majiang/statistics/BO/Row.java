package com.majiang.statistics.BO;

import lombok.Data;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/24 &{TIME}
 */
@Data
public class Row {
private String field;
    private String title;
    public Row(String field,String title){
        this.field=field;
        this.title=title;
    }
}
