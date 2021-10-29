package com.neuqyangze.juc;

import java.io.IOException;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Exchanger 用于两个线程间的数据交换，它提供一个同步点，在这个同步点两个线程可以交换彼此的数据。
 * <p>
 * 使用场景：两个线程相互等待处理结果并进行数据传递。
 * <p>
 * Exchanger必须成对出现，否则会像上面代码执行结果那样，pool-1-thread-5一直阻塞等待与其交换数据的线程，为了避免这一现象，可以使用exchange(V x, long timeout, TimeUnit unit)设置最大等待时长
 */
public class ExchangerTest {

    public static void main(String[] args) {
        try {
            latch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void latch() throws InterruptedException, IOException {
        int count = 5;
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int x = 0; x < count; x++) {
            executorService.execute(new Worker(x, exchanger));
        }
        System.in.read();
    }

    static class Worker extends Thread {
        Integer start;
        Exchanger<String> exchanger;

        public Worker(Integer start, Exchanger<String> exchanger) {
            this.start = start;
            this.exchanger = exchanger;
        }

        @Override
        public void run() throws IllegalArgumentException {
            try {
                System.out.println(Thread.currentThread().getName() + " 准备执行");
                TimeUnit.SECONDS.sleep(start);
                System.out.println(Thread.currentThread().getName() + " 等待交换");
                String value = exchanger.exchange(Thread.currentThread().getName(), 2L, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + " 交换得到数据为：" + value);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
