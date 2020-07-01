package com.jax.study.leetcode.easy;


/**
 * ID: 303.区域和检索 - 数组不可变
 * 传送门: <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/" />
 *
 * @author wuzheng
 * @date 2020/07/01 21:36
 */
public class NumArray {

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }


    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
