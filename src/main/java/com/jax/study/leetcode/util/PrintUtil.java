package com.jax.study.leetcode.util;

import com.jax.study.leetcode.model.ListNode;

public class PrintUtil {

    /**
     * 打印数组
     *
     * @param array 数组
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 打印二维数组
     *
     * @param array 二维数组
     */
    public static void printArray(int[][] array) {
        for (int[] arr2 : array) {
            PrintUtil.printArray(arr2);
        }
    }


    /**
     * 打印链表
     *
     * @param node 链表
     */
    public static void printNode(ListNode node) {
        do {
            System.out.print(node.val + "->");
        } while ((node = node.next) != null);
        System.out.println("NULL");
    }

}
