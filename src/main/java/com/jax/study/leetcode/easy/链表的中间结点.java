package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.model.ListNode;
import com.jax.study.leetcode.util.PrintUtil;

/**
 * ID: 876
 * 传送门: <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/" />
 *
 * @author wuzheng
 * @date 2020/03/23 21:07
 */
public class 链表的中间结点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        PrintUtil.printNode(new Solution().middleNode(head));
    }

    static class Solution {

        /**
         * 单指针法
         */
        public ListNode middleNode1(ListNode head) {
            int length = 1;
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
                length++;
            }
            int index = 0;
            while (index++ < length / 2) {
                head = head.next;
            }
            return head;
        }

        /**
         * 快慢指针法
         */
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    }
}
