package com.jax.study.leetcode.medium;

import java.math.BigDecimal;

/**
 * ID: 8
 * 传送门: <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/" />
 *
 * @author wuzheng
 * @date 2020/02/27 16:48
 */
public class 字符串转换整数 {

    public static void main(String[] args) {
//        System.out.println(new Solution().myAtoi("42"));
//        System.out.println(new Solution().myAtoi("   -42"));
//        System.out.println(new Solution().myAtoi("   +42"));
//        System.out.println(new Solution().myAtoi("4193 with words"));
//        System.out.println(new Solution().myAtoi("words and 987"));
//        System.out.println(new Solution().myAtoi("-91283472332"));
//        System.out.println(new Solution().myAtoi(""));
//        System.out.println(new Solution().myAtoi("0000dd1"));
//        System.out.println(new Solution().myAtoi("-"));
//        System.out.println(new Solution().myAtoi("+"));
//        System.out.println(new Solution().myAtoi("-0"));
//        System.out.println(new Solution().myAtoi("+0"));
//        System.out.println(new Solution().myAtoi("+1"));
//        System.out.println(new Solution().myAtoi("  89skd99"));
//        System.out.println(new Solution().myAtoi("+-2"));
//        System.out.println(new Solution().myAtoi("22+"));
//        System.out.println(new Solution().myAtoi("+0 123"));
//        System.out.println(new Solution().myAtoi("20000000000000000000"));
//        System.out.println(new Solution().myAtoi("  0000000000012345678"));
//        System.out.println(new Solution().myAtoi("-2147483647"));
        System.out.println(new Solution().myAtoi("  +0000000000012345678"));
        System.out.println(new Solution().myAtoi("0-1"));
    }

    private static class Solution {

        public int myAtoi(String str) {
            StringBuilder resultStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                // 数字：直接放到结果中
                // -/+：判断当前结果是否为空，为空：放入结果中，不为空：返回0
                // 空格：继续下次循环
                // 其他：判断当前结果是否为空，为空：返回0，不为空：结束循环
                if (Character.isDigit(str.charAt(i))) {
                    resultStr.append(str.charAt(i));
                } else if (Character.isSpaceChar(str.charAt(i))) {
                    if (resultStr.length() > 0) {
                        break;
                    }
                } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    if (resultStr.length() == 0) {
                        resultStr.append(str.charAt(i));
                    } else {
                        break;
                    }
                } else {
                    if (resultStr.length() == 0) {
                        return 0;
                    } else {
                        break;
                    }
                }
            }

            if (resultStr.length() == 0 || resultStr.toString().equals("-") || resultStr.toString().equals("+")) {
                return 0;
            }

            StringBuilder finalResultStr = new StringBuilder();
            // 去除无效的0
            int startIndex = 0;
            if (resultStr.charAt(0) == '-' || resultStr.charAt(0) == '+') {
                startIndex = 1;
                finalResultStr.append(resultStr.charAt(0));
            }
            boolean isHeader = true;

            for (int i = startIndex; i < resultStr.length(); i++) {
                if (resultStr.charAt(i) != '0' || !isHeader) {
                    finalResultStr.append(resultStr.charAt(i));
                    isHeader = false;
                }
            }

            if (finalResultStr.length() == 0 || finalResultStr.toString().equals("-") || finalResultStr.toString().equals("+")) {
                return 0;
            }

            if (finalResultStr.charAt(0) == '-' && finalResultStr.length() > 11) {
                return Integer.MIN_VALUE;
            }
            if ((finalResultStr.charAt(0) == '+' || Character.isDigit(finalResultStr.charAt(0))) && finalResultStr.length() > 11) {
                return Integer.MAX_VALUE;
            }

            Long result = Long.valueOf(finalResultStr.toString());
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            return result.intValue();
        }

    }

}


