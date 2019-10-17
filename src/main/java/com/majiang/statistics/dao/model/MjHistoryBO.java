package com.majiang.statistics.dao.model;

import java.sql.Timestamp;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/10/15 &{TIME}
 */
@Data
public class MjHistoryBO {
    private Long id;
    private Integer redEnvelope;
    private Integer rent;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp dateTime;
    private   Integer  allRent;

    public MjHistoryBO(){
        this.redEnvelope=0;
        this.rent=0;
        this.dateTime=new Timestamp(System.currentTimeMillis());
        this.allRent=0;
    }
}
