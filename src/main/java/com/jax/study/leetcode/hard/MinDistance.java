package com.jax.study.leetcode.hard;


/**
 * ID: 72.编辑距离
 * 传送门: <a href="https://leetcode-cn.com/problems/edit-distance/" />
 *
 * @author wuzheng
 * @date 2020/07/08 19:41
 */
public class MinDistance {

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));
        System.out.println(new MinDistance().minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        // dp[i][j]表示word1截止到第i个单词转变为word2.
        int[][] dp = new int[word1.length()+1][word2.length()+1];
    }

}
