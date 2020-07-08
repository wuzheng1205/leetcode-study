package com.jax.study.leetcode.hard;


import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 72.编辑距离
 * 传送门: <a href="https://leetcode-cn.com/problems/edit-distance/" />
 *
 * @author wuzheng
 * @date 2020/07/08 19:41
 */
public class MinDistance {

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));// 3
        System.out.println(new MinDistance().minDistance("intention", "execution"));// 5
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        // dp[i][j]表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i < n1+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n2+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] - 1) + 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

}
