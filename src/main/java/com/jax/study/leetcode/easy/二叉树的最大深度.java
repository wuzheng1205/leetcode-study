package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.model.TreeNode;

import java.util.LinkedList;


/**
 * ID: 104
 * 传送门: <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/" />
 *
 * @author wuzheng
 * @date 2020/03/16 20:40
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        p.left = p1;
        p.right = p2;
        p2.left = p3;
        p2.right = p4;

        System.out.println(new Solution().maxDepth(p));
    }

    static class Solution {

        /**
         * 我的解法
         */
        public int maxDepth(TreeNode root) {
            return maxDepth(root, 1);
        }

        public int maxDepth(TreeNode node, Integer depth) {
            if (node == null) {
                // 回溯
                return --depth;
            } else {
                depth++;
                return Math.max(maxDepth(node.left, depth), maxDepth(node.right, depth));
            }
        }

        /**
         * 递归实现二叉树最大深度
         * 时间复杂度O(n)
         * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
         *
         * @param root 根节点
         * @return 最大深度
         */
        private static int maxDepth1(TreeNode root) {
            //递归退出条件，到叶子节点
            if (root == null) {
                return 0;
            }
            //计算左子树最大深度
            int leftMaxDepth = maxDepth1(root.left);
            //计算右子树最大深度
            int rightMaxDepth = maxDepth1(root.right);
            //以某个节点为根节点的数的最大深度为max
            //max=max(leftMaxDepth,rightMaxDepth)+1
            return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        }

        /**
         * BFS迭代实现二叉树最大深度
         * 时间复杂度O(n)
         * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
         *
         * @param root 根节点
         * @return 最大深度
         */
        private static int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //BFS的层次遍历思想，记录二叉树的层数，
            //遍历完，层数即为最大深度
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                maxDepth++;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.pollFirst();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return maxDepth;
        }

    }
}
