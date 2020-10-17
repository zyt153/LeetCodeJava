/* Word Break
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * */

import java.util.ArrayList;
import java.util.List;

public class LeetCode0139 {
    public static void main(String args[]) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            if (dp[i] != true)
                continue;
            for(String word : wordDict){
                if(i + word.length() > s.length())
                    continue;
                if(s.substring(i, i+word.length()).equals(word))
                    dp[i + word.length()] = true;
            }
        }
        return dp[s.length()];
    }
}
