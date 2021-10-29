package com.neuqyangze.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是我目前使用比较多的类，CountDownLatch初始化时会给定一个计数，然后每次调用countDown()计数减1，
 * <p>
 * 当计数未到达0之前调用await()方法会阻塞直到计数减到0；
 * <p>
 * 使用场景：多用于划分任务由多个线程执行，例如：最近写个豆瓣爬虫，需要爬取每个电影的前五页短评，可以划分成五个线程来处理数据。通过latch.await()保证全部完成再返回。
 */

public class CountDownLatchTest {

    public static void main(String[] args) {
        try {
            latch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void latch() throws InterruptedException {
        int count = 5;
        CountDownLatch latch = new CountDownLatch(count);
        for (int x = 0; x < count; x++) {
            new Worker(x * 20, latch).start();
        }
        latch.await();
        System.out.println("全部执行完毕");
    }

    static class Worker extends Thread {
        Integer start;
        CountDownLatch latch;

        public Worker(Integer start, CountDownLatch latch) {
            this.start = start;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(start + " 已执行");
            latch.countDown();
        }
    }
}
