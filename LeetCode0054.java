/* Spiral Matrix
 * Example1:
 * Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * */

package Array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0054 {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List output = spiralOrder(matrix);
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + ",");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix.length == 0)  //矩阵为空则返回
            return res;
        if(matrix.length == 1){  //矩阵只有一行
            for(int i = 0; i <= matrix[0].length - 1; i ++)
                res.add(matrix[0][i]);
            return res;
        }
        if(matrix[0].length == 1){  //矩阵只有一列
            for(int i = 0; i <= matrix.length - 1; i ++)
                res.add(matrix[i][0]);
            return res;
        }

        int top = 0;
        int down = matrix.length - 1;   //行数
        int left = 0;
        int right = matrix[0].length - 1;   //列数
        int dir = 0;    //方向：0表示向右，1表示向下，2表示向左，3表示向右
        while(top <= down && left <= right){
            if(dir == 0){   //向右
                for(int i = left; i <= right; i++)
                    res.add(matrix[top][i]);
                top ++;
                dir = 1;
            }
            else if(dir == 1){  //向下
                for(int i = top; i <= down; i++)
                    res.add(matrix[i][right]);
                right --;
                dir = 2;
            }
            else if(dir == 2){  //向左
                for(int i = right; i >= left; i--)
                    res.add(matrix[down][i]);
                down --;
                dir = 3;
            }
            else if(dir == 3){  //向上
                for(int i = down; i >= top; i--)
                    res.add(matrix[i][left]);
                left ++;
                dir = 0;
            }
        }
        return res;
    }
}
