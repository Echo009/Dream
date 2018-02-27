/*
*start code
*/
package cn.echo0.array;

import cn.echo0.common.ArrayTool;

import java.util.Arrays;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/25 17:22
 */
public class ArrayContainer {
    /**
     * 给定一个数组，每个位置的值代表一个高度。
     * 那么整个数组可以看做是一个直方图。
     * 如果把这个直方图当做容器的话，求这个容器可以盛多少水？
     *
     * 比如 3,1,2,4
     * 代表第一个位置的高度为3，第二个位置的高度为1....
     * 那么以这个数组为代表的容器可以装3格的水
     */
    // 重点在于将问题转化

    public  static int volumeOfWater(int [] array){

        if (array == null || array.length == 0) {
            return 0;
        }
        // 依次求出每个位置能留下的水体积
        int lMax = array[0], rMax = array[array.length-1], l, r;
        int sum = 0;
        for ( l = 1 , r = array.length - 2; l<r; ) {
            //  左边的最大值要比右边的大，那么右边当前位置储水量能确定
            if (lMax > rMax) {
                // 当前值比右边的最大值仍要大或者相等，那么当前位置是没有水的
                if (array[r] >= rMax) {
                    rMax = array[r];
                } else  {
                    sum += rMax - array[r];
                }
                r--;
            } else {
                if (array[l] >= lMax) {
                    lMax = array[l];
                } else  {
                    sum += lMax - array[l];
                }
                l++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = ArrayTool.genRandomArray(5);
        Arrays.stream(array).forEach(value -> System.out.print(value+ " "));
        System.out.println();
        System.out.println(volumeOfWater(array));
    }
}
