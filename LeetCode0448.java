/* Find All Numbers Disappeared in an Array
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0448 {
    public static void main(String args[]) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // 把每个元素的值减一作为下标(使得元素的范围变为0-n-1)，标记这个下标的元素为负，
        // 这样没出现过的数字以他为下标的元素都是正的
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]>=0)
                nums[index] *= -1;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}
