/* Jump Game
 * Example1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * */

import java.util.Arrays;

public class LeetCode0055 {
    public static void main(String args[]){
        int[] nums = {2,4,2,1,0,2,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        //反向DP，judge中0表示不可达，1表示可达
        int[] judge = new int[nums.length];
        Arrays.fill(judge, 0);
        judge[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i --){
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            for(int j = i; j <= maxJump; j ++){
                if (judge[j] == 1) {
                    judge[i] = 1;
                    break;
                }
            }
        }

        return judge[0] == 1;
    }
}
