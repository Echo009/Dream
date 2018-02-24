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

    public static void main(String[] args) {
        int [] array = new int[]{1,-8,8,4,5,-5};
        System.out.println(maxSum(array));
    }
}
