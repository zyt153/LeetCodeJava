/* Task Scheduler
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * */

import java.util.Arrays;

public class LeetCode0621 {
    public static void main(String args[]) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    //优化——填桶
    public static int leastInterval_new(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    //贪婪
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        int res = 0;
        int[] list = new int[26];
        for (char c : tasks)
            list[c - 'A']++;
        Arrays.sort(list);      //升序，出现次数最多的被排在最后（具体字母是啥不重要）

        while (list[25] > 0) {
            int t = 0;
            while (t <= n) {
                if(list[25] == 0)
                    break;
                if (t < 26 && list[25 - t] > 0)
                    list[25 - t]--;
                t++;
                res++;
            }
            Arrays.sort(list);
        }
        return res;
    }
}
