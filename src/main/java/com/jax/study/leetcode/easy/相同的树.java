package com.jax.study.leetcode.easy;

import com.jax.study.leetcode.model.TreeNode;


/**
 * ID: 100
 * 传送门: <a href="https://leetcode-cn.com/problems/same-tree/" />
 *
 * @author wuzheng
 * @date 2020/03/15 18:50
 */
public class 相同的树 {

    public static void main(String[] args) {
        /*TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        p.left = p1;
        p.right = p2;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(3);
        q.left = q1;
        q.right = q2;*/

        /*TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        p.left = p1;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        q.right = q1;*/


        /*TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        p.left = p2;
        p.right = p1;

        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q.left = q1;
        q.right = q2;*/

        TreeNode p = new TreeNode(1);

        System.out.println(new Solution().isSameTree(null, p));
    }

    static class Solution {

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p == null || q == null)) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }
}
