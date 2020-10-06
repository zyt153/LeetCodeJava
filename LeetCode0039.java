/* Combination Sum
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0039 {
    public static void main(String args[]) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> inter = new LinkedList<Integer>();
        backtrack(target, inter, 0, candidates, res);
        return res;
    }

    public static void backtrack(int target, LinkedList<Integer> inter, int num, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(inter));
            return;
        } else if (target < 0)
            return;

        for (int i = num; i < candidates.length; i++) {
            inter.add(candidates[i]);
            backtrack(target - candidates[i], inter, i, candidates, res);
            inter.removeLast();
        }
    }
}