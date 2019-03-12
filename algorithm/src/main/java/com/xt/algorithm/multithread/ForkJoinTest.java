package com.xt.algorithm.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * fork join 框架 test
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //计算1-10的和

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 10);
        ForkJoinTask<Integer> task = forkJoinPool.submit(countTask);
        System.out.println(task.get());
    }

    static class CountTask extends RecursiveTask<Integer> {
        private static final int THREAD_HOLS = 2;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            int sum = 0;
            if (end - start <= THREAD_HOLS) {
                //任务切分足够小
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                //切分任务
                int middle = start + (end - start) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);
                leftTask.fork();
                rightTask.fork();
                Integer leftResult = leftTask.join();
                Integer rightResult = rightTask.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }
    }
}
