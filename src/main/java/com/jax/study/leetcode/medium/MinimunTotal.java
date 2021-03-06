package com.jax.study.leetcode.medium;

import com.jax.study.leetcode.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 120
 * 传送门: <a href="https://leetcode-cn.com/problems/triangle/" />
 *
 * @author wuzheng
 * @date 2020/06/29 07:24
 */
public class MinimunTotal {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new MinimunTotal.Solution().minimumTotal1(triangle));
    }

    private static class Solution {

        /**
         * 自底向上
         * 从倒数第二行开始处理，对每行的每个数进行计算最小值
         * 最终顶点就是最小路径和
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int size = triangle.size();
            if (size == 1) {
                // 只有一行，直接返回顶点值
                return triangle.get(0).get(0);
            }
            // 最后一行
            List<Integer> lastLine = triangle.get(size - 1);
            int[] dp = new int[lastLine.size()];
            for (int i = 0; i < lastLine.size(); i++) {
                dp[i] = lastLine.get(i);
            }
            for (int i = size - 2; i >= 0; i--) {
                List<Integer> line = triangle.get(i);
                for (int j = 0; j < line.size(); j++) {
                    dp[j] = Math.min(dp[j], dp[j+1]) + line.get(j);
                }
            }
            return dp[0];
        }

        /**
         * 自顶向下
         */
        public int minimumTotal1(List<List<Integer>> triangle) {
            int size = triangle.size();
            if (size == 1) {
                // 只有一行，直接返回顶点值
                return triangle.get(0).get(0);
            }
            // 最后一行
            List<Integer> lastLine = triangle.get(size - 1);
            int[] dp = new int[lastLine.size()];
            dp[0] = triangle.get(0).get(0);
            for (int i = 0; i < size - 1; i++) { // 最后一行不用往下处理
                List<Integer> nextLine = triangle.get(i+1);
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < (i+1); j++) {
                    int left = dp[j] + nextLine.get(j);
                    int right = dp[j] + nextLine.get(j+1);
                    dp[j] = Math.min(left, tmp);
                    tmp = right;
                    if (j == i) {
                        dp[j+1] = right;
                    }
                }
                PrintUtil.printArray(dp);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                min = Math.min(dp[i], min);
            }
            return min;
        }

    }
}
