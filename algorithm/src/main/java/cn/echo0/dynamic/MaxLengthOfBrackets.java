/*
*start code
*/
package cn.echo0.dynamic;


/**
 * @author Echo0
 * Email   ech0.extreme@foxmail.com
 * Time    2018/1/31 18:53
 */
public class MaxLengthOfBrackets {
    /**
     * 已知一个字符串都是由左括号（和右括号）组成，返回最长有效括号子串的长度
     */
    public static int maxLength(String brackets) {
        if (brackets == null || "".equals(brackets)) {
            return -1;
        }
        int result = 0;
        // 存储以该下标处结尾的子串长度
        int[] dp = new int[brackets.length()];
        char[] chars = brackets.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 左括号
            if (i == 0 || chars[i] == '(') {
                dp[i] = 0;
            }
            // 右括号
            else {
                // 往前移动 dp[i-1]+1 个位置判断 能否匹配上
                if (i - dp[i - 1] - 1 > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = 2 + dp[i - 1];
                    // 注意前一段是否能算入有效子串，类似于 ()()(()) 这种情况
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                } else {
                    dp[i] = 0;
                }
            }
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String brackets = "(()()(())()()(())";
        System.out.println(maxLength(brackets));
    }
}
