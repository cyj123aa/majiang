package com.majiang.statistics.service.impl;

import com.majiang.statistics.service.IDemoViewService;
import javax.xml.ws.ServiceMode;
import org.springframework.stereotype.Service;

/**
 * @author chenyuejun
 * @descripption  demo
 * @date 2019/9/9 &{TIME}
 */
@Service
public class IDemoViewServiceImpl implements IDemoViewService {

    @Override
    public String testThymeleaf() {
        return "aaaa";
    }
}
