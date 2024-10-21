package JavaUtility.multithreads;

import java.util.concurrent.BlockingQueue;

// 生产者类
class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Produced: " + i);
                queue.put(i);  // 将元素放入队列，如果队列满，则阻塞
                Thread.sleep(500);  // 模拟生产时间
            }
            queue.put(-1);  // -1 表示生产结束
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}