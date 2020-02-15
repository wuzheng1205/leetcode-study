package com.java.leetcode;

import java.util.Arrays;

/**
 * ID: 62
 * 传送门: <a href="https://leetcode-cn.com/problems/unique-paths/" />
 * 还可以使用递归求解
 *
 * @author wuzheng
 * @date 2019/7/11 15:29
 */
public class 不同路径 {

    public static void main(String[] args) {

//        System.out.println(new Solution().uniquePaths_1(3, 3));
        System.out.println(new Solution().uniquePaths(3, 3));
    }

    private static class Solution {

        /**
         * 普通递归, 空间复杂度过高
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            for (int i = 0; i < dp.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }

            return dp[m - 1][n - 1];
        }

        public int uniquePaths_1(int m, int n) {
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            System.out.println(Arrays.toString(dp));
            for (int i = 1; i < m; i++) {
                dp[0] = 1;
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }

            System.out.println(Arrays.toString(dp));

            return dp[n - 1];
        }

    }

}


