/* Rotate Image
 * Example 1:
 * Given input matrix =
    [
     [1,2,3],
     [4,5,6],
     [7,8,9]
    ],
 * rotate the input matrix in-place such that it becomes:
    [
     [7,4,1],
     [8,5,2],
     [9,6,3]
    ]
 * */

package Array;

import java.util.Arrays;

public class LeetCode0048 {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t") ;
                }
            System.out.println() ;
            }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        //先转置矩阵
        for(int i = 0; i <= n; i ++){
            for(int j = i; j <= n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再翻转行
        for(int row = 0; row <= n; row ++){
            int i = 0;
            int j = n;
            while(i < j){
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                i ++;
                j --;
            }
        }
    }
}
