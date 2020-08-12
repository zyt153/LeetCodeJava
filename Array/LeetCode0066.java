/* Plus One
 * Example2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * */

package Array;

import java.util.Arrays;

public class LeetCode0066 {
    public static void main(String args[]){
        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        for(int i = length; i >= 0; i --){
            if (digits[i] != 9){    //一般情况
                digits[i] ++;
                return digits;
            }
            else if (digits[i] == 9 && i != 0){     //需要进位
                digits[i] = 0;
            }
            else{       //需要进位且位数增加，如9999
                digits = new int[length + 2];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
