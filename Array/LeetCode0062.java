/* Unique Paths
 * Example1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right
 * */

package Array;

public class LeetCode0062 {
    public static void main(String args[]) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        //按网格建立矩阵
        int[][] matrix = new int[n][m];

        //到达（0,i）的路径只有一种
        for (int i = 0; i < m; i++)
            matrix[0][i] = 1;
        //到达（i,0）的路径也只有一种
        for (int i = 0; i < n; i++)
            matrix[i][0] = 1;

        //对于其他格子(i,j)，到达的方法数为 到达其左侧格子的方法数 + 到达其上方格子的方法数
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++)
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }

        return matrix[n - 1][m - 1];
    }
}
