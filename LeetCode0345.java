/* Reverse Vowels of a String
 * Input: "hello"
 * Output: "holle"
 * */

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode0345 {
    public static void main(String args[]){
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        if (s == null)
            return null;
        if (s.length() == 0)
            return "";

        int left = 0, right = s.length() - 1;
        char[] res = new char[s.length()];
        while (left <= right){
            char leftchar = s.charAt(left);
            char rightchar = s.charAt(right);
            if (!vowels.contains(leftchar)){
                res[left] = leftchar;
                left++;
            }
            else if (!vowels.contains(rightchar)){
                res[right] = rightchar;
                right--;
            }
            else{
                res[left] = rightchar;
                res[right] = leftchar;
                left++;
                right--;
            }
        }

        return new String(res);
    }
}
