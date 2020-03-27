package com.jax.study.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 914
 * 传送门: <a href="https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/" />
 *
 * @author wuzheng
 * @date 2020/03/27 16:42
 */
public class 卡牌分组 {

    public static void main(String[] args) {
        System.out.println(new Solution().hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); // true
        System.out.println(new Solution().hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})); // false
        System.out.println(new Solution().hasGroupsSizeX(new int[]{1})); // false
        System.out.println(new Solution().hasGroupsSizeX(new int[]{1, 1})); // true
        System.out.println(new Solution().hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})); // true
    }

    static class Solution {

        public boolean hasGroupsSizeX(int[] deck) {
            if (deck.length < 2) {
                return false;
            }
            // 统计每个数出现的次数
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < deck.length; i++) {
                if (cntMap.containsKey(deck[i])) {
                    cntMap.put(deck[i], cntMap.get(deck[i]) + 1);
                } else {
                    cntMap.put(deck[i], 1);
                }
            }
            // map values转成数组，用于计算最大公约数
            int[] cntArr = new int[cntMap.size()];
            int i = 0;
            for (Integer value : cntMap.values()) {
                cntArr[i++] = value;
            }
            // 最大公约数不等于1的则表示满足
            return getMoreBigDiv(cntArr, cntArr.length) != 1;
        }

        public static int getMoreBigDiv(int[] num, int n) { // 求多个数的最大公约数
            if (n == 1)
                return num[n - 1];
            return getBigDiv(num[n - 1], getMoreBigDiv(num, n - 1));
        }

        public static int getBigDiv(int a, int b) {// 求两个数的最大公约数
            if (b == 0)
                return a;
            return getBigDiv(b, a % b);
        }

    }
}
