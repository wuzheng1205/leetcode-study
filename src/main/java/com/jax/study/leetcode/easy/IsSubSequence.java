package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 392
 * 传送门: <a href="https://leetcode-cn.com/problems/is-subsequence/" />
 *
 * @author wuzheng
 * @date 2020/06/27 09:07
 */
public class IsSubSequence {

    public static void main(String[] args) {
        System.out.println(new IsSubSequence.Solution().isSubsequence1("abc", "ahbgdc"));
//        System.out.println(new IsSubSequence.Solution().isSubsequence1("axc", "ahbgdc"));
//        System.out.println(new IsSubSequence.Solution().isSubsequence1("aaaaaa", "bbaaaa"));
    }

    private static class Solution {

        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            return isSubsequence(s, t, 0, 0);
        }

        public boolean isSubsequence(String s, String t, int sIdx, int tIdx) {
            if (sIdx >= s.length()) {
                return true;
            }
            String subS = s.substring(sIdx);
            String subT = t.substring(tIdx);
            if (subS.equals(subT)) {
                return true;
            }
            char targetS = s.charAt(sIdx);
            tIdx = subT.indexOf(targetS);
            if (tIdx == -1) {
                return false;
            }
            return isSubsequence(s, subT, ++sIdx, ++tIdx);
        }

        /**
         * 后续挑战题解
         * 对t预处理
         */
        public boolean isSubsequence1(String s, String t) {
            // 预处理
            t = " " + t; // 开头加一个空字符作为匹配入口
            int n = t.length();
            int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
            for (char ch = 0; ch < 26; ch++) {
                int p = -1;
                for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                    dp[i][ch] = p;
                    if (t.charAt(i) == ch + 'a') p = i;
                }
            }
            PrintUtil.printArray(dp);
            // 匹配
            int i = 0;
            for (char ch : s.toCharArray()) { // 跳跃遍历
                i = dp[i][ch - 'a'];
                if (i == -1) return false;
            }
            return true;
        }

    }
}
