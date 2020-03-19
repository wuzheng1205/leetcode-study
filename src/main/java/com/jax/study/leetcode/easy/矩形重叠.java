package com.jax.study.leetcode.easy;

/**
 * ID: 836
 * 传送门: <a href="https://leetcode-cn.com/problems/rectangle-overlap/" />
 *
 * @author wuzheng
 * @date 2020/03/18 21:34
 */
public class 矩形重叠 {

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3})); // true
        System.out.println(new Solution().isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1})); // false
        System.out.println(new Solution().isRectangleOverlap(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0})); // false
        System.out.println(new Solution().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, -1, 3, 1})); // true
        System.out.println(new Solution().isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20})); // true
    }

    static class Solution {

        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            boolean flag1 = rec1[0] >= rec2[2];
            boolean flag2 = rec1[2] <= rec2[0];
            boolean flag3 = rec1[3] <= rec2[1];
            boolean flag4 = rec1[1] >= rec2[3];
            return !(flag1 || flag2 || flag3 || flag4);
        }

    }
}
