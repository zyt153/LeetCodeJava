/* Find the Duplicate Number
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * */

import java.util.HashSet;
import java.util.Set;

public class LeetCode0287 {
    public static void main(String args[]) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //二分法
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        //nums中元素的范围为 [1, len-1]
        int left = 1;
        int right = len - 1;

        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            //统计原始数组中小于等于mid的元素的个数
            for(int num : nums){
                if (num <= mid)
                    count ++;
            }
            if (count > mid)
                // 重复元素位于区间 [left, mid]
                right = mid;
            else
                // 重复元素位于区间 [mid + 1, right]
                left = mid + 1;
        }
        return left;
    }

    //利用集合元素无重复
    public static int findDuplicate_set(int[] nums) {
        Set<Integer> nonDulpicate = new HashSet<>();
        for (int num : nums) {
            if (nonDulpicate.contains(num))
                return num;
            nonDulpicate.add(num);
        }
        return -1;
    }
}
