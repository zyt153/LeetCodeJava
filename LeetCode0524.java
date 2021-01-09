/* Longest Word in Dictionary through Deleting
 * Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(findLongestWord(s, d));
    }

    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d){
            if (longestWord.length() > target.length() ||
                    (longestWord.length() == target.length() && longestWord.compareTo(target) < 0))
                continue;

            int i = 0, j = 0;
            while (i < s.length() && j < target.length()){
                if (s.charAt(i) == target.charAt(j))
                    j++;
                i++;
            }

            if (j == target.length())
                longestWord = target;
        }

        return longestWord;
    }
}
