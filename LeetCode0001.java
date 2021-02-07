import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0001 {
    public static void main(String[] args){
        int nums[] = {2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int result;
        int[] answer = new int[2];
        Map<Integer, Integer> numset = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            result = target - nums[i];
            if(numset.get(result) != null){
                answer[0] = numset.get(result);
                answer[1] = i;
                break;
            }
            numset.put(nums[i], i);
        }
        return answer;
    }
}
