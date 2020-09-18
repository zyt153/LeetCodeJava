/* * Letter Combinations of a Phone Number
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0017 {
    public static void main(String args[]) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    //全局变量存储结果
    static List<String> output = new ArrayList<String>();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public static List<String> backtrack(String combination, String next_digits) {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        //如果输入数字被扫描完，则添加到结果中
        if (next_digits.length() == 0)
            output.add(combination);

        else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);     //子串中第一个数字代表的字母
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);    //依次取字母串中的字母
                backtrack(combination + letter, next_digits.substring(1));  //舍弃第一个数字并回溯
            }
        }

        return output;
    }
}
