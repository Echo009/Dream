package cn.echo0.concurrency;
import java.time.Duration;
import java.time.Instant;

import static java.lang.Thread.sleep;


/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class SimpleTask implements Runnable{

    private final String TASK_SEQ ;

    SimpleTask(String taskSeq){
        this.TASK_SEQ = taskSeq;
    }

    @Override
    public void run() {
        Instant start = Instant.now();
        System.out.println("Current Task is : "+ TASK_SEQ);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration usedTime = Duration.between(start,end);
        System.out.println("Task"+TASK_SEQ+" has completed in "+usedTime.toNanos()/1000_000+" milliseconds .");
    }

    public static void main(String[] args) {
         Thread thread = new Thread(new SimpleTask("1"));
         thread.start();
    }
}
