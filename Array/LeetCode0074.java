/* Search a 2D Matrix
 * Example1:
 * Input:
    matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
    ]
 * target = 3
 * Output: true
 * */

package Array;

public class LeetCode0074 {
    public static void main(String args[]) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleNum = matrix[middle / column][middle % column];
            System.out.println(middleNum);
            if (middleNum == target)
                return true;
            else if (middleNum > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return false;
    }
}
