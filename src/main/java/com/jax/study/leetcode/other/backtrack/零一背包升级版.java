package com.jax.study.leetcode.other.backtrack;

/**
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 * 回溯算法
 *
 * @author wuzheng
 * @date 2020/05/31 09:18
 */
public class 零一背包升级版 {

    public static void main(String[] args) {
        零一背包升级版 零一背包 = new 零一背包升级版();
        零一背包.f(0, 0, 0);
        System.out.println(零一背包.maxV);

    }


    private int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] items = {2, 2, 4, 6, 3};  // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int cw, int cv) { // 调用f(0, 0, 0)
        System.out.println("[" + i + "]" + cw + "," + cv);
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i + 1, cw, cv); // 选择不装第i个物品
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], cv + value[i]); // 选择装第i个物品
        }
    }
}
