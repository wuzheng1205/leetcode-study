package com.jax.study.leetcode.other.dp;

/**
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 *
 * @author wuzheng
 * @date 2020/05/30 22:25
 */
public class 零一背包 {

    public static void main(String[] args) {
        零一背包 零一背包 = new 零一背包();
        System.out.println(零一背包.knapsack1(new int[]{6, 3, 7, 3, 9}, 5, 11));
    }

    /**
     * 动态规划，借助二维数组
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

    /**
     * 动态规划，借助一维数组
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     */
    public int knapsack1(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true; // 第一个物品初始化：不放背包
        if (weight[0] <= w) {
            states[weight[0]] = true; // 第一个物品初始化：放入背包
        }
        // 从第二个物品开始遍历推算
        for (int i = 1; i < weight.length; i++) {
            for (int j = w-weight[i]; j >= 0; j--) {
                if (states[j]) states[j + weight[i]] = true;
            }
        }
        for (int i = states.length - 1; i > 0; i--) {
            if (states[i]) return i;
        }
        return 0;
    }
}
