package com.jax.study.leetcode.medium;

import java.util.Stack;

/**
 * ID: 456
 * 传送门: <a href="https://leetcode-cn.com/problems/132-pattern/" />
 *
 * @author wuzheng
 * @date 2020/04/26 21:00
 */
public class W132问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{1, 2, 3, 4})); // false
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 4, 2})); // true
        System.out.println(new Solution().find132pattern(new int[]{-1, 3, 2, 0})); // true
    }

    static class Solution {

        public boolean find132pattern(int[] nums) {
            if (nums.length < 3)
                return false;
            Stack< Integer > stack = new Stack < > ();
            int[] min = new int[nums.length];
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                min[i] = Math.min(min[i - 1], nums[i]);
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > min[j]) {
                    while (!stack.isEmpty() && stack.peek() <= min[j])
                        stack.pop();
                    if (!stack.isEmpty() && stack.peek() < nums[j])
                        return true;
                    stack.push(nums[j]);
                }
            }
            return false;
        }
    }
}
