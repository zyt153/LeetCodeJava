/* Non-decreasing Array
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * */

public class LeetCode0665 {
    public static void main(String args[]){
        int[] nums = {4,5,3,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 1)
            return true;

        int down = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1])
                down++;
            if (down > 1)
                return false;
            /*如果x=1或者x=n-1,只需要将nums中第一个元素减小(最差到Integer.MIN_VALUE)，
              或者最后一个元素增大总能满足要求；
            * 如果1<x<n-1，若将nums[x]变大(至少应变为nums[x-1])必须要求nums[x-1]<=nums[x+1]。
                          若将nums[x-1]变小(至少应变为nums[x])，须要求nums[x-2]<=nums[x] */
            if (down == 1 && i > 1 && i < nums.length - 1
                    && nums[i - 1] > nums[i + 1] && nums[i - 2] > nums[i])
                return false;
        }

        return true;
    }
}
