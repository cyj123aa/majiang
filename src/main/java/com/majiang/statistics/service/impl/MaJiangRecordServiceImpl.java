package com.majiang.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.majiang.statistics.BO.LabelBO;
import com.majiang.statistics.BO.TableLableBO;
import com.majiang.statistics.BO.VueData;
import com.majiang.statistics.dao.mapper.MiddleMjHistoryMapper;
import com.majiang.statistics.dao.mapper.MjHistoryMapper;
import com.majiang.statistics.dao.mapper.TrainDataMapper;
import com.majiang.statistics.dao.mapper.UserMapper;
import com.majiang.statistics.dao.model.Echarts;
import com.majiang.statistics.dao.model.MiddleMjHistoryBO;
import com.majiang.statistics.dao.model.MjHistoryBO;
import com.majiang.statistics.dao.model.Series;
import com.majiang.statistics.dao.model.TrainData;
import com.majiang.statistics.service.MaJiangRecordService;
import com.majiang.statistics.util.Bayes;
import com.majiang.statistics.util.FetchData;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;


/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/17 &{TIME}
 */
@Service
@Slf4j
public class MaJiangRecordServiceImpl implements MaJiangRecordService {

    @Resource
    private MjHistoryMapper mjHistoryMapper;

    @Resource
    private TrainDataMapper trainDataMapper;
    @Resource
    private MiddleMjHistoryMapper middleMjHistoryMapper;

    @Resource
    private UserMapper  userMapper;
    @Override
    public void setModel(Model model) {
        //名字的集合 --通用
        List names = new ArrayList<>();

        List<MiddleMjHistoryBO> middleMjHistoryBOS = mjHistoryMapper.getRecord();
        //根据名字分组
        log.info("middleMjHistoryBOS={}", middleMjHistoryBOS);

        Map<String, List<MiddleMjHistoryBO>> groupBy = middleMjHistoryBOS.stream().collect(Collectors.groupingBy(MiddleMjHistoryBO::getName));
        //塞入柱状图需要的数据
        setHistogram(names, groupBy, model);

        //-------折线图
        setLineChart(middleMjHistoryBOS, groupBy, names, model);
    }

