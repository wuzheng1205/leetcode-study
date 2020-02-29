package com.jax.study.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ID: 3
 * 传送门: <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/" />
 *
 * @author wuzheng
 * @date 2020/02/23 15:00
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
//        System.out.println(new Solution().lengthOfLongestSubstring1("abcabcbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring1("pwwkew"));
//        System.out.println(new Solution().lengthOfLongestSubstring1("bbbbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring1("au"));
        System.out.println(new Solution().lengthOfLongestSubstring1("dvdf"));

    }

    private static class Solution {

        /**
         * 我的版本(思路和优化的滑动窗口一样，但是代码不够简洁)
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int result = 1;
            int tempCount = 1;
            boolean repeatFlag = false;
            int repeatIndex = 0;
            for (int i = 1; i < s.length(); i++) {
                for (int j = repeatIndex; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        repeatFlag = true;
                        repeatIndex = j + 1;
                        i = j + 1;
                        break;
                    }
                }
                if (repeatFlag) {
                    if (tempCount > result) {
                        result = tempCount;
                    }
                    tempCount = 1;
                    repeatFlag = false;
                } else {
                    tempCount++;
                }
            }
            if (tempCount > result) {
                result = tempCount;
            }

            return result;

        }

        /**
         * 滑动窗口
         */
        public int lengthOfLongestSubstring1(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

        /**
         * 优化的滑动窗口
         */
        public int lengthOfLongestSubstring2(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }

    }

}


