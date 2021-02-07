/* Merge Intervals
 * Example1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * */

import java.util.Arrays;

public class LeetCode0056 {
    public static void main(String args[]){
        int[][] intervals = {{2,6},{1,3},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for(int i = 0; i < res.length; i ++)
            System.out.println(Arrays.toString(res[i]));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return intervals;

        // 按数组的第一个值从小到大排列
        Arrays.sort(intervals, (int[] n1, int[] n2) -> n1[0]-n2[0]);

        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                if (intervals[index][1] < intervals[i][1])
                    intervals[index][1] = intervals[i][1];
            } else {
                intervals[++index] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, index+1);
    }
}
