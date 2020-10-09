/* Palindromic Substrings
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * */

public class LeetCode0674 {
    public static void main(String args[]){
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        if (s.length() == 0)
            return 0;

        int res = 0;
        int start, end;
        for (int i = 0; i < s.length(); i ++){
            res ++;     //every character is a palindromic substrings
            //even palindromic substrings
            start = i;
            end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                res ++;
                start--;
                end++;
            }
            //odd palindromic substrings
            start = i - 1;
            end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                res ++;
                start--;
                end++;
            }
        }
        return res;
    }
}
