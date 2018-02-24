/*
*start code
*/
package cn.echo0.recursive;

import cn.echo0.common.ArrayTool;

import java.util.Arrays;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/23 11:49
 */
public class ReverseArray {

    /**
     * 逆序输出数组元素，使用递归
     */
    public static void printReversedArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        printCore(array,0);
    }

    private static void printCore(int[] array, int index) {
        if (index != array.length - 1 ) {
            printCore(array,index+1);
        }
        System.out.print(array[index]+" ");
        return;
    }

    public static void main(String[] args) {
        int[] array = ArrayTool.genRandomArray(10);
        Arrays.stream(array).forEach(e -> System.out.print(e+" "));
        System.out.println("\r\n---------------");
        printReversedArray(array);
    }
}
