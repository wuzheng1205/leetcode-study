package com.jax.study.leetcode.medium;

/**
 * ID: 63
 * 传送门: <a href="https://leetcode-cn.com/problems/unique-paths-ii/" />
 * 还可以使用递归求解
 *
 * @author wuzheng
 * @date 2019/7/11 15:29
 */
public class 不同路径II {

    public static void main(String[] args) {

        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
//        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{1, 0}}));
//        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 1}}));
//        System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 1, 0}}));
    }

    private static class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        continue;
                    }
                    if (i == 0 || j == 0) {
                        if (i == 0 && j > 0) {
                            obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                            continue;
                        }
                        if (j == 0 && i > 0) {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                            continue;
                        }
                        obstacleGrid[i][j] = 1;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }

            return obstacleGrid[m - 1][n - 1];
        }

    }

}


