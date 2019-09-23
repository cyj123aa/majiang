package com.majiang.statistics.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/23 &{TIME}
 */
public class Bayes {

    //按类别分类
    //输入：训练数据（dataSet）
    //输出：类别到训练数据的一个Map
    public Map<String, ArrayList<ArrayList<String>>> classify(ArrayList<ArrayList<String>> dataSet) {
        Map<String, ArrayList<ArrayList<String>>> map = new HashMap<String, ArrayList<ArrayList<String>>>(); //待返回的Map
        int num = dataSet.size();
        for (int i = 0; i < num; i++)  //遍历所有数据项
        {
            ArrayList<String> Y = dataSet.get(i);  //将第i个训练样本的信息取出
            String Class = Y.get(Y.size() - 1).toString();  //约定将类别信息放在最后一个字符串

            if (map.containsKey(Class)) {  //判断map中是否已经有这个类了
                map.get(Class).add(Y);
            } else {  //若没有这个类就新建一个可变长数组记录并加入map
                ArrayList<ArrayList<String>> nlist = new ArrayList<ArrayList<String>>();
                nlist.add(Y);
                map.put(Class, nlist);
            }
        }
        return map;
    }

    //计算分类后每个类对应的样本中某个特征出现的概率
    //输入：某一类别对应的数据（classdata） 目标值（value） 相应的列值（index）
    //输出:该类数据中相应列上的值等于目标值得频率
    public double CalPro_yj_c(ArrayList<ArrayList<String>> classdata, String value, int index) {
        int sum = 0;  //sum用于记录相同特征出现的频数
        int num = classdata.size();
        for (int i = 0; i < num; i++) {
            ArrayList<String> Y = classdata.get(i);
            System.out.println(Y.get(index)+"对比"+value);
            if (Y.get(index).equals(value)) {
                sum++;
            }  //相同则计数
        }

        System.out.println("第" + index + "相同的个数是" + sum + "个" + "总数是" + num + "个 概率=" + (double) sum / num);
        return (double) sum / num;  //返回频率，以频率带概率

    }

    //贝叶斯分类器主函数
    //输入：训练集（可变长数组）；待分类集
    //输出：概率最大的类别
    public String bys_Main(ArrayList<ArrayList<String>> dataSet, ArrayList<String> testSet) {
        Map<String, ArrayList<ArrayList<String>>> doc = this.classify(dataSet);  //用本class中的分类函数构造映射

        Object classes[] = doc.keySet().toArray();

        //把map中所有的key取出来（即所有类别） ，借鉴学习了object的使用（待深入了解）
        double Max_Value = 0.0;
        //最大的概率
        int Max_Class = -1;
        //用于记录最大类的编号
        for (int i = 0; i < doc.size(); i++)
        //对每一个类分别计算，本程序只有两个类
        {

            String c = classes[i].toString();
            //将类提取出
            ArrayList<ArrayList<String>> y = doc.get(c);
            System.out.println("dataSet.size()"+dataSet.size()+"y.size()"+y.size());
            //提取该类对应的数据列表
            double prob = (double) y.size() / dataSet.size();
            //计算比例
            System.out.println(c + " : " + prob);
            //输出该类的样本占总样本个数的比例！

            for (int j = 0; j < testSet.size(); j++) {
                //对每个属性计算先验概率
                double P_yj_c = CalPro_yj_c(y, testSet.get(j), j);
               // 输出中间结果以便测试
            System.out.println("now in bys_Main!!"+prob+"    "+P_yj_c);
                prob = prob * P_yj_c;
            }

            System.out.printf("P(%s | testcase) * P(testcase) = %f\n", c, prob);
            //输出分子的概率大小
            if (prob > Max_Value)
            //更新分子最大概率
            {
                Max_Value = prob;
                Max_Class = i;
                System.out.println("Max_Class"+Max_Class);
            }
        }

        return classes[Max_Class].toString();
    }
}

