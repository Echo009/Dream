/*
*start code
*/
package cn.echo0.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class JconsoleTest {

    public static void main(String[] args) {
        fill(1000);
    }

    private static void fill(int i) {

        List<JconsoleTest> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(new JconsoleTest());
        }
    }
}
