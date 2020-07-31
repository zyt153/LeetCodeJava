/* Remove Element
 * Example 1:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5,
 * with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * */

import java.util.Arrays;

public class LeetCode0027 {
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int valPoint = 0;
        for(int i = 0; i < nums.length; i ++){
            if (nums[i] != val){
                nums[valPoint] = nums[i];
                valPoint ++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return valPoint;
    }
}
