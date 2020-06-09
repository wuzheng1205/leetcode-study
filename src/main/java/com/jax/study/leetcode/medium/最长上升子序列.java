package com.jax.study.leetcode.medium;

/**
 * ID: 300
 * 传送门: <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/" />
 *
 * @author wuzheng
 * @date 2020/06/09 20:32
 */
public class 最长上升子序列 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }

    private static class Solution {

        /**
         * 动态规划
         * dp[i]：以第i个数字结尾的最长上升子序列，必须包含nums[i]
         * 转移方程：dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
         */
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                int preMaxLength = 0;
                for (int j = 0; j < i; j++) {
                    if (dp[j] > preMaxLength && nums[i] > nums[j]) {
                        preMaxLength = dp[j];
                    }
                }
                dp[i] = preMaxLength + 1;
            }
            int maxLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                }
            }
            return maxLength;
        }

        /**
         * 贪心+二分查找
         */
        public int lengthOfLIS1(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for (int num : nums) {
                int i = 0, j = res;
                while (i < j) {
                    int m = (i + j) / 2;
                    if (tails[m] < num) i = m + 1;
                    else j = m;
                }
                tails[i] = num;
                if (res == j) res++;
            }
            return res;
        }

    }

}


