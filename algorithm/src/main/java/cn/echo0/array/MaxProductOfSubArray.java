/*
*start code
*/
package cn.echo0.array;

/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/2/25 16:18
 */
public class MaxProductOfSubArray {
    /**
     * 子数组的最大乘积
     */
    public static double maxProductOfSubArray(double[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        double maxProduct = Double.MIN_VALUE;

        double preMaxProduct ;
        double preMinProduct ;
        //        init
        preMaxProduct = array[0];
        preMinProduct = array[0];
        maxProduct = array[0];

        for (int i = 1; i < array.length; i++) {
            double currentMax = Math.max(
                    Math.max(preMaxProduct * array[i], array[i]),
                    preMinProduct * array[i]
            );
            preMinProduct = Math.min(
                    Math.min(preMaxProduct * array[i], array[i]),
                    preMinProduct * array[i]
            );
            preMaxProduct = currentMax;
            maxProduct = Math.max(preMaxProduct, maxProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        double [] array = new double[]{10,1,100,-100,-100};
        System.out.printf("%f",maxProductOfSubArray(array));
    }
}
