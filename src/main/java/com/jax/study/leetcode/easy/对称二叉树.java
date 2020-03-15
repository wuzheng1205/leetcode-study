package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.model.TreeNode;


/**
 * ID: 101
 * 传送门: <a href="https://leetcode-cn.com/problems/symmetric-tree/" />
 *
 * @author wuzheng
 * @date 2020/03/15 18:40
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(3);
        TreeNode p6 = new TreeNode(4);
        tree.left = p1;
        tree.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p6;
        p2.right = p5;

        System.out.println(new Solution().isSymmetric(tree));
    }

    static class Solution {

        /**
         * 递归比较左子树和右子树，左子树的左子树和右子树右子树，左子树和右子树和右子树的左子树
         * TODO 还有一种借助队列的迭代解法
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return compare(root.left, root.right);
        }

        public boolean compare(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if ((left == null || right == null)) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            return compare(left.left, right.right) && compare(left.right, right.left);
        }

    }
}
