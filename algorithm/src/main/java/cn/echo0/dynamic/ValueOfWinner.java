/*
*start code
*/
package cn.echo0.dynamic;

import java.util.Arrays;

import static cn.echo0.common.ArrayTool.genRandomArray;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class ValueOfWinner {
    /**
     * 有一排正数，玩家A和玩家B都可以看到。
     * 每位玩家在拿走数字的时候，都只能在最左边或者最右边的的数选择一个
     * 玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
     * 两人都力争那到数字的总和大,并且两人都足够聪明
     * 请返回最后获胜者的分数。
     */
    // recursive
    // method 1
    public static int maxValue_1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return Math.max(f(array, 0, array.length - 1), s(array, 0, array.length - 1));
    }
    // 先手拿可以得到的最大值

    private static int f(int[] array, int i, int j) {
        // 只剩下一个数字
        if (i == j) {
            return array[i];
        }
        return Math.max(
                array[i] + s(array, i + 1, j),
                array[j] + s(array, i, j - 1)
        );
    }
    // 后手拿可以得到的最大值

    private static int s(int[] array, int i, int j) {
        // 只剩下一个，那么后手就拿不到
        if (i == j) {
            return 0;
        }
        return Math.min(
                f(array, i + 1, j),
                f(array, i, j - 1)
        );
    }
    // method 2

    public static int maxValue_2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        int temp = p(array, 0, array.length - 1);
        return Math.max(temp, sum - temp);
    }

    // 先手能拿到的最大值

    private static int p(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }
        // 只剩下两个的时候
        if (i == j - 1) {
            return Math.max(array[i], array[j]);
        }
        return Math.max(
                // 拿 i 处的数字
                array[i] + Math.min(p(array, i + 2, j), p(array, i + 1, j - 1)),
                // 拿 j 处的数字
                array[j] + Math.min(p(array, i + 1, j - 1), p(array, i, j - 2))
        );
    }

    // method 3

    public static int maxValue_3(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        int temp = dp(array);
        return Math.max(temp, sum - temp);
    }
    // dynamic program

    private static int dp(int[] array) {

        int[][] results = new int[array.length][array.length];
        // 间隔
        for (int gap = 0; gap < array.length; gap++) {
            for (int i = 0; i + gap < array.length; i++) {
                // init 在只剩一个数的情况下
                if (gap == 0) {
                    results[i][i] = array[i];
                }
                // init 在只剩两个数的情况下
                else if (gap == 1) {
                    results[i][i + 1] = Math.max(array[i], array[i + 1]);
                } else {
                    results[i][i + gap] = Math.max(
                            array[i] + Math.min(results[i + 2][i + gap], results[i + 1][i + gap - 1]),
                            // 拿 i+gap 处的数字
                            array[i + gap] + Math.min(results[i + 1][i + gap - 1], results[i][i + gap - 2])
                    );
                }

            }
        }
        return results[0][array.length - 1];
    }


    public static void main(String[] args) {
        int[] array = genRandomArray(10);
        Arrays.stream(array).forEach(value -> System.out.print(value + " "));
        System.out.println();
        System.out.println(maxValue_1(array));
        System.out.println(maxValue_2(array));
        System.out.println(maxValue_3(array));
    }
}
