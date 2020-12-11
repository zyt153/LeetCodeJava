/* Maximal Square
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * */

public class LeetCode0221 {
    public static void main(String args[]) {
        char[][] matrix = {{'1', '0', '1', '0', '0',}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (matrix == null || row == 0 || column == 0)
            return 0;

        int[][] dp = new int[row + 1][column + 1];      //创建矩阵，增加第一行和第一列为了防止溢出
        int maxSquare = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}
