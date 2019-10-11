package com.majiang.statistics.util;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/29 &{TIME}
 */
public class ThreadPool {
  public   static  ThreadPoolExecutor threadPoolExecutor=  new ThreadPoolExecutor(70, 1600, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
       for (int i=0;i<1900;i++) {
           int finalI = i;
           Thread.sleep(100);
           threadPoolExecutor.execute(() -> {
               try {
                   Thread.sleep(300);
                   System.out.println("i"+ finalI);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });

       }
        threadPoolExecutor.shutdown();
        while (true) {
            System.out.println();
            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            Thread.sleep(1000);
            if(threadPoolExecutor.isTerminated()){
                System.out.println("一共花费"+(System.currentTimeMillis()-start));
                break;
            }
        }




    }


}
