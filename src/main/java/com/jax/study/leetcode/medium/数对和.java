package com.jax.study.leetcode.medium;

import java.util.*;

/**
 * ID: 1452
 * 传送门: <a href="https://leetcode-cn.com/problems/pairs-with-sum-lcci/" />
 *
 * @author wuzheng
 * @date 2020/02/27 16:48
 */
public class 数对和 {

    public static void main(String[] args) {
        System.out.println(new Solution().pairSums(new int[]{5, 6, 5}, 11));
        System.out.println(new Solution().pairSums(new int[]{5, 6, 5, 6}, 11));
        System.out.println(new Solution().pairSums(new int[]{4}, 11));
        System.out.println(new Solution().pairSums(new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14}, 12));
        System.out.println(new Solution().pairSums(new int[]{1, 2, 0, 0, 2, 1, 0, 2, 2, 3}, 2));
        System.out.println(new Solution().pairSums(new int[]{6, 1, 7, 6, 5, 1, 0, 0, 5, -1}, 6));
    }

    private static class Solution {

        /**
         * 哈希表实现, 优化版(耗时排名太低, 待优化)
         */
        public List<List<Integer>> pairSums(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int otherNum = target - nums[i];
                if (numsMap.get(otherNum) == null || numsMap.get(otherNum) == 0) {
                    // 和当前元素匹配的元素不在map中, 把当前元素放到map中
                    numsMap.put(nums[i], numsMap.get(nums[i]) == null ? 1 : numsMap.get(nums[i]) + 1);
                } else {
                    // 和当前元素匹配的元素存在map中, 记录一组结果, 把map中匹配的到元素次数减一
                    result.add(Arrays.asList(nums[i], otherNum));
                    numsMap.put(otherNum, numsMap.get(otherNum) - 1);
                }
            }
            return result;
        }

        /**
         * 哈希表实现, 2遍循环
         */
        public List<List<Integer>> pairSums2(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numsMap.get(nums[i]) == null) {
                    numsMap.put(nums[i], 1);
                } else {
                    numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
                }
            }
            for (Integer key : numsMap.keySet()) {
                while (numsMap.get(key) != null && numsMap.get(key) > 0) {
                    int otherKey = target - key;
                    Integer otherValue = numsMap.get(otherKey);
                    if (otherValue == null || otherValue == 0) {
                        break;
                    }
                    if (key == otherKey && numsMap.get(key) < 2) {
                        break;
                    }
                    numsMap.put(otherKey, numsMap.get(otherKey) - 1);
                    numsMap.put(key, numsMap.get(key) - 1);
                    result.add(Arrays.asList(key, otherKey));
                }
            }
            return result;
        }

        /**
         * 暴力法: 超出时间限制, 暂时不知道是否正确
         */
        public List<List<Integer>> pairSums1(int[] nums, int target) {
            int[] used = new int[nums.length];
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target && used[i] == 0 && used[j] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j]));
                        used[i] = 1;
                        used[j] = 1;
                    }
                }
            }
            return result;
        }

    }

}


