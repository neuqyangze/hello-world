package com.neuqyangze.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)也就是阻塞在调用cyclicBarrier.await()的地方。
 * <p>
 * 看上去CyclicBarrier 跟CountDownLatch 功能上类似，在官方doc上CountDownLatch的描述上就说明了，CountDownLatch 的计数无法被重置，
 * <p>
 * 如果需要重置计数，请考虑使用CyclicBarrier。
 * <p>
 * CyclicBarrier初始时还可添加一个Runnable的参数， 此Runnable在CyclicBarrier的数目达到后，所有其它线程被唤醒前被最后一个进入 CyclicBarrier 的线程执行
 * <p>
 * 使用场景：类似跟CountDownLatch，但是 CyclicBarrier提供了几个countdownlatch 没有的方法以应付更复杂的场景，例如：
 * <p>
 * getNumberWaiting() 获取阻塞线程数量，
 * <p>
 * isBroken() 用来知道阻塞的线程是否被中断等方法。
 * <p>
 * reset() 将屏障重置为其初始状态。如果所有参与者目前都在屏障处等待，则它们将返回，同时抛出一个 BrokenBarrierException。
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        try {
            latch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void latch() throws InterruptedException {
        int count = 5;
        CyclicBarrier cb = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部执行完毕");
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        while (true) {
            for (int x = 0; x < count; x++) {
                executorService.execute(new Worker(x, cb));
            }
        }
    }

    static class Worker extends Thread {
        Integer start;
        CyclicBarrier cyclicBarrier;

        public Worker(Integer start, CyclicBarrier cyclicBarrier) {
            this.start = start;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(start + " 已执行");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
