/*
*start code
*/
package cn.echo0.dynamic;

import java.util.HashMap;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class MaxLengthOfSubArray {

    /**
     * 给定一个数组，值全是整数，请返回累加和为给定值K的最大数组长度
     */
    public static int maxLength_1(int[] array, int k) {
        int currentSum = 0;
        int maxLength = 0;
        int p1 = 0, p2 = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        while (p2 < array.length) {
            currentSum += array[p2];
            if (currentSum == k) {
                maxLength = maxLength < p2 - p1 + 1 ? p2 - p1 + 1 : maxLength;
            } else if (currentSum > k && p1 < array.length) {
                // 移动第一个指针
                while (currentSum > k && p1 <= p2) {
                    currentSum -= array[p1];
                    p1++;
                }
                if (currentSum == k) {
                    maxLength = maxLength < p2 - p1 + 1 ? p2 - p1 + 1 : maxLength;
                }
            }
            p2++;
        }
        return maxLength;
    }

    /**
     * 给定一个数组，包含正数和负数请返回累加和为给定值K的子数组的最大长度
     */
    public static int maxLength_2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0, -1);
        int currentSum = 0;
        int maxLength = 0;
        for (int j = 0; j < array.length; j++) {
            currentSum += array[j];
            if (map.containsKey( currentSum - k)) {
                maxLength = j - map.get(currentSum - k)  > maxLength
                        ? j - map.get(currentSum - k)  : maxLength;
            }
            if (!map.containsKey(currentSum)){
                map.put(currentSum, j);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 1, 1, 4};
        int[] array1 = new int[]{3, 4, -2, 1, 1, 1, 4,-1,1,1,1};
        System.out.println(maxLength_1(array, 7));
        System.out.println(maxLength_2(array1, 7));
    }


}
