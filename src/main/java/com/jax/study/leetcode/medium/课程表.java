package com.jax.study.leetcode.medium;

import com.jax.study.leetcode.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 207
 * 传送门: <a href="https://leetcode-cn.com/problems/course-schedule/" />
 *
 * @author wuzheng
 * @date 2020/05/17 10:55
 */
public class 课程表 {

    public static void main(String[] args) {
//        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}})); // true
//        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
        System.out.println(new Solution().canFinish(5, new int[][]{{0, 1}, {0, 3}, {1, 3}, {1, 2}, {2, 4}, {3, 4}})); // true
    }

    static class Solution {

        /**
         * 深度优先搜索
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for(int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<Integer>());
            int[] flags = new int[numCourses];
            for(int[] cp : prerequisites)
                adjacency.get(cp[1]).add(cp[0]);
            System.out.println(adjacency);
            for(int i = 0; i < numCourses; i++)
                if(!dfs(adjacency, flags, i)) return false;
            return true;
        }
        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            PrintUtil.printArray(flags);
            if(flags[i] == 1) return false;
            if(flags[i] == -1) return true;
            flags[i] = 1;
            for(Integer j : adjacency.get(i))
                if(!dfs(adjacency, flags, j)) return false;
            flags[i] = -1;
            return true;
        }
    }
}
