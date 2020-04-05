package com.jax.study.leetcode.hard;

/**
 * ID: 42
 * 传送门: <a href="https://leetcode-cn.com/problems/trapping-rain-water/" />
 *
 * @author wuzheng
 * @date 2020/04/04 10:08
 */
public class 接雨水 {

    public static void main(String[] args) {
//        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(new Solution().trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3})); // 83
    }

    private static class Solution {

        /**
         * 双指针（待优化）
         */
        public int trap(int[] height) {
            int[] rainwaterArr = new int[height.length];
            int startPillarIdx = 0, endPillarIdx = height.length - 1;
            int startPillar = -1, endPillar = -1;
            while (true) {
                // 每次计算待判断的柱子区间
                int[] pillarPeriod = getPillarPeriod(startPillarIdx, endPillarIdx, startPillar, endPillar, height);
                if (pillarPeriod[0] == -1) {
                    // 区间判断结束
                    break;
                }
                int i = pillarPeriod[0], j = pillarPeriod[1];
                int minPillar = Math.min(pillarPeriod[2], pillarPeriod[3]);
                while (i <= j && i < height.length && j > 0) {
                    if (height[i] < minPillar) {
                        rainwaterArr[i] = minPillar - height[i];
                    }
                    if (height[j] < minPillar) {
                        rainwaterArr[j] = minPillar - height[j];
                    }
                    i++;
                    j--;
                }
                startPillarIdx = pillarPeriod[0];
                endPillarIdx = pillarPeriod[1];
                startPillar = pillarPeriod[2];
                endPillar = pillarPeriod[3];
            }

            int result = 0;
            for (int rainwater : rainwaterArr) {
                result += rainwater;
            }
            return result;
        }

        public int[] getPillarPeriod(int startPillarIdx, int endPillarIdx, int startPillar, int endPillar, int[] height) {
            while (startPillarIdx < endPillarIdx && startPillarIdx < height.length && endPillarIdx > 0) {
                if (height[startPillarIdx] == 0) {
                    startPillarIdx++;
                    continue;
                }
                if (height[endPillarIdx] == 0) {
                    endPillarIdx--;
                    continue;
                }
                if (startPillar > endPillar && height[endPillarIdx] <= endPillar) {
                    endPillarIdx--;
                    continue;
                }
                if (startPillar <= endPillar && height[startPillarIdx] <= startPillar) {
                    startPillarIdx++;
                    continue;
                }
                return new int[]{startPillarIdx, endPillarIdx, height[startPillarIdx], height[endPillarIdx]};
            }
            return new int[]{-1};
        }
    }

}


