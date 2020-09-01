/* Remove Duplicates from Sorted Array II (See LeetCode0026)
 * Example1:
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * */

package Array;

import java.util.Arrays;

public class LeetCode0080 {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int NonDupPoint = 1;
        int Second = 0;
        for(int i = 1; i < nums.length; i ++){
            //首次重复
            if(nums[i] == nums[i-1] && Second == 0){
                nums[NonDupPoint] = nums[i];
                NonDupPoint ++;
                Second ++;
            }
            //不重复
            if (nums[i] != nums[i-1]){
                nums[NonDupPoint] = nums[i];
                NonDupPoint ++;
                Second = 0;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return NonDupPoint;
    }
}
