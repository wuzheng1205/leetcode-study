package com.jax.study.leetcode.hard;

import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 1402.做菜的顺序
 * 传送门: <a href="https://leetcode-cn.com/problems/reducing-dishes/" />
 *
 * @author wuzheng
 * @date 2020/02/24 14:00
 */
public class MaxSatisfaction {

    public static void main(String[] args) {
        System.out.println(new MaxSatisfaction.Solution().maxSatisfaction(new int[]{-2, 5, -1, 0, 3, -3})); // 35
    }

    private static class Solution {

        public int maxSatisfaction(int[] satisfaction) {
            int maxSt = 0;
            for (int i = 0; i < satisfaction.length; i++) {
                maxSt = Math.max(maxSt, satisfaction[i]);
            }
            if (maxSt <= 0) return 0;

            // 对原数组进行桶排序（升序）
            int[] bucket = new int[2001];
            for (int i = 0; i < satisfaction.length; i++) {
                bucket[satisfaction[i]+1000]++;
            }
            int i = 0, j = 0;
            while (i < satisfaction.length) {
                int bucketJ = bucket[j];
                while (bucketJ-- > 0) {
                    satisfaction[i++] = j - 1000;
                }
                j++;
            }

            maxSt = 0;
            for (int k = 0; k < satisfaction.length; k++) {
                int tmpSt = 0;
                for (int l = k; l < satisfaction.length; l++) {
                    tmpSt += satisfaction[l] * (l-k+1);
                }
                maxSt = Math.max(maxSt, tmpSt);
            }
            return maxSt;
        }
    }
}
