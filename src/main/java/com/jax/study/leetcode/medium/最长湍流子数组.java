package com.jax.study.leetcode.medium;

/**
 * ID: 978 TODO
 * 传送门: <a href="https://leetcode-cn.com/problems/longest-turbulent-subarray/" />
 *
 * @author wuzheng
 * @date 2020/02/28 14:30
 */
public class 最长湍流子数组 {

    public static void main(String[] args) {
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{4, 8, 12, 16}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{100}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{9, 9}));
//        System.out.println(new Solution().maxTurbulenceSize(new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24}));
        System.out.println(new Solution().maxTurbulenceSize(new int[]{8, 8, 8, 8, 1, 4}));
    }

    private static class Solution {

        /**
         * 我的版本，没用动态规划，额外创建了一个数组，其实可以省略的
         * 这个版本提交可以通过，但是其实代码是有问题的，这个输入[8, 8, 8, 8, 1, 4]对应的结果是4，单正确结果应该是3
         */
        public int maxTurbulenceSize1(int[] A) {
            if (A.length == 1) {
                return 1;
            }
            int[] linkA = new int[A.length - 1];
            boolean allSame = true;
            // 第一遍循环，把原数组相邻数之间的大小关系维护到新数组linkA中
            // 例如：原数组[1,3,2,4,4], linkA=[-1,1,-1,0], 1表示大于关系, 0表示等于关系, -1表示小于关系
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    linkA[i] = 1;
                    allSame = false;
                } else if (A[i] < A[i + 1]) {
                    linkA[i] = -1;
                    allSame = false;
                } else {
                    linkA[i] = 0;
                }
            }
            if (allSame) {
                // 这里做个特殊判断，数组元素是否都相等
                return 1;
            }
            int result = 0, count = 2;
            for (int i = 0; i < linkA.length - 1; i++) {
                // 根据新数组linkA中
                if (linkA[i] + linkA[i + 1] == 0) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 2;
                }
            }
            return Math.max(result, count);
        }

        public int maxTurbulenceSize(int[] A) {
            if (A.length == 1) {
                return 1;
            }
            int[] linkA = new int[A.length - 1];
            boolean allSame = true;
            // 第一遍循环，把原数组相邻数之间的大小关系维护到新数组linkA中
            // 例如：原数组[1,3,2,4,4], linkA=[-1,1,-1,0], 1表示大于关系, 0表示等于关系, -1表示小于关系
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    linkA[i] = 1;
                    allSame = false;
                } else if (A[i] < A[i + 1]) {
                    linkA[i] = -1;
                    allSame = false;
                } else {
                    linkA[i] = 0;
                }
            }
            if (allSame) {
                // 这里做个特殊判断，数组元素是否都相等
                return 1;
            }
            int result = 0, count = 2;
            for (int i = 0; i < linkA.length - 1; i++) {
                // 根据新数组linkA中
                if (linkA[i] * linkA[i + 1] == -1) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 2;
                }
            }
            return Math.max(result, count);
        }

    }

}


