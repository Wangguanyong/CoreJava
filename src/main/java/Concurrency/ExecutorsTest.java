package Concurrency;

import java.util.concurrent.*;


public class ExecutorsTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //Runnable方式提交任务，没有返回值
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        });

        //callable 方式，采用FutureTask，可以获取结果
        Callable<Long> task = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return Thread.currentThread().getId();
            }
        };
        FutureTask<Long> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());

        executorService.shutdown();
    }
}
