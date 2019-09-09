package com.majiang.statistics.dao.model;

/**
 * @author chenyuejun
 * @descripption demo
 * @date 2019/9/9 &{TIME}
 */
public class User {

    /**
     * 名字
     */
    private String name;
    /**
     * 麻将输赢
     */
    private Integer maJiang;
    /**
     * 红包
     */
    private Integer redEnvelope;
    /**
     * 总计
     */
    private Integer total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaJiang() {
        return maJiang;
    }

    public void setMaJiang(Integer maJiang) {
        this.maJiang = maJiang;
    }

    public Integer getRedEnvelope() {
        return redEnvelope;
    }

    public void setRedEnvelope(Integer redEnvelope) {
        this.redEnvelope = redEnvelope;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
