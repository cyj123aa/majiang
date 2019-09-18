package com.majiang.statistics.dao.model;

import java.sql.Timestamp;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
@Data
public class MjHistoryBO {

    private String name;
    private Integer redEnvelope;
    private Integer majiang;
    private   Long  historyId;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Timestamp data;
    private   Long  userId;
}
