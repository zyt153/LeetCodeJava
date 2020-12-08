/* Course Schedule
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * */

import java.util.ArrayList;
import java.util.List;

public class LeetCode0207 {
    public static void main(String args[]) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {3, 0}, {3, 1}, {2, 1}, {4, 2}, {4, 3}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    // 等价于判断由课程节点组成的图是否为 有向无环图
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();      //建立有向图，adjacency[i]中为第i个节点指向的节点编号
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        System.out.println(adjacency);

        int[] flags = new int[numCourses];      //访问标识

        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i))
                return false;
        return true;
    }

    public static boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        /*
        * 未被 DFS 访问：i == 0；
        * 已被其他节点启动的 DFS 访问：i == -1；
        * 已被当前节点启动的 DFS 访问：i == 1。
        * 当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 TrueTrue。
        * 当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 22 次访问，即 课程安排图有环 ，直接返回 FalseFalse。
        */
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1)
            return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j))
                return false;
        flags[i] = -1;
        return true;
    }
}
