/*
*start code
*/
package cn.echo0.interview.route;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/3/14 19:40
 * <p>
 * https://qq.nowcoder.com/cts/5911601/summary?id=1EBF4C7D38D645D3#4/{"uid"%3A"1EBF4C7D38D645D3"%2C"type"%3A"4"%2C"index"%3A0}
 */
public class XunBao {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        HashSet<Integer> tree = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int distance = sc.nextInt();
            map[node1-1][node2-1] = distance;
            map[node2-1][node1-1] = distance;
        }
        // init
        tree.add(0);
        int maxLen = Integer.MIN_VALUE;
        // 求最小生成树
        while (tree.size() < n) {
            int min = Integer.MAX_VALUE;
            int targetNode = -1;
            for (Integer i : tree) {
                for (int j = 0; j < n; j++) {
                    // 跳过已有节点
                    if (tree.contains(j)) {
                        continue;
                    }
                    if (map[i][j] !=0 && min > map[i][j]) {
                        targetNode = j;
                        min = map[i][j];
                    }
                }
            }
            tree.add(targetNode);
            maxLen = maxLen < min ? min : maxLen;
        }

        System.out.println(maxLen);
    }

}
