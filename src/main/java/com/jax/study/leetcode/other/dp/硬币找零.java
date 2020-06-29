package com.jax.study.leetcode.other.dp;

/**
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
 * 如果我们要支付 w 元，求最少需要多少个硬币。比如，我们有 3 种不同的硬币，1 元、3 元、5 元，
 * 我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
 *
 * @author wuzheng
 * @date 2020/06/01 20:28
 */
public class 硬币找零 {

    public static void main(String[] args) {

    }

    public int countMoneyMin(int[] moneyItems, int resultMemory) {
        if (null == moneyItems || moneyItems.length < 1) {
            return -1;
        }

        if (resultMemory < 1) {
            return -1;
        }

        // 计算遍历的层数，此按最小金额来支付即为最大层数
        int levelNum = resultMemory / moneyItems[0];
        int leng = moneyItems.length;

        int[][] status = new int[levelNum][resultMemory + 1];

        // 初始化状态数组
        for (int i = 0; i < levelNum; i++) {
            for (int j = 0; j < resultMemory + 1; j++) {
                status[i][j] = -1;
            }
        }

        // 将第一层的数数据填充
        for (int i = 0; i < leng; i++) {
            status[0][moneyItems[i]] = moneyItems[i];
        }

        int minNum = -1;

        // 计算推导状态
        for (int i = 1; i < levelNum; i++) {
            // 推导出当前状态
            for (int j = 0; j < resultMemory; j++) {
                if (status[i - 1][j] != -1) {
                    // 遍历元素,进行累加
                    for (int k = 0; k < leng; k++) {
                        if (j + moneyItems[k] <= resultMemory) {
                            status[i][j + moneyItems[k]] = moneyItems[k];
                        }
                    }
                }

                // 找到最小的张数
                if (status[i][resultMemory] >= 0) {
                    minNum = i + 1;
                    break;
                }
            }

            if (minNum > 0) {
                break;
            }
        }

        int befValue = resultMemory;

        // 进行反推出，币的组合
        for (int i = minNum - 1; i >= 0; i--) {
            for (int j = resultMemory; j >= 0; j--) {
                if (j == befValue) {
                    System.out.println("当前的为:" + status[i][j]);
                    befValue = befValue - status[i][j];
                    break;
                }
            }
        }

        return minNum;
    }
}
