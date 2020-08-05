/* Search in Rotated Sorted Array
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * */

package Array;

public class LeetCode0033 {
    public static void main(String args[]){
        int[] nums = {5,1,3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] <= nums[mid]){     //左半边是排好序的
                if(target >= nums[left] && target < nums[mid])  //target在左半部分
                    right = mid - 1;        //只在左半部分寻找
                else
                    left = mid + 1;         //去右半部分寻找
            }
            else{                           //左半部分没排好序，说明右半部分是排好序的
                if(target >= nums[mid] && target <= nums[right])  //target在右半部分
                    left = mid + 1;        //只在右半部分寻找
                else
                    right = mid - 1;        //去左半部分寻找
            }
        }
        return -1;
    }
}
