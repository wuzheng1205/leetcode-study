package com.jax.study.leetcode.medium;

/**
 * ID: 11
 * 传送门: <a href="https://leetcode-cn.com/problems/container-with-most-water/" />
 *
 * @author wuzheng
 * @date 2020/04/18 10:13
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(new Solution().maxArea(new int[]{1, 2, 3, 4, 5, 6, 7})); // 12
        System.out.println(new Solution().maxArea(new int[]{1, 2, 4, 3})); // 4
    }

    static class Solution {

        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                } else {
                    --r;
                }
            }
            return ans;
        }
    }
}
