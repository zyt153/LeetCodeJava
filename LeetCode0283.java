/* Move Zeroes
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * */

public class LeetCode0283 {
    public static void main(String args[]) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + ",");
    }

    public static void moveZeroes(int[] nums) {
        /*int point1 = 0;
        int point2 = 1;
        while (point2 < nums.length) {
            if(nums[point1] != 0)
                point1 ++;
            if (nums[point1] == 0 && nums[point2] != 0) {
                nums[point1] = nums[point2];
                nums[point2] = 0;
                point1++;
            }
            point2++;
        }*/
        for(int i = 0, j = 0; i<nums.length && j<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
