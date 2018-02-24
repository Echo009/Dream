/*
*start code
*/
package cn.echo0.common;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class ArrayTool {
    /**
     * @param length
     * @return length长度的正整型数组
     */
    public static int[] genRandomArray(int length) {
        int[] result = new int[length];
        final int[] indexs = new int[1];
        Stream.generate(() -> new Random().nextInt(100))
                .limit(length)
                .forEach(integer ->
                        result[indexs[0]++] = integer
                );
        return result;
    }
}
