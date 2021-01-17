/* Largest Number
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * */

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode0179 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        // 转化为String型数组
        String[] n = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = String.valueOf(nums[i]);
        }
        // 重写比较器
        Arrays.sort(n, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                String s1 = n1 + n2;
                String s2 = n2 + n1;
                //compareTo 方法
                //如果参数是一个按字典顺序排列等于该字符串的字符串，则返回值为0;
                //如果参数是按字典顺序大于此字符串的字符串，则返回值小于0;
                //如果参数是按字典顺序小于此字符串的字符串，则返回值大于0。
                return s2.compareTo(s1);
                // s2.compareTo(s1)是升序的，s1.compareTo(s2)则是降序
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
