package com.jax.study.leetcode.medium;

/**
 * ID: 面试题42
 * 传送门: https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * @author wuzheng
 * @date 2020/06/16 21:56
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    private static class Solution {

        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int i = 0; i < nums.length; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                maxAns = Math.max(pre, maxAns);
            }
            return maxAns;
        }

    }

}


