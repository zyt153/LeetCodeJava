/* Non-overlapping Intervals
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * */

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode0435 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // 按二维数组的第二列从小到大排列
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[1] - interval2[1];
//            }
//        });
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // 选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大
        // 每次选择结尾最小，并且和前一个区间不重叠的区间
        int count = 1;
        int p = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= p) {
                p = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}
