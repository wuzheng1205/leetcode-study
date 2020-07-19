package com.jax.study.leetcode.medium;

/**
 * ID: 1139. 最大的以 1 为边界的正方形
 * 传送门: <a href="https://leetcode-cn.com/problems/largest-1-bordered-square/" />
 *
 * @author wuzheng
 * @date 2020/07/12 10:34
 */
public class Largest1BorderedSquare {


    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] grid1 = {{0, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 0, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 1, 0}, {0, 1, 0, 0, 0}};

        System.out.println(new Largest1BorderedSquare.Solution().largest1BorderedSquare(grid));
        System.out.println(new Largest1BorderedSquare.Solution().largest1BorderedSquare(grid1));
    }

    private static class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            // TODO
            return 0;
        }
    }
}
