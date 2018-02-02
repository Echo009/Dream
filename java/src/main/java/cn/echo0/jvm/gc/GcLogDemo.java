/*
*start code
*/
package cn.echo0.jvm.gc;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class GcLogDemo {

    GcLogDemo ref;

    Byte[] memo = new Byte[2 * 1024 * 1024];

    public GcLogDemo() {

    }

    /**
     * 查看GC日志，判断存在循环引用的情况下对象是否会被回收
     * -verbose:gc -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        GcLogDemo gcLogDemo1 = new GcLogDemo();
        GcLogDemo gcLogDemo2 = new GcLogDemo();
        gcLogDemo1.ref = gcLogDemo2;
        gcLogDemo2.ref = gcLogDemo1;

        gcLogDemo1 = null;
        gcLogDemo2 = null;

    }
}
