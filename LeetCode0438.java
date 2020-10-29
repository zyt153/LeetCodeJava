/* Find All Anagrams in a String
 * Input: s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode0438 {
    public static void main(String args[]) {
        String s = "abca";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;
            }

            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }

    //Time Limit Exceeded
    /*public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length())
            return res;

        char[] sarr = s.toCharArray();
        int L = 0, R = 0;

        for (L = 0; L < s.length() - p.length() + 1; L++) {
            HashMap<Character, Integer> count_p = new HashMap<>();
            for (char c : p.toCharArray())
                count_p.put(c, count_p.getOrDefault(c, 0) + 1);

            int find = 0;
            for (R = L; R - L < p.length(); R++) {
                if (count_p.containsKey(sarr[R]) && count_p.get(sarr[R]) > 0) {
                    int curr = count_p.get(sarr[R]);
                    count_p.put(sarr[R], curr - 1);
                    find++;
                    if (find == p.length())
                        res.add(L);
                }
            }
        }

        return res;
    }*/
}
