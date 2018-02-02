package cn.echo0.concurrency;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class ThreadPoolDemo {
    /**
     * 单线程化的线程池
     */
    private static void singleThreadPoolExecutorTest() {

        ExecutorService singleThreanPool = Executors.newSingleThreadExecutor();

        // 每个任务将按照FIFO的次序执行
        // 内部使用的是无界队列 LinkedBlockingQueue
        // 线程池中始终只有一个线程
        for (int i = 0; i < 10; i++) {
            singleThreanPool.submit(new SimpleTask(String.valueOf(i)));
        }
    }

    /**
     * 可根据需要创建线程的线程池
     */
    private static void cachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 内部使用的是 SynchronousQueue ， 不存储任务 。
        // 当有任务提交的时候，如果有空闲的线程，则由空闲线程负责处理；
        // 如果当前没有空闲的线程则会尝试新建一个线程去执行这个任务。
        // 适合执行许多耗时较短的异步任务
        // 空闲时间超过60秒的线程将被回收


        for (int i = 0; i < 100; i++) {
            cachedThreadPool.submit(new SimpleTask(String.valueOf(i)));
        }

    }

    /**
     * 含有固定线程数的线程池
     */
    private static void fixedThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1 << 5);

        // 内部使用的是无界队列 LinkedBlockingQueue
        // 线程池中的线程数量是固定的，
        // 当某个线程因为异常而被终止，则会新建一个线程来替代它，
        // 池中的线程不会被回收，除非被显式的关闭
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.submit(new SimpleTask(String.valueOf(i)));
        }

    }

    /**
     * 定时执行任务的线程池
     */

    private static void scheduledThreadPoolTest() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(8);

        // 内部使用的是 DelayedWorkQueue
        // 每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响

        // ScheduleAtFixedRate , 按照固定频率运行任务，以上一任务开始的时间计算执行间隔
        scheduledThreadPool.scheduleAtFixedRate(new SimpleTask(1+""),1,2, TimeUnit.SECONDS);

        // ScheduleWithFixedDelay , 按照固定频率运行任务，以上一任务结束的时间计算执行间隔
        scheduledThreadPool.scheduleWithFixedDelay(new SimpleTask(2+""),1,2, TimeUnit.SECONDS);

        try {
            Thread.sleep(10_000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            scheduledThreadPool.shutdown();
        }

    }


    public static void main(String[] args) {
        singleThreadPoolExecutorTest();
        cachedThreadPoolTest();
        fixedThreadPoolTest();
        scheduledThreadPoolTest();
    }

}
