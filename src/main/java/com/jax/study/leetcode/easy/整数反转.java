package com.jax.study.leetcode.easy;

/**
 * ID: 7
 * 传送门: <a href="https://leetcode-cn.com/problems/reverse-integer/" />
 *
 * @author wuzheng
 * @date 2020/02/26 10:28
 */
public class 整数反转 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-321));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(2147483647));
        System.out.println(new Solution().reverse(-2147483648));
        System.out.println(new Solution().reverse(-2147483641));
        System.out.println(new Solution().reverse(2147483641));
        System.out.println(new Solution().reverse(0));
    }

    private static class Solution {

        /**
         * 我的方法：字符串处理(太LOW了)
         */
        public int reverse1(int x) {
            if (x == 0) {
                return 0;
            }
            // 转成字符串
            String tmp = String.valueOf(x);
            StringBuilder sb = new StringBuilder();

            boolean minusFlag = false;
            // 从尾到头遍历字符串，丢到新的字符串中
            for (int i = tmp.length() - 1; i >= 0; i--) {
                String iStr = String.valueOf(tmp.charAt(i));
                if ("-".equals(iStr)) {
                    minusFlag = true;
                    continue;
                }
                if (sb.length() > 0 || !"0".equals(iStr)) {
                    sb.append(iStr);
                }
            }
            String result = sb.toString();
            if (minusFlag) {
                // 处理负数
                result = "-" + result;
            }
            Long longResult = Long.valueOf(result);
            if (longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE) {
                // 处理溢出
                return 0;
            }

            return longResult.intValue();
        }

        public int reverse(int x) {
            int result = 0;
            boolean minusFlag = x < 0;
            while (x != 0) {
                int p = x % 10;
                x = x / 10;
                if (!minusFlag && result > ((Integer.MAX_VALUE - p) / 10)) {
                    return 0;
                }
                if (minusFlag && result < ((Integer.MIN_VALUE - p) / 10)) {
                    return 0;
                }
                result = result * 10 + p;
            }

            return result;
        }
    }

}


