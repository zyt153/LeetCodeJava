/* Partition Labels
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * */

import java.util.ArrayList;
import java.util.List;

public class LeetCode0763 {
    public static void main(String args[]) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<Integer>();

        int[] lastAppear = new int[26];     //Record the last time the letter appears
        for (int i = 0; i < S.length(); i++)
            lastAppear[S.charAt(i) - 'a'] = i;

        int maxLength = 0;
        int begin = 0;                      //The index of next part begin
        for (int i = 0; i < S.length(); i++) {
            maxLength = Math.max(maxLength, lastAppear[S.charAt(i) - 'a']);
            if (i == maxLength) {
                ans.add(i + 1 - begin);
                begin = i + 1;
            }
        }
        return ans;
    }
}
