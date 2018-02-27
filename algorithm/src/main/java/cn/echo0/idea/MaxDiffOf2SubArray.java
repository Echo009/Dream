/*
*start code
*/
package cn.echo0.idea;

import cn.echo0.common.ArrayTool;

import java.util.Arrays;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/27 19:51
 */
public class MaxDiffOf2SubArray {

    /**
     * 给定一个长度为N（N>1）的整形数组arr,
     * 可以划分为左右两个部分，左部分为arr[0..k],
     * 右部分为arr[k+1,n-1]，k可以取值的范围是[0,N-2]
     * 求这么多划分方案中，左部分的最大值减去右部分的最大值的绝对值中最大是多少？
     * <p>
     * <p>
     * 分析：
     * 首先最大值必定会参与运行，因为两部分囊括了整个数组，那么最终结果肯定是最大值减去某个数
     * 再者，最大值要么在左部分，要么在右部分，
     * 在左部分的时候，右边的最大值尽需要可能小，那么最小的时候必定是右部分仅包含最右边的一个数的时候，
     * 同理在右部分的时候，左边的最小值是仅包含最左边的一个数的时候。
     */

    public static int maxDiff(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // 找到最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return Math.max(max - array[0], max - array[array.length - 1]);
    }

    public static void main(String[] args) {
        int[] array = ArrayTool.genRandomArray(10);
        Arrays.stream(array).forEach(value -> System.out.print(value + " "));
        System.out.println();
        System.out.println(maxDiff(array));
    }
}
