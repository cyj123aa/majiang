package com.majiang.statistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author chenyuejun
 * @descripption  启动类
 * @date 2019/9/9 &{TIME}
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.majiang.statistics.dao.mapper"})
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }

}
