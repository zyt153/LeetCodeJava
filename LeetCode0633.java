/* Sum of Square Numbers
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * */

public class LeetCode0633 {
    public static void main(String args[]) {
        int c = 3;
        System.out.println(judgeSquareSum(c));
    }

    // 类似167，为了使 0^2 + right^2 更接近c，右指针取sqrt(c)
    public static boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;

        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j){
            if (i * i + j * j == c)
                return true;
            else if (i * i + j * j < c)
                i++;
            else
                j--;
        }
        return false;
    }
}
