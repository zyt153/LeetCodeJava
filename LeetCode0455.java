/* Assign Cookies
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * */

import java.util.Arrays;

public class LeetCode0455 {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gpointer = 0, spointer = 0;
        while (gpointer < g.length && spointer < s.length) {
            if (s[spointer] >= g[gpointer])
                gpointer++;
            spointer++;
        }
        return gpointer;
    }
}
