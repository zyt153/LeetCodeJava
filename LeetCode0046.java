/* Permutations
 * Input: [1,2,3]
 * Output:
    [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
    ]
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0046 {
    public static void main(String args[]) {
        int[] candidates = {1,2,3};
        System.out.println(permute(candidates));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> inter = new LinkedList<Integer>();
        backtrack(inter, 0, nums, res);
        return res;
    }

    public static void backtrack(LinkedList<Integer> inter, int start, int[] nums, List<List<Integer>> res){
        if (inter.size() == nums.length){
            res.add(new ArrayList<Integer>(inter));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (inter.contains(nums[i]))
                continue;
            inter.add(nums[i]);
            backtrack(inter, start, nums, res);
            inter.removeLast();
        }
    }
}
