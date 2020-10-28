/* Top K Frequent Elements
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode0347 {
    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + ",");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == nums.length)
            return nums;

        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        // 按count.get(n)构造大顶堆
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));

        for (int n: count.keySet())
            heap.add(n);

        int[] top = new int[k];
        for(int i = 0; i < k; i++) {
            top[i] = heap.poll();
        }
        return top;
    }
}
