/* Maximal Rectangle
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * */

import java.util.Stack;

public class LeetCode0085 {
    public static void main(String args[]) {
        char[][] matrix = {{'1', '0', '1', '0', '0',}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        // 动态规划，计算每行连续1的个数，时间复杂度O(N^2M)
        /*if (matrix.length == 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    // 从右下角向上计算矩形面积
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        max = Math.max(max, width * (i - k + 1));
                    }
                }
            }
        }
        return max;*/

        // 利用84题中的单调递增栈
        if (matrix.length == 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int max = 0;
        int[] dp = new int[column];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (matrix[i][j] == '1')
                    dp[j] += 1;
                else
                    dp[j] = 0;
            }
            max = Math.max(leetcode84(dp), max);
        }
        return max;
    }

    public static int leetcode84(int[] heights) {
        int len = heights.length;
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < len; ++i) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = len - stack.peek() - 1;
            max = Math.max(max, w * h);
        }
        return max;
    }
}
