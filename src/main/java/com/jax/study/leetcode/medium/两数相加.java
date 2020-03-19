package com.jax.study.leetcode.medium;

import com.jax.study.leetcode.model.ListNode;
import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 2
 * 传送门: <a href="https://leetcode-cn.com/problems/add-two-numbers/" />
 *
 * @author wuzheng
 * @date 2020/02/16 16:27
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode num1_1 = new ListNode(1);
//        ListNode num1_2 = new ListNode(5);
//        ListNode num1_3 = new ListNode(3);
//        num1_1.next = num1_2;
//        num1_2.next = num1_3;

        ListNode num2_1 = new ListNode(9);
        ListNode num2_2 = new ListNode(9);
//        ListNode num2_3 = new ListNode(4);
        num2_1.next = num2_2;
//        num2_2.next = num2_3;

        ListNode result = new Solution().addTwoNumbers(num1_1, num2_1);
        PrintUtil.printNode(result);


    }

    private static class Solution {

        /**
         * 模拟加法运算
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null, last = null;
            boolean l1End = false, l2End = false;
            int lastCarryBit = 0;
            while (true) {
                if (l1End && l2End) {
                    if (lastCarryBit > 0) {
                        last.next = new ListNode(lastCarryBit);
                    }
                    return result;
                }
                int l1Val = 0, l2Val = 0;
                if (!l1End) {
                    l1Val = l1.val;
                    if ((l1 = l1.next) == null) {
                        l1End = true;
                    }
                }
                if (!l2End) {
                    l2Val = l2.val;
                    if ((l2 = l2.next) == null) {
                        l2End = true;
                    }
                }

                int sum = l1Val + l2Val + lastCarryBit;
                lastCarryBit = sum / 10;
                int remainder = sum % 10;
                if (result == null) {
                    // 第一个节点
                    result = new ListNode(remainder);
                    last = result;
                    continue;
                }
                ListNode next = new ListNode(remainder);
                last.next = next;
                last = next;
            }
        }

    }

}


