/* Search a 2D Matrix II
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * */

public class LeetCode0240 {
    public static void main(String args[]) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //int[][] matrix = {{-5}};
        int target = 45;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        //从左下角开始搜索
        int row = matrix.length - 1;
        int column = 0;
        //利用排序进行搜索 O(M + N)
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target)
                row--;
            else if (matrix[row][column] < target)
                column++;
            else
                return true;
        }
        return false;

        //二分法 O(lg(n!))
        /*if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;

        for (int i = 0; i <= row; i++) {
            //如果target的范围未超过该行，则进行二分查找；否则去下一行搜索
            if (target <= matrix[i][column]) {
                int low = 0;
                int high = column;
                while (low <= high) {
                    int middle = (low + high) / 2;
                    if (target < matrix[i][middle])
                        high = middle - 1;
                    else if (target > matrix[i][middle])
                        low = middle + 1;
                    else
                        return true;
                }
            }
        }
        return false;*/
    }
}
