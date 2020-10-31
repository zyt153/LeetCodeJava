/* Number of Islands
 * Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
  ]
 * Output: 3
 * */

public class LeetCode0200 {
    public static void main(String args[]) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int num = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    num += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public static void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
