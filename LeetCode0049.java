/* Group Anagrams
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * */

import java.util.*;

public class LeetCode0049 {
    public static void main(String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List> res = new HashMap<String, List>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!res.containsKey(key))
                res.put(key, new ArrayList());
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
}
