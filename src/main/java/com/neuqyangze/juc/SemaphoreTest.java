package com.neuqyangze.juc;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号量维护了一个许可集,每次使用时执行acquire()从Semaphore获取许可，如果没有则会阻塞，每次使用完执行release()释放许可。
 * <p>
 * 使用场景：Semaphore对用于对资源的控制，比如数据连接有限，使用Semaphore限制访问数据库的线程数。
 */
public class SemaphoreTest {

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
        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int x = 0; x < count; x++) {
            executorService.execute(new Worker(x, semaphore));
        }
        System.in.read();
    }

    static class Worker extends Thread {
        Integer start;
        Semaphore semaphore;

        public Worker(Integer start, Semaphore semaphore) {
            this.start = start;
            this.semaphore = semaphore;
        }

        @Override
        public void run() throws IllegalArgumentException {
            try {
                System.out.println(start + " 准备执行");
                TimeUnit.SECONDS.sleep(3);
                semaphore.acquire();
                System.out.println(start + " 已经执行");
                semaphore.release();
                System.out.println(start + " 已经释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
