/*
*start code
*/
package cn.echo0.base.search;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/3/14 15:19
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param array
     * @return
     */
    public static int search(int[] array, int k) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0, r = array.length - 1;
        int mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(array,0));
    }
}