    @Override
    public VueData vueData(){
        VueData vueData=new VueData();
        List names = new ArrayList<>();

        List<MiddleMjHistoryBO> middleMjHistoryBOS = mjHistoryMapper.getRecord();
        //根据名字分组
        log.info("middleMjHistoryBOS={}", middleMjHistoryBOS);

        Map<String, List<MiddleMjHistoryBO>> groupBy = middleMjHistoryBOS.stream().collect(Collectors.groupingBy(MiddleMjHistoryBO::getName));

        // 总盈亏的集合--总盈亏柱状图
        List recordAll = new ArrayList<>();
        // 平均盈亏的集合--平均盈亏列表柱状图
        List recordAverage = new ArrayList<>();
        // 总盈亏的集合--总盈亏带红包柱状图
        List recordAllRed = new ArrayList<>();
        // 平均盈亏的集合--平均盈亏带红包柱状图
        List recordAverageRed = new ArrayList<>();
        //便利map
        for (Map.Entry<String, List<MiddleMjHistoryBO>> entry : groupBy.entrySet()) {
            names.add(entry.getKey());
            recordAll.add(sumByListMj(entry.getValue()));
            recordAverage.add(avgByListMj(entry.getValue()));
            recordAllRed.add(sumByListMjHaveRed(entry.getValue()));
            recordAverageRed.add(avgByListMjHaveRed(entry.getValue()));
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<String> axis = new ArrayList<>();
        // 把mjHistoryBOS 根据 次数id分组
        TreeMap<Long, List<MiddleMjHistoryBO>> groupById = middleMjHistoryBOS.stream()
            .collect(Collectors.groupingBy(MiddleMjHistoryBO::getHistoryId, TreeMap::new, Collectors.toList()));
        //便利map

        //累计数据
        List<Series> seriesSum = new ArrayList<>();
        //累计数据
        List<Series> series = new ArrayList<>();

        //主场次id 集合
        List<Long> historyId = new ArrayList<>();
        for (Map.Entry<Long, List<MiddleMjHistoryBO>> entry : groupById.entrySet()) {
            //找到每一场的时间，作为表格的x坐标
            if (!CollectionUtils.isEmpty(entry.getValue())) {
                axis.add(df.format(entry.getValue().get(0).getData()));
            }
            //找到每一场的id  用来寻找 某些人不参与的比赛，归零处理。
            historyId.add(entry.getKey());
        }

        // series 线数据封装
        getSeries(series, seriesSum, groupBy, historyId);
        vueData.setSeries(seriesSum);
        vueData.setTuName(names);
        vueData.setTime(axis);
        return vueData;
    }
    @Override
    public String trainData(TrainData trainData) {

        FetchData Fdata = new FetchData();
        //java对函数的调用要先声明相应的对象再调用
        Bayes bys = new Bayes();
        ArrayList<ArrayList<String>> dataSet = null;
        //训练数据列表
        ArrayList<String> testSet = new ArrayList<>();
        //测试数据
        System.out.println("从数据库读入训练数据：");
        dataSet = Fdata.fetch_traindata();
        //读取训练数据集合
        System.out.println("请输入测试数据：");
        /*
         *        str = rs.getString("name");
         *                 str = rs.getString("eat");
         *                 str = rs.getString("phone");
         *                 str = rs.getString("smoking");
         *                 str = rs.getString("week");
         *                 str = rs.getString("bt");
         *                 str = rs.getString("not_in");
         *                 str = rs.getString("rent");
         *                 str = rs.getString("girlfriend");
         *                 str = rs.getString("health");
         *                 str = rs.getString("no");
         *                 str = rs.getString("win");
         */
        testSet.add(trainData.getName());
        testSet.add(trainData.getEat());
        testSet.add(trainData.getPhone());
        testSet.add(trainData.getSmoking());
        testSet.add(trainData.getWeek());
        testSet.add(trainData.getBt());
        testSet.add(trainData.getNotIn());
        testSet.add(trainData.getRent());
        testSet.add(trainData.getGirlfriend());
        testSet.add(trainData.getHealth());
        testSet.add(trainData.getNo());



        //从标准输入输出中读取测试数据
        String ans = bys.bys_Main(dataSet, testSet);
        //调用贝叶斯分类器
        System.out.println("根据判断，你今天的麻将要：" + ans);
        //输出结果
        return "根据判断，你今天的麻将要：" + ans;
    }
    @Override
    public  Long   installDay() {
        return middleMjHistoryMapper.installDay(new MjHistoryBO());
    }

    @Override
    public List<LabelBO> getUser(){


        return userMapper.getUsers();
    }


    @Override
    public List<TableLableBO>   getTable(){


        return userMapper.getTable();
    }
    @Override
    public JSONArray  getTableData(){
        JSONArray jsonArray = new JSONArray();
        List<MiddleMjHistoryBO> middleMjHistoryBOS = mjHistoryMapper.getRecord();
        // 把mjHistoryBOS 根据 次数id分组
        TreeMap<Long, List<MiddleMjHistoryBO>> groupById = middleMjHistoryBOS.stream()
            .collect(Collectors.groupingBy(MiddleMjHistoryBO::getId, TreeMap::new, Collectors.toList()));

        for (Map.Entry<Long, List<MiddleMjHistoryBO>> entry : groupById.entrySet()) {
            JSONObject js=new JSONObject();

                for (MiddleMjHistoryBO mi : entry.getValue()) {
                    if(null==mi.getField()){
                        js.put("tb",0);
                    }else{
                        js.put(mi.getField(),mi.getMajiang()+mi.getRedEnvelope());
                    }
                }

            jsonArray.add(js);
        }

        return jsonArray;
    }

    @Override
    public  void   insertTrainData(TrainData trainData){
        trainDataMapper.insertTrainData(trainData);
    }

    /**
     * 填充柱状图需要的数据
     */
    private void setHistogram(List names, Map<String, List<MiddleMjHistoryBO>> groupBy, Model model) {

        // 总盈亏的集合--总盈亏柱状图
        List recordAll = new ArrayList<>();
        // 平均盈亏的集合--平均盈亏列表柱状图
        List recordAverage = new ArrayList<>();
        // 总盈亏的集合--总盈亏带红包柱状图
        List recordAllRed = new ArrayList<>();
        // 平均盈亏的集合--平均盈亏带红包柱状图
        List recordAverageRed = new ArrayList<>();
        //便利map
        for (Map.Entry<String, List<MiddleMjHistoryBO>> entry : groupBy.entrySet()) {
            names.add(entry.getKey());
            recordAll.add(sumByListMj(entry.getValue()));
            recordAverage.add(avgByListMj(entry.getValue()));
            recordAllRed.add(sumByListMjHaveRed(entry.getValue()));
            recordAverageRed.add(avgByListMjHaveRed(entry.getValue()));
        }
        log.info("tuName={}", names);
        log.info("dataAll={}", names);
        log.info("dataAverage={}", recordAverage);
        model.addAttribute("tuName", objToJsonArray(names));
        model.addAttribute("dataAll", objToJsonArray(recordAll));
        model.addAttribute("dataAverage", objToJsonArray(recordAverage));
        model.addAttribute("dataAllRed", objToJsonArray(recordAllRed));
        model.addAttribute("dataAverageRed", objToJsonArray(recordAverageRed));
    }

    /**
     *
     * @param middleMjHistoryBOS
     * @param groupBy
     * @param names
     * @param model
     */
    private void setLineChart(List<MiddleMjHistoryBO> middleMjHistoryBOS, Map<String, List<MiddleMjHistoryBO>> groupBy, List names, Model model) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<String> axis = new ArrayList<>();
        // 把mjHistoryBOS 根据 次数id分组
        TreeMap<Long, List<MiddleMjHistoryBO>> groupById = middleMjHistoryBOS.stream()
            .collect(Collectors.groupingBy(MiddleMjHistoryBO::getHistoryId, TreeMap::new, Collectors.toList()));
        //便利map

        //数据
        List<Series> series = new ArrayList<>();
        //累计数据
        List<Series> seriesSum = new ArrayList<>();

        //主场次id 集合
        List<Long> historyId = new ArrayList<>();
        for (Map.Entry<Long, List<MiddleMjHistoryBO>> entry : groupById.entrySet()) {
            //找到每一场的时间，作为表格的x坐标
            if (CollectionUtils.isEmpty(entry.getValue())) {
                axis.add(df.format(entry.getValue().get(0).getData()));
            }
            //找到每一场的id  用来寻找 某些人不参与的比赛，归零处理。
            historyId.add(entry.getKey());
        }

        // series 线数据封装
        getSeries(series, seriesSum, groupBy, historyId);

        Echarts echarts = new Echarts(names, axis, seriesSum);

        model.addAttribute("echarts", objToJsonObject(echarts));
    }


