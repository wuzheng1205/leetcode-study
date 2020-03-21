package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 剑指offer面试题40
 * 传送门: <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/" />
 *
 * @author wuzheng
 * @date 2020/03/20 07:13
 */
public class 最小的k个数 {

    public static void main(String[] args) {
        PrintUtil.printArray(new Solution().getLeastNumbers(new int[]{3, 2, 1}, 2));
        PrintUtil.printArray(new Solution().getLeastNumbers(new int[]{4, 3, 2, 1, 1, 3, 0}, 3));
        PrintUtil.printArray(new Solution().getLeastNumbers(new int[]{0, 0, 1, 3, 4, 5, 0, 7, 6, 7}, 9));
    }

    static class Solution {

        /**
         * 排序k次, 每次取数组中最小的数
         * 时间复杂度:k*N
         * 空间复杂度:k
         */
        public int[] getLeastNumbers1(int[] arr, int k) {
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        // 交换
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
            int[] leastNumbers = new int[k];
            // 数组拷贝
            System.arraycopy(arr, 0, leastNumbers, 0, k);
            return leastNumbers;
        }

        /**
         * 桶排序, 排序后直接遍历桶数组, 顺序取出k个数
         * 时间复杂度: 2N+k
         * 空间复杂度: k+Max(arr[i])
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            // 第一遍循环后，arr[0]为数组最大值
            for (int i = 1; i < arr.length; i++) {
                if (arr[0] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                }
            }
            int[] buckets = new int[arr[0] + 1];
            for (int i = 0; i < arr.length; i++) {
                buckets[arr[i]] = buckets[arr[i]] + 1;
            }
            int[] leastNumbers = new int[k];
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] == 0) {
                    continue;
                }
                int ct = buckets[i];
                while (ct-- > 0) {
                    if (index >= k) {
                        break;
                    }
                    leastNumbers[index++] = i;
                }
            }
            return leastNumbers;
        }

    }
}
