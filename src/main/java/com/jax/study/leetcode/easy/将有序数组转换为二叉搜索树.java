package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.model.TreeNode;


/**
 * ID: 108
 * 传送门: <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/" />
 *
 * @author wuzheng
 * @date 2020/03/17 19:30
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode.val);
    }

    static class Solution {

        /**
         * 中序遍历，始终找中间（奇数）或者中间左边一个（偶数）
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildSubTree(0, nums.length - 1, nums);
        }

        private TreeNode buildSubTree(int left, int right, int[] nums) {
            if (left > right) {
                return null;
            }
            // 找中间数，作为根节点
            int mid = (right + left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            // 构建左子树
            root.left = buildSubTree(left, mid - 1, nums);
            // 构建右子树
            root.right = buildSubTree(mid + 1, right, nums);
            return root;
        }

    }
}
