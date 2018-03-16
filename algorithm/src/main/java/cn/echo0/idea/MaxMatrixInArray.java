/*
*start code
*/
package cn.echo0.idea;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/28 12:02
 */
public class MaxMatrixInArray {
    /**
     * 给定一个整形矩阵map,其中的值只有0和1两种，
     * 求其中全是1的所有矩形区域中，
     * 最大的矩形区域为1的数量。
     */
    private static Deque<Integer> stack = new ArrayDeque<>();

    public static int maxMatrix(int[][] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = 0;
        // 从第一行开始往下统计
        // init 
        int[] currentRow = new int[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    currentRow[j] = 0;
                    continue;
                }
                currentRow[j] += array[i][j];
            }
            // 计算最大值
            max = Math.max(countMatrix(currentRow), max);
        }
        return max;
    }

    /**
     * 单调栈求解最大矩阵
     *
     * @param currentRow
     * @return
     */
    private static int countMatrix(int[] currentRow) {
        if (currentRow == null || currentRow.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < currentRow.length; i++) {
            if (stack.isEmpty()) {
                // 栈中存放下标值，用于计算矩阵长度
                stack.push(i);
            } else if (currentRow[stack.peek()] < currentRow[i]) {
                // 当前值大于栈顶的值
                stack.push(i);
            } else {
                // 当前值小于栈顶的值，需要将栈顶的值弹出，并且计算当前栈顶高度的矩阵大小。
                // 栈顶值，作为矩阵高度
                int currentIndex = stack.pop();
                int height = currentRow[currentIndex];
                // 栈中已空 ?
                int preIndex = stack.isEmpty() ?  -1 : stack.peek() ;
                max = Math.max(max, height * (currentIndex - preIndex));
            }
        }
        // 计算剩余的
        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
            int height = currentRow[currentIndex];
            if (stack.isEmpty()) {
                // the last  element
                max = Math.max(max, height * (currentRow.length - 1 - currentIndex - 1));
            } else {
                int preIndex = stack.peek();
                // 右边界为最右，即数组长度
                max = Math.max(max, height * (currentRow.length - 1 - preIndex));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [][]map  = new int[3][];
        map[0] = new int[]{1,1,1,1};
        map[1] = new int[]{1,1,1,1};
        map[2] = new int[]{0,1,1,1};
        System.out.println(maxMatrix(map));

    }
}
