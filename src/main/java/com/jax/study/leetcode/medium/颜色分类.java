package com.jax.study.leetcode.medium;

import com.jax.study.leetcode.util.PrintUtil;

import java.util.Random;

/**
 * ID: 75
 * 传送门: <a href="https://leetcode-cn.com/problems/sort-colors/" />
 *
 * @author wuzheng
 * @date 2020/02/27 16:48
 */
public class 颜色分类 {

    public static void main(String[] args) {
//        int[] nums1 = {1, 1, 2, 2, 0, 0, 0, 0, 0, 2};
//        int[] nums1 = {0, 1, 2, 0, 2, 2, 0, 1, 0, 2};
//        new Solution().sortColors(nums1);
//        PrintUtil.printArray(nums1);


        // 随机生成一个长度为10的数组，用于测试答案的正确性
        int[] nums2 = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums2[i] = random.nextInt(3);
        }
        PrintUtil.printArray(nums2);
        new Solution().sortColors(nums2);
        System.out.println();
        PrintUtil.printArray(nums2);
    }

    private static class Solution {

        /**
         * 一次遍历
         * 将0划分到最左边区域，用一个指针控制
         * 将2划分到最有表区域，用一个指针控制
         * 遍历，用一个指针控制
         */
        public void sortColors(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return;
            }
            // 0的最右边指针；2的最左边指针；当前指针
            int right0 = 0, left2 = n - 1, curr = 0;
            while (curr <= left2) {
                int temp = nums[curr];
                if (nums[curr] == 0) {
                    while (nums[right0] == 0 && right0 < curr) {
                        // 判断right0位置是0，那说明当前right0已经符合要求，right0右移
                        right0++;
                    }
                    // 因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位
                    nums[curr++] = nums[right0];
                    nums[right0++] = temp;
                } else if (nums[curr] == 2) {
                    while (nums[left2] == 2 && left2 > curr) {
                        // 判断left2位置是2，那说明当前left2已经符合要求，left2左移
                        left2--;
                    }
                    // 因为与left2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++
                    nums[curr] = nums[left2];
                    nums[left2--] = temp;
                } else {
                    curr++;
                }
            }
        }

    }

}


