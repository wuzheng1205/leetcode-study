package com.jax.study.leetcode.hard;

/**
 * ID: 4
 * 传送门: <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/" />
 *
 * @author wuzheng
 * @date 2020/02/24 14:00
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));// 2.5
        System.out.println(new Solution().findMedianSortedArrays(new int[]{}, new int[]{1}));// 1
        System.out.println(new Solution().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));// -1
    }

    private static class Solution {

        /**
         * 将原始2个有序数组，合并成一个新的有序数组，然后获取新数组的中位数
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[] newSortedArr = new int[n1 + n2];
            int index1 = 0, index2 = 0;
            for (int i = 0; i < n1 + n2; i++) {
                if (index1 >= n1) {
                    newSortedArr[i] = nums2[index2++];
                    continue;
                }
                if (index2 >= n2) {
                    newSortedArr[i] = nums1[index1++];
                    continue;
                }
                if (nums1[index1] < nums2[index2]) {
                    newSortedArr[i] = nums1[index1++];
                } else {
                    newSortedArr[i] = nums2[index2++];
                }
            }
            return getMedian(newSortedArr);
        }

        /**
         * 获取数组中位数
         */
        public double getMedian(int[] nums) {
            int n = nums.length;
            boolean isEven = (n % 2) == 0;
            if (isEven) {
                double tmp = nums[n / 2] + nums[n / 2 - 1];
                return tmp / 2;
            } else {
                return nums[n / 2];
            }
        }
    }

}


