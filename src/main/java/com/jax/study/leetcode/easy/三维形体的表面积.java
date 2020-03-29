package com.jax.study.leetcode.easy;

/**
 * ID: 892
 * 传送门: <a href="https://leetcode-cn.com/problems/surface-area-of-3d-shapes/" />
 *
 * @author wuzheng
 * @date 2020/03/23 21:07
 */
public class 三维形体的表面积 {

    public static void main(String[] args) {
        System.out.println(new Solution().surfaceArea(new int[][]{{2}})); // 10
        System.out.println(new Solution().surfaceArea(new int[][]{{1, 2}, {3, 4}})); // 34
        System.out.println(new Solution().surfaceArea(new int[][]{{1, 0}, {0, 2}})); // 16
        System.out.println(new Solution().surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})); // 32
        System.out.println(new Solution().surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}})); // 46
    }

    static class Solution {

        /**
         * 遍历计算，对于grid[i][j], 除了计算本形体的面积, 还需要计算和右边、上边相邻的形体遮挡的面积
         */
        public int surfaceArea(int[][] grid) {
            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                int upNext = i - 1;
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    int rightNext = j + 1;
                    if (rightNext < grid[i].length) {
                        // 往右判断面积遮挡
                        area -= Math.min(grid[i][j], grid[i][rightNext]) * 2;
                    }
                    if (upNext >= 0) {
                        // 往上判断遮挡
                        area -= Math.min(grid[i][j], grid[upNext][j]) * 2;
                    }
                    // 本格面积处理
                    area += grid[i][j] * 4 + 2;
                }
            }
            return area;
        }

    }
}
