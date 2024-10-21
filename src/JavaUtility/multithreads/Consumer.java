package JavaUtility.multithreads;

import java.util.concurrent.BlockingQueue;

// 消费者类
class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = queue.take();  // 从队列中获取元素，如果队列为空，则阻塞
                if (value == -1) {
                    break;  // 当接收到 -1 时，退出消费循环
                }
                System.out.println("Consumed: " + value);
                Thread.sleep(1000);  // 模拟消费时间
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
