/* Minimum Path Sum
 * Example:
 * Input:
    [
     [1,3,1],
     [1,5,1],
     [4,2,1]
    ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * */

public class LeetCode0064 {
    public static void main(String args[]){
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];

        dp[0][0] = grid[0][0];
        //第一行
        for (int i = 1; i < column; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        //第一列
        for (int i = 1; i < row; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        //其他格
        for (int i = 1; i < row; i ++){
            for(int j = 1; j < column; j ++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[row - 1][column - 1];
    }
}
