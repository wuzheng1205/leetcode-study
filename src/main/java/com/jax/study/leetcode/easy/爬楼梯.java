package com.jax.study.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 70
 * 传送门: <a href="https://leetcode-cn.com/problems/climbing-stairs/" />
 *
 * @author wuzheng
 * @date 2020/04/19 16:42
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2)); // 2
        System.out.println(new Solution().climbStairs(3)); // 3
    }

    static class Solution {

        public int climbStairs(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp [i] = dp[i-1] + dp[i-2];
            }
            return dp[n-1];
        }
    }
}
