/* Sort Characters By Frequency
 * Input: "tree"
 * Output: "eert"
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode0451 {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    // 利用堆排序，类似347
    public static String frequencySort(String s) {
        Map<Character, Integer> wordFre = new HashMap<>();
        for (char c : s.toCharArray())
            wordFre.put(c, wordFre.getOrDefault(c, 0) + 1);

        Queue<Character> heap =
                new PriorityQueue<>((c1, c2) -> wordFre.get(c2) - wordFre.get(c1));
        for (char word : wordFre.keySet())
            heap.add(word);

        StringBuilder str = new StringBuilder();
        while (!heap.isEmpty()) {
            for (int i = 0; i < wordFre.get(heap.peek()); i++)
                str.append(heap.peek());
            heap.poll();
        }

        return str.toString();
    }
}
