/* Insert Interval
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0057 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] res = insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++)
            System.out.println(Arrays.toString(res[i]));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;        // 向res中添加元素时的索引
        int i = 0;          // 用于逐个判断intervals中的元素
        // 在newInterval左边的区间直接添加
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            res[idx++] = intervals[i++];
        // 将newInterval涉及到的区间进行合并，更新到newInterval，最后添加到res中
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        // 在newInterval右边的区间直接添加
        while (i < intervals.length && intervals[i][0] > newInterval[1])
            res[idx++] = intervals[i++];

        return Arrays.copyOf(res, idx);     // 去掉末尾[0,0]多余元素
    }
}
