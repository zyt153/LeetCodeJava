/* Search Insert Position
 * Example 1:
 * Input: [1,3,5,6], 5  Output: 2
 * Example 3:
 * Input: [1,3,5,6], 7  Output: 4
 * */

package Array;

public class LeetCode0035 {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                break;
            }
        }
        return i;
    }
}
