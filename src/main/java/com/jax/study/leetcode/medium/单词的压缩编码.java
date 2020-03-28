package com.jax.study.leetcode.medium;

import java.util.*;

/**
 * ID: 820
 * 传送门: <a href="https://leetcode-cn.com/problems/short-encoding-of-words/" />
 *
 * @author wuzheng
 * @date 2020/03/28 13:57
 */
public class 单词的压缩编码 {

    public static void main(String[] args) {

        System.out.println(new Solution().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"body", "me", "bell"}));
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"time", "me", "anytime"}));
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"time", "time", "time", "time"}));
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"atime", "btime", "time"}));
    }

    private static class Solution {

        /**
         * 字典树
         */
        public int minimumLengthEncoding(String[] words) {
            TrieNode node = new TrieNode();
            Map<TrieNode, Integer> nodes = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                TrieNode cur = node;
                String word = words[i];
                for (int j = word.length() - 1; j >= 0; j--) {
                    cur = cur.get(word.charAt(j));
                }
                nodes.put(cur, i);
            }
            int length = 0;
            for (TrieNode trieNode : nodes.keySet()) {
                if (trieNode.count == 0)
                    length += words[nodes.get(trieNode)].length() + 1;
            }

            return length;
        }

        /**
         * 存储后缀
         */
        public int minimumLengthEncoding2(String[] words) {
            Set<String> noRepeatWords = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                for (int i = 1; i < word.length(); i++) {
                    noRepeatWords.remove(word.substring(i));
                }
            }
            int length = 0;
            for (String noRepeatWord : noRepeatWords) {
                length  += noRepeatWord.length() + 1;
            }
            return length;
        }

        /**
         * 我的解法：暴力法
         */
        public int minimumLengthEncoding1(String[] words) {
            Map<String, Integer> wrappedWords = new HashMap<>();
            int length = 0;
            for (int i = 0; i < words.length; i++) {
                length += words[i].length();
                if (wrappedWords.get(words[i]) != null) {
                    continue;
                }
                for (int j = i + 1; j < words.length; j++) {
                    int countJ = wrappedWords.get(words[j]) == null ? 0 : wrappedWords.get(words[j]);
                    int countI = wrappedWords.get(words[i]) == null ? 0 : wrappedWords.get(words[i]);
                    if (words[i].equals(words[j])) {
                        length -= words[j].length();
                        wrappedWords.put(words[j], countJ + 1);
                        continue;
                    }
                    if (words[i].length() > words[j].length() && words[i].endsWith(words[j]) && wrappedWords.get(words[j]) == null) {
                        length -= words[j].length();
                        wrappedWords.put(words[j], countJ + 1);
                    }
                    if (words[i].length() < words[j].length() && words[j].endsWith(words[i]) && wrappedWords.get(words[i]) == null) {
                        length -= words[i].length();
                        wrappedWords.put(words[i], countI + 1);
                        break;
                    }
                }
            }

            int wrappedWordsCount = 0;
            for (Integer value : wrappedWords.values()) {
                wrappedWordsCount += value;
            }

            return length + (words.length - wrappedWordsCount);
        }
    }

    /**
     * 字典树结构
     */
    static class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

}


