package com.jax.study.leetcode.easy;

/**
 * ID: 9
 * 传送门: <a href="https://leetcode-cn.com/problems/palindrome-number/" />
 *
 * @author wuzheng
 * @date 2020/03/06 14:08
 */
public class 回文数 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(10));
    }

    private static class Solution {

        /**
         * 我的：反转x，反转后的数和x相等，满足回文数；考虑率反转后的数可能超过int最大值，而且可以判断出如果反转后数溢出，那不满足回文数
         */
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            int result = 0, temp = x;
            while (x != 0) {
                int p = x % 10;
                x = x / 10;
                if (result > ((Integer.MAX_VALUE - p) / 10)) {
                    return false;
                }
                result = result * 10 + p;
            }
            return temp == result;
        }

        /**
         * 题解：通过反转x的后半部分，如果后半部分反转后与原数前半部分相等，则满足回文数
         * 例如：1221，返回后半部分21->12，原数前半部分为12，相等，满足回文数
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                // 根据题目意思，负数不是回文数
                return false;
            }
            if (x % 10 == 0 && x != 0) {
                // 如果最后一位0，要满足回文数，第一位也是0，只有0满足，其他都不满足
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            // 如果是奇数，可以将反转后的数再除10，去除中位数
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }

}


