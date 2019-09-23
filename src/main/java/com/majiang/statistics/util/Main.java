package com.majiang.statistics.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/23 &{TIME}
 */
public class Main {
    //主函数，读取数据库，并读入待判定数据，输出结果
    public static void main(String[] args) {
        FetchData Fdata = new FetchData();   //java对函数的调用要先声明相应的对象再调用
        Bayes bys = new Bayes();
        ArrayList<ArrayList<String>> dataSet = null; //训练数据列表
        ArrayList<String> testSet = null; //测试数据
        try{
            System.out.println("从数据库读入训练数据：");
            dataSet = Fdata.fetch_traindata();   //读取训练数据集合
            System.out.println("请输入测试数据：");
            Scanner cin = new Scanner(new BufferedInputStream(System.in));  //从标准输入输出中读取测试数据
            while(cin.hasNext())  //支持多条测试数据读取
            {
                String str = cin.nextLine();   //先读入一行
                testSet = Fdata.read_testdata(str);//将这一行进行字符串分隔解析后返回可变长数组类型
                //System.out.println(testSet);  //输出中间结果
                String ans = bys.bys_Main(dataSet, testSet);  //调用贝叶斯分类器

                System.out.println("根据判断，你今天的麻将要："+ans);  //输出结果

            }
            cin.close();
        }catch (IOException e) {  //处理异常
            e.printStackTrace();
        }
    }
}
