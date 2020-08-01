/* Maximum Subarray
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * */

package Array;

import static java.lang.Math.*;

public class LeetCode0053 {
    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /*public static int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int sum;
        for(int i=0; i < nums.length; i++){
            sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                // sum is sum of x[i..j]
                maxSoFar = max(maxSoFar, sum);
            }
        }
        return maxSoFar;
    }*/

    /*public static int maxSubArray(int[] nums){
        int max_so_far=nums[0];
        int curr_max=nums[0];
        for(int i=1;i<nums.length;i++){
            curr_max = Math.max(nums[i],curr_max+nums[i]);
            max_so_far=Math.max(max_so_far,curr_max);
        }
        return max_so_far;
    }*/
    public static int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        return rec(nums, 0, nums.length - 1);
    }
    //返回这个之间的最大子序和
    private static int rec(int[] arr, int L, int R) {
        if (L == R)
            return arr[L];
        int mid = L + (R - L) / 2;
        int LMax = rec(arr, L, mid);
        int RMax = rec(arr, mid + 1, R);

        int sum = 0, LSumMax = Integer.MIN_VALUE, RSumMax = Integer.MIN_VALUE;

        for (int i = mid; i >= L; i--) {
            sum += arr[i];
            if (sum > LSumMax) {
                LSumMax = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= R; i++) {
            sum += arr[i];
            if (sum > RSumMax) {
                RSumMax = sum;
            }
        }
        int crossMax = LSumMax + RSumMax;

        //compare crossMax、LMax,RMax
        if (LMax >= RMax && LMax >= crossMax)
            return LMax;
        if (RMax >= LMax && RMax >= crossMax)
            return RMax;
        return crossMax;
    }
}
