package com.jax.study.leetcode.medium;

/**
 * ID: 945
 * 传送门: <a href="https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/" />
 *
 * @author wuzheng
 * @date 2020/03/222 15:58
 */
public class 使数组唯一的最小增量 {

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{1, 2, 2})); // 1
        System.out.println(new Solution().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7})); // 6
        System.out.println(new Solution().minIncrementForUnique(new int[]{2, 2, 2, 1})); // 3
    }

    static class Solution {

        /**
         * 计数
         */
        public int minIncrementForUnique(int[] A) {
            int maxNum = A.length;
            for (int i : A) {
                maxNum = Math.max(maxNum, i);
            }
            int[] count = new int[maxNum * 2];
            for (int x : A) count[x]++;

            int ans = 0, taken = 0;

            for (int x = 0; x < count.length; ++x) {
                if (count[x] >= 2) {
                    taken += count[x] - 1;
                    ans -= x * (count[x] - 1);
                } else if (taken > 0 && count[x] == 0) {
                    taken--;
                    ans += x;
                }
            }

            return ans;
        }
    }
}
