package com.jax.study.leetcode.medium;

import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 面试题01.07
 * 传送门: <a href="https://leetcode-cn.com/problems/rotate-matrix-lcci/" />
 *
 * @author wuzheng
 * @date 2020/04/07 17:00
 */
public class 旋转矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrix);
        PrintUtil.printArray(matrix);

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new Solution().rotate(matrix);
        PrintUtil.printArray(matrix);
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int x = matrix.length;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < matrix[i].length - i - 1; j++) {
                    // 交换
                    int tmp = matrix[i][j];//第1个点
                    // 第4个点赋值给第1个点
                    matrix[i][j] = matrix[j][i];// 第4个点
                    // 第3个点赋值给第4个点
                    matrix[j][i] = matrix[x - i - 1][j];
                    // 第2个点赋值给第3个点
                    matrix[x - i - 1][j] = matrix[j][x - i - 1];
                    // 第1个点赋值给第2个点
                    matrix[j][x - i - 1] = tmp;
//                    matrix[i][j] = matrix[j][x - i - 1];// 第2个点
//                    matrix[j][x - i - 1] = matrix[x - i - 1][j];// 第3个点
//                    matrix[x - i - 1][j] = matrix[j][i];// 第4个点
//                    matrix[j][i] = tmp;
                }
            }
        }

    }
}
