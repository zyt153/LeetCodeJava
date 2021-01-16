/* Valid Anagram
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * */

import java.util.Arrays;

public class LeetCode0242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // Use sorting: O(nlogn)
        /*if (s.length() != t.length())
            return false;
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        Arrays.sort(char_s);
        Arrays.sort(char_t);
        return Arrays.equals(char_s, char_t);*/

        // Use arrays (or hashmap): O(n)
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] += 1;
            table[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0)
                return false;
        }
        return true;
    }
}
