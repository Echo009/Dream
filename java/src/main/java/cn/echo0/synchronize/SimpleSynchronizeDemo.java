package cn.echo0.synchronize;


/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class SimpleSynchronizeDemo {
    private static int count = 0;

    private void synchronizedTest() {
        synchronized (this) {
            count++;
            System.out.println(count);
        }
    }
}
