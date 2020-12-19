/* Two Sum II - Input array is sorted
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * */

public class LeetCode0167 {
    public static void main(String args[]) {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] res = twoSum(numbers, target);
        for (int i : res)
            System.out.print(i + ",");
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] > target)
                j--;
            else
                i++;
        }
        return null;
    }
}
