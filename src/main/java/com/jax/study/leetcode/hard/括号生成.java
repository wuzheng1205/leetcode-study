package com.jax.study.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 22
 * 传送门: <a href="https://leetcode-cn.com/problems/generate-parentheses/" />
 *
 * @author wuzheng
 * @date 2020/04/09 21:26
 */
public class 括号生成 {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    private static class Solution {

        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");
            return res;
        }

        private void dfs(int left, int right, String curStr) {
            if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
                res.add(curStr);
                return;
            }

            if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
                dfs(left - 1, right, curStr + "(");
            }
            if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
                dfs(left, right - 1, curStr + ")");
            }
        }
    }

}


