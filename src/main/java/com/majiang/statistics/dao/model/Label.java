package com.majiang.statistics.dao.model;

import lombok.Data;

/**
 * @author chenyuejun
 * @descripption 样式里面的参数，可以根据需要添加字段
 * @date 2019/9/18 &{TIME}
 */
@Data
public class Label {

    private String type;
    private String name;

    public Label(String type, String name) {
        this.type = type;this.name=name;
    }
}
