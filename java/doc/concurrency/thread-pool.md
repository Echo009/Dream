线程池的简单用法
================


Java 中的线程池最核心的就是`ThreadPoolExecutor` 类，关于其内部运行机制以及实现原理可以参考这篇文章 [深入剖析Java中的线程池](http://blog.echo0.cn/2017/10/26/thread-pool/)，在这里只简单陈述一些用法。

一般使用`Executors`这个工具类就可以满足日常需求（注意，生产环境下不建议使用，使用无界队列作为容器是大忌），无需自己去创建`ThreadPoolExecutor` ，当然如果要对线程池的生命周期做一些定制，比如添加日志，这样的话就必须继承`ThreadPoolExecutor` 并重写 `afterExecute` 和`beforeExecute` 等对应方法做一些扩展。

下面就简单介绍一下 `Executors` 这个工具类使用。

Executors
---------

比较常用的方法有下面这几个，返回的均是ExecutorService的实现类：

### newSingleThreadExecutor()

创建一个使用单个线程的线程池

-	线程池中始终只有一个线程
-	每个任务将按照FIFO的次序执行
-	内部使用的是无界队列 LinkedBlockingQueue

### newFixedThreadPool(int nThreads)

创建一个可重用固定线程数的线程池

-	内部使用的是无界队列 LinkedBlockingQueue
-	线程池中的线程数量是固定的，
-	当某个线程因为异常而被终止，则会新建一个线程来替代它，
-	池中的线程不会被回收，除非被显式的关闭

### newCachedThreadPool()

-	内部使用的是 SynchronousQueue ， 不存储任务 。
-	当有任务提交的时候，如果有空闲的线程，则由空闲线程负责处理；
-	如果当前没有空闲的线程则会尝试新建一个线程去执行这个任务。
-	适合执行许多耗时较短的异步任务
-	空闲时间超过60秒的线程将被回收

### newScheduledThreadPool(int corePoolSize)

创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。

-	内部使用的是 DelayedWorkQueue
-	每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响

### ExecutorService 基本用法

#### 提交任务

`submit(Runnable task)`

`execute(Runnable task)`

execute()方法实际上是Executor中声明的方法，在ThreadPoolExecutor进行了具体的实现，这个方法是ThreadPoolExecutor的核心方法，通过这个方法可以向线程池提交一个任务，交由线程池去执行。

submit()方法是在ExecutorService中声明的方法，在AbstractExecutorService就已经有了具体的实现，在ThreadPoolExecutor中并没有对其进行重写，这个方法也是用来向线程池提交任务的，但是它和execute()方法不同，它能够返回任务执行的结果，去看submit()方法的实现，会发现它实际上还是调用的execute()方法，只不过它利用了Future来获取任务执行结果

#### 关闭线程池

`shutdown()`

`shutdownNow()`

shutdown()和shutdownNow()是用来关闭线程池的, **不同在于shutdown()不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务，而shutdownNow()立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务列表（List类型）**。

ScheduledThreadPool
-------------------

ScheduledThreadPool实现了ScheduleExecutorService接口：

```java
public interface ScheduledExecutorService extends ExecutorService {

    public ScheduledFuture<?> schedule(Runnable command,
                                       long delay, TimeUnit unit);

    public <V> ScheduledFuture<V> schedule(Callable<V> callable,
                                           long delay, TimeUnit unit);

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit);

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                     long initialDelay,
                                                     long delay,
                                                     TimeUnit unit);
}
```

-	ScheduleAtFixedRate , 按照固定频率运行任务，以上一任务开始的时间计算执行间隔
-	ScheduleWithFixedDelay , 按照固定频率运行任务，以上一任务结束的时间计算执行间隔
-	schedule , 根据给定的延迟，执行一次改任务

示例代码
--------

[ThreadPoolDemo.java](https://github.com/Echo009/the-way-to-be-hero/blob/master/src/main/java/cn/echo0/concurrency/ThreadPoolDemo.java)

<small>2017年10月28日</small>