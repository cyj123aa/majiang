package com.majiang.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.majiang.statistics.dao.mapper.MiddleMjHistoryMapper;
import com.majiang.statistics.dao.mapper.MjHistoryMapper;
import com.majiang.statistics.dao.mapper.UserMapper;
import com.majiang.statistics.dao.model.MiddleMjHistoryBO;
import com.majiang.statistics.dao.model.MjHistoryBO;
import com.majiang.statistics.service.EntryService;
import com.majiang.statistics.vo.LabelBO;
import com.majiang.statistics.vo.TableLableBO;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
@Service
@Slf4j
public class EntryServiceImpl implements EntryService {

    @Resource
    private MjHistoryMapper mjHistoryMapper;

    @Resource
    private MiddleMjHistoryMapper middleMjHistoryMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    public Long installDay() {
        return middleMjHistoryMapper.installDay(new MjHistoryBO());
    }

    @Override
    public List<LabelBO> getUser() {
        return userMapper.getUsers();
    }


    @Override
    public List<TableLableBO> getTable() {
        return userMapper.getTable();
    }

    @Override
    public JSONArray getTableData() {
        JSONArray jsonArray = new JSONArray();
        List<MiddleMjHistoryBO> middleMjHistoryBOS = mjHistoryMapper.getRecord();
        // 把mjHistoryBOS 根据 次数id分组
        TreeMap<Long, List<MiddleMjHistoryBO>> groupById = middleMjHistoryBOS.stream()
            .collect(Collectors.groupingBy(MiddleMjHistoryBO::getId, TreeMap::new, Collectors.toList()));

        for (Map.Entry<Long, List<MiddleMjHistoryBO>> entry : groupById.entrySet()) {
            JSONObject js = new JSONObject();

            for (MiddleMjHistoryBO mi : entry.getValue()) {
                if (null == mi.getField()) {
                    js.put("tb", 0);
                } else {
                    js.put(mi.getField(), mi.getMajiang() + mi.getRedEnvelope());
                }
            }

            jsonArray.add(js);
        }

        return jsonArray;
}







}
