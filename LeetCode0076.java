/* Minimum Window Substring
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * */

import java.util.HashMap;
import java.util.Map;

public class LeetCode0076 {
    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "AABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || t.length() > s.length())
            return "";

        //统计t中的字母及其个数
        Map<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int counter = map.size();

        int begin = 0;      //左指针
        int end = 0;        //右指针
        int head = 0;

        int length = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);     //该字母个数减一
                if (map.get(c) == 0)
                    counter--;                  //匹配一个字母
            }
            end++;

            //所有字母都匹配后调整窗口长度
            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin < length) {
                    length = end - begin;
                    head = begin;
                }
                begin++;
            }
        }

        if (length == Integer.MAX_VALUE)
            return "";

        return s.substring(head, head + length);
    }
}
