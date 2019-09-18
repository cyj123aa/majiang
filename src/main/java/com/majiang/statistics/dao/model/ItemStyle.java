package com.majiang.statistics.dao.model;

import lombok.Data;

/**
 * @author chenyuejun
 * @descripption   样式里面的参数，可以根据需要添加字段
 * @date 2019/9/18 &{TIME}
 */
@Data
public class ItemStyle {
private Normal normal;
public ItemStyle(){
    this.normal=new Normal();
}
}
