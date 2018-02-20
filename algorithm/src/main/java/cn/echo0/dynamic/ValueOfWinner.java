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

    public static int maxValue_1(int[] array) {
        if (array==null||array.length==0){
            return -1;
        }
        return Math.max(f(array,0,array.length-1),s(array,0,array.length-1));
    }
    // 先手拿可以得到的最大值
    private static int f(int[] array, int i, int j) {
        // 只剩下一个数字
        if (i==j){
            return array[i];
        }
        return Math.max(
                array[i]+s(array,i+1,j),
                array[j]+s(array,i,j-1)
                );
    }
    // 后手拿可以得到的最大值
    private static int s(int[] array, int i, int j) {
        // 只剩下一个，那么后手就拿不到
        if (i==j){
            return 0;
        }
        return Math.min(
                f(array,i+1,j),
                f(array,i,j-1)
        );
    }

    public static void main(String[] args) {
        int [] array = genRandomArray(4);
        Arrays.stream(array).forEach(value -> System.out.print(value+" "));
        System.out.println();
        System.out.println(maxValue_1(array));
    }
}
