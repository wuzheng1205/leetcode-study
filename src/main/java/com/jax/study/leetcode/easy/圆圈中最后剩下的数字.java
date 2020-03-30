package com.jax.study.leetcode.easy;

/**
 * ID: 剑指offer-62
 * 传送门: <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/" />
 *
 * @author wuzheng
 * @date 2020/03/30 20:37
 */
public class 圆圈中最后剩下的数字 {

    public static void main(String[] args) {
        System.out.println(new 圆圈中最后剩下的数字.Solution().lastRemaining(5, 3));
        System.out.println(new 圆圈中最后剩下的数字.Solution().lastRemaining(10, 17));
    }

    static class Solution {

        /**
         * 数学+递归
         */
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }

    }
}
