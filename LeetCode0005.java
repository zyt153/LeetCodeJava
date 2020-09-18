/* Longest Palindromic Substring
 * Example1:
 * Input: "babad"
 * Output: "bab" (or "aba")
 * */

public class LeetCode0005 {
    public static void main(String args[]) {
        String s = "baab";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        int n = s.length();
        boolean[][] table = new boolean[n][n];
        int maxLength = 1;

        //长度为1的子数组一定为回文
        for (int i = 0; i < n; i++)
            table[i][i] = true;

        //判断长度为2的子数组是否为回文
        int start = 0;                          //回文子数组的开始位置
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){   //若两字符相同则为回文
                table[i][i + 1] = true;
                maxLength = 2;                  //最大长度为2
                start = i;
            }
        }

        //判断长度≥3的子数组是否为回文（DP）
        for (int length = 3; length <= n; length++){
            for (int i = 0; i < n - length + 1; i++){           //i为待判断的开始位置
                int j = i + length - 1;                         //j为待判断的结尾位置
                //中间为回文且s[i]=s[j]，则从i到j为回文
                if (table[i+1][j-1] == true && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    maxLength = Math.max(maxLength, length);    //更新最大长度
                    start = i;
                }
            }
        }

        /*for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println(" ");
        }*/
        return s.substring(start, start + maxLength);
    }
}