    /**
     * 折线图每个线的数据封装  总数和每一局
     */
    private void getSeries(List<Series> series, List<Series> seriesSum, Map<String, List<MiddleMjHistoryBO>> groupByName, List<Long> historyIds) {

        //便利根据名字分组的集合
        for (Map.Entry<String, List<MiddleMjHistoryBO>> entry : groupByName.entrySet()) {
            //把集合里面的数据 tomap  场次为key
            Map<Long, MiddleMjHistoryBO> groupByHistoryId = entry.getValue().stream()
                .collect(Collectors.toMap(MiddleMjHistoryBO::getHistoryId, a -> a, (k1, k2) -> k1));
            //线上的数据
            List<Integer> data = new ArrayList<>();
            //线上的数据 可添加不同的list集合
            List<Integer> dataSum = new ArrayList<>();
            //线上的数据
            List<Integer> winRate = new ArrayList<>();
            //战绩初始值 用于计算总数
            int i = 0;
            //便利场次
            for (Long historyId : historyIds) {
                MiddleMjHistoryBO middleMjHistoryBO = groupByHistoryId.get(historyId);
                if (null != middleMjHistoryBO) {
                    //试试更新数据  加上红包的实时数据
                    i = i + middleMjHistoryBO.getMajiang() + middleMjHistoryBO.getRedEnvelope();
                    //当天场次的数据，可控制加不加红包
                    data.add(middleMjHistoryBO.getMajiang());
                    winRate.add(middleMjHistoryBO.getMajiang());
                } else {
                    //未参加当日场
                    data.add(0);
                }
                //添加当天场次结束后的 战绩
                dataSum.add(i);
            }

            //封装
            series.add(new Series(entry.getKey(), "line", data));
            seriesSum.add(new Series(entry.getKey(), "line", dataSum));
            //胜率
            //winRate.size()
            List<Integer> loser = winRate.stream()
                .filter(a -> a < 0)
                .collect(Collectors.toList());

            DecimalFormat df = new DecimalFormat("0.00");
            double win = winRate.size() - loser.size();
            double all = winRate.size();

            log.info("名字={}，输={}，赢={}， 胜率={}，参团率={}", entry.getKey(), loser.size(), win, df.format(win / all),
                df.format(all / historyIds.size()));
        }
    }


    /**
     * 转json
     */
    private JSONArray objToJsonArray(Object obj) {
        String jsonToArray = JSONObject.toJSONString(obj);
        JSONArray jsonArray = JSONObject.parseArray(jsonToArray);
        return jsonArray;
    }

    /**
     * 转json
     */
    private JSONObject objToJsonObject(Object obj) {
        String jsonToArray = JSONObject.toJSONString(obj);
        JSONObject jsonArray = JSONObject.parseObject(jsonToArray);
        return jsonArray;
    }

    /**
     * 计算总和
     */
    private Integer sumByListMj(List<MiddleMjHistoryBO> middleMjHistoryBOS) {
        return middleMjHistoryBOS.stream().map(MiddleMjHistoryBO::getMajiang).reduce(0, Integer::sum);
    }

    /**
     * 计算总和带红包
     */
    private Integer sumByListMjHaveRed(List<MiddleMjHistoryBO> middleMjHistoryBOS) {
        Integer sum = sumByListMj(middleMjHistoryBOS);
        Integer red = middleMjHistoryBOS.stream().map(MiddleMjHistoryBO::getRedEnvelope).reduce(0, Integer::sum);

        return sum + red;
    }

    /**
     * 计算平均
     */
    private Integer avgByListMj(List<MiddleMjHistoryBO> middleMjHistoryBOS) {
        return sumByListMj(middleMjHistoryBOS) / middleMjHistoryBOS.size();
    }

    /**
     * 计算平均带红包
     */
    private Integer avgByListMjHaveRed(List<MiddleMjHistoryBO> middleMjHistoryBOS) {
        return sumByListMjHaveRed(middleMjHistoryBOS) / middleMjHistoryBOS.size();
    }
}
