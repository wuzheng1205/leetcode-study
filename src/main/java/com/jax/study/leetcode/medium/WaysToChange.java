package com.jax.study.leetcode.medium;

/**
 * ID: 面试题 08.11. 硬币
 * 传送门: <a href="https://leetcode-cn.com/problems/coin-lcci/" />
 *
 * @author wuzheng
 * @date 2020/07/19 14:57
 */
public class WaysToChange {


    public static void main(String[] args) {
        System.out.println(new WaysToChange.Solution().waysToChange(5));
        System.out.println(new WaysToChange.Solution().waysToChange(10));
    }

    private static class Solution {
        public int waysToChange(int n) {
            int[] dp = new int[n + 1];
            int[] coins = new int[]{1, 5, 10, 25};

            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= n; i++) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }

            return dp[n];
        }
    }
}
