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

        /**
         * 原地旋转，每次顺时针交换4个点的值
         */
        public void rotate(int[][] matrix) {
            int x = matrix.length;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < matrix[i].length - i - 1; j++) {
                    int a1 = i, b1 = j;
                    int a2 = b1, b2 = x - a1 - 1;
                    int a3 = b2, b3 = x - a2 - 1;
                    int a4 = b3, b4 = x - a3 - 1;
                    // 交换
                    int tmp = matrix[a1][b1];//第1个点
                    // 第4个点赋值给第1个点
                    matrix[a1][b1] = matrix[a4][b4];// 第4个点
                    // 第3个点赋值给第4个点
                    matrix[a4][b4] = matrix[a3][b3];
                    // 第2个点赋值给第3个点
                    matrix[a3][b3] = matrix[a2][b2];
                    // 第1个点赋值给第2个点
                    matrix[a2][b2] = tmp;
                }
            }
        }

    }
}
