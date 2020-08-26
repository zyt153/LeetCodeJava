/* Unique Paths II
 * Example1:
 * Input:
    [
     [0,0,0],
     [0,1,0],
     [0,0,0]
    ]
  * Output: 2
  * Explanation:
    There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right
 * */

package Array;

public class LeetCode0063 {
    public static void main(String args[]){
        int[][] obstacleGrid = {{0}, {1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        if(obstacleGrid[0][0] != 1)
            obstacleGrid[0][0] = 1;
        else
            return 0;

        //遍历第一行
        for (int i = 1; i < column; i++){
            if(obstacleGrid[0][i] != 1)     //无障碍则与左相同（为1）
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            else    //否则置为0
                obstacleGrid[0][i] = 0;
        }

        //遍历第一列
        for (int i = 1; i < row; i++){
            if(obstacleGrid[i][0] != 1)     //无障碍则与上相同（为1）
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            else    //否则置为0
                obstacleGrid[i][0] = 0;
        }

        //其他格 若无障碍则等于左+上，若有障碍则置为0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row - 1][column - 1];
    }
}
