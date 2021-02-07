/* Spiral Matrix II
 * Example:
 * Input: 3
 * Output:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
 * */

package Array;

import java.util.Arrays;

public class LeetCode0059 {
    public static void main(String args[]) {
        int n = 3;
        int[][] output = generateMatrix(n);
        for (int i = 0; i < output.length; i++) {
            System.out.print(Arrays.toString(output[i]) + "," + "\n");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int down = n - 1;     //行数
        int left = 0;
        int right = n - 1;    //列数
        int dir = 0;        //方向：0表示向右，1表示向下，2表示向左，3表示向右
        int value = 1;      //初始值

        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    res[top][i] = value++;
                }
                top++;
                dir = 1;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    res[i][right] = value;
                    value++;
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = value;
                    value++;
                }
                down--;
                dir = 3;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    res[i][left] = value;
                    value++;
                }
                left++;
                dir = 0;
            }
        }
        return res;
    }
}
