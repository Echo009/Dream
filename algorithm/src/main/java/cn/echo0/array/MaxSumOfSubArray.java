/*
*start code
*/
package cn.echo0.array;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/23 13:23
 */
public class MaxSumOfSubArray {
    /**
     * 给定一个数组返回子数组的最大累加和
     */
    public static int maxSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int maxSum = 0;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            maxSum = maxSum < cur ? cur : maxSum;
            cur = cur < 0 ? 0 : cur;
        }
        return maxSum;
    }

    /**
     * 给定一个数组，长度大于2。找出不相交的两个子数组，情况是很多的。
     * 请返回这么多情况中，两个不相交子数组的最大和
     * <p>
     * 不相交指的是下标没有重复，值可以有重复
     */
    public static int maxSumOf2SubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] maxValue1 = new int[array.length];
        int[] maxValue2 = new int[array.length];
        // init
        maxValue1[0] = array[0];
        maxValue2[array.length - 1] = array[array.length - 1];
        // 顺序依次算出以 从1 到 i 位置中最大子数组和
        for (int i = 1; i < array.length; i++) {
            maxValue1[i] = Math.max(maxValue1[i - 1] + array[i],array[i]);
        }
        for (int i = array.length-2; i > 0 ; i--) {
            maxValue2[i] = Math.max(maxValue2[i + 1] + array[i], array[i]);
        }
        // 找出最大值
        int maxSum = 0;
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i+1; j < array.length; j++) {
                maxSum = Math.max(maxSum, maxValue1[i] + maxValue2[j]);
            }
        }
        return maxSum;
    }




    public static void main(String[] args) {
        int [] array = new int[]{1,-8,8,4,5,-5,9};
        System.out.println(maxSum(array));
        System.out.println(maxSumOf2SubArray(array));
    }
}
