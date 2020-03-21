package com.jax.study.leetcode.easy;

/**
 * ID: 365
 * 传送门: <a href="https://leetcode-cn.com/problems/water-and-jug-problem/" />
 *
 * @author wuzheng
 * @date 2020/03/20 07:13
 */
public class 水壶问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(3, 5, 4)); // true
        System.out.println(new Solution().canMeasureWater(2, 7, 4)); // true
        System.out.println(new Solution().canMeasureWater(2, 7, 5)); // true
        System.out.println(new Solution().canMeasureWater(2, 6, 5)); // false
        System.out.println(new Solution().canMeasureWater(2, 8, 5)); // false
    }

    static class Solution {

        /**
         * 数学解法
         */
        public boolean canMeasureWater(int x, int y, int z) {
            if (x + y < z) {
                return false;
            }
            if (x == 0 || y == 0) {
                return z == 0 || x + y == z;
            }

            return z % gcd(x, y) == 0;
        }

        /**
         * 最大公约数
         */
        public int gcd(int a, int b) {
            int min = a < b ? a : b;

            for (int i = min; i >= 1; i--) {
                if (a % i == 0 && b % i == 0) {
                    return i;
                }
            }
            return 0;
        }
    }
}
