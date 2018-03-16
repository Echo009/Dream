/*
*start code
*/
package cn.echo0.interview.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/3/14 20:50
 * <p>
 * https://qq.nowcoder.com/cts/5911601/summary?id=1EBF4C7D38D645D3#4/{"uid"%3A"1EBF4C7D38D645D3"%2C"type"%3A"4"%2C"index"%3A1}
 */
public class Coins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int currentValue = 0;
        int currentQulity =0 ;
        for (int i = 0; i < n; i++) {
            if (currentValue < target) {
                currentValue += array[i];
                currentQulity ++;
            } else {
                int l = 0;
                while (currentValue - array[l] > target) {
                    currentQulity--;
                    currentValue -= array[l++];
                }
                System.out.println(currentQulity);
                return;
            }
        }
    }
}
