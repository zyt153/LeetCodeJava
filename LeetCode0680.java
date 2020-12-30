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
    
    /* 一个更快的方法
    public static boolean validPalindrome(String s) {
        return getNumDeletes(s, 0, s.length() - 1) < 2;
    }

    private static int getNumDeletes(String s, int left, int right) {
        if (left == right) {
            return 0;
        }

        int l = left;
        int r = right;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (s.charAt(l) == s.charAt(r - 1)) {
                    int subDel = getNumDeletes(s, l, r - 1) + 1;

                    if (subDel < 2) {
                        return subDel;
                    }
                }

                if (s.charAt(l + 1) == s.charAt(r)) {
                    int subDel = getNumDeletes(s, l + 1, r) + 1;

                    if (subDel < 2) {
                        return subDel;
                    }
                }

                return 2;
            }
            l++;
            r--;
        }
        return 0;
    }
    */
}
