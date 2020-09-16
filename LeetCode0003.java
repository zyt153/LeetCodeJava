/* Longest Substring Without Repeating Characters
 * Example:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * */

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode0003 {
    public static void main(String args[]) {
        String s = "abcded";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        /*int length = s.length();
        HashSet hs = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < length && j < length) {
            if (!hs.contains(s.charAt(j))) {      //如果不包含第j个字母，则增加下一个字母
                hs.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {        //如果包含则删除第i个
                hs.remove(s.charAt(i));
                i++;
            }
        }
        //System.out.println(hs);
        return ans;*/

        int length = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0, i = 0, j = 0;

        while (j < length) {
            if (hm.containsKey(s.charAt(j)))            //如果hashmap中已存在s[j]字母
                i = Math.max(i, hm.get(s.charAt(j)));   //i移动到hashmap中的该值

            ans = Math.max(ans, j - i + 1);             //记录此时的最长子序列长度
            hm.put(s.charAt(j), j + 1);
            j++;
        }
        System.out.println(hm);
        return ans;
    }
}
