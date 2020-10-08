/* Word Search II
 * board = [
    ['o','a','a','n'],
    ['e','t','a','e'],
    ['i','h','k','r'],
    ['i','f','l','v']
   ]
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0212 {
    public static void main(String args[]) {
        //char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        //String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a'}, {'a'}};
        String[] words = {"a"};
        System.out.println(findWords(board, words));
    }

    //待改进
    public static List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || words.length == 0)
            return new ArrayList<String>();

        Set<String> ans = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                        ans.add(word);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count))
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';                      //Mark the checked character
        boolean res = dfs(board, word, i + 1, j, count + 1) ||
                dfs(board, word, i - 1, j, count + 1) ||
                dfs(board, word, i, j + 1, count + 1) ||
                dfs(board, word, i, j - 1, count + 1);
        board[i][j] = temp;
        return res;
    }
}
