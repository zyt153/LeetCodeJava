/* Valid Palindrome II
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * */

public class LeetCode0680 {
    public static void main(String args[]) {
        String s = "abcda";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                // 向左删一个或向右删一个
                return truePalindrome(s, i + 1, j) || truePalindrome(s, i, j - 1);
            i++;
            j--;
        }
        return true;
    }

    // 判断是否是真·回文
    public static boolean truePalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
