package com.java.leetcode;

import com.jax.study.leetcode.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1
 * 传送门: <a href="https://leetcode-cn.com/problems/two-sum/" />
 *
 * @author wuzheng
 * @date 2020/02/15 16:30
 */
public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int[] result = new Solution().twoSum3(nums, 6);
        PrintUtil.printArray(result);
    }

    static class Solution {
        /**
         * 解法一：暴力法，两层循环
         * 时间复杂度：O(N2)
         * 空间复杂度：O(1)
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

            throw new IllegalArgumentException("No two sum solution");
        }

        /**
         * 解法二：两遍哈希表
         * 时间复杂度：O(N)
         * 空间复杂度：O(N)
         */
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> numsMap = new HashMap<>();
            // 第一遍
            for (int i = 0; i < nums.length; i++) {
                numsMap.put(nums[i], i);
            }
            // 第二遍
            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                if (numsMap.get(key) != null && numsMap.get(key) != i) {
                    return new int[]{i, numsMap.get(key)};
                }
            }

            throw new IllegalArgumentException("No two sum solution");
        }

        /**
         * 解法三：一遍哈希表
         * 时间复杂度：O(N)
         * 空间复杂度：O(N)
         */
        public int[] twoSum3(int[] nums, int target) {
            Map<Integer, Integer> numsMap = new HashMap<>();
            // 第一遍
            for (int i = 0; i < nums.length; i++) {
                int key = target - nums[i];
                if (numsMap.get(key) != null) {
                    return new int[]{i, numsMap.get(key)};
                }
                numsMap.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }
}
