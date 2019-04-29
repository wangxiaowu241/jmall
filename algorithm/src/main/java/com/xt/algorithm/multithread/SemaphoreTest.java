package com.xt.algorithm.multithread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量semaphore test
 */
public class SemaphoreTest {

  /**
   * 最大线程池数量
   */
  private static final int THREAD_COUNT = 30;
  /**
   * 创建线程池
   */
  private static final ExecutorService executorService =
      new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT, 10,
          TimeUnit.SECONDS, new LinkedBlockingQueue<>());
  /**
   * 限制同时执行的信号量数量为10个
   */
  private static final Semaphore semaphore = new Semaphore(10);

  public static void main(String[] args) {

    for (int i = 0; i < THREAD_COUNT; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is running ..." + LocalDateTime.now()
                .format(DateTimeFormatter.ISO_DATE_TIME));
            Thread.sleep(1000L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            semaphore.release();
          }
        }
      }, "Thread-" + i);
    }

  }
}
