package JavaUtility.multithreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class produceandconsumer {
    public static void main(String[] args) {
        // 创建一个阻塞队列，容量为5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // 创建生产者和消费者线程
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        // 启动线程
        producerThread.start();
        consumerThread.start();

        // 等待线程执行完成
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Producer and Consumer have completed execution.");
    }
}
