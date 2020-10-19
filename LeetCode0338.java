/* Counting Bits
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * */

public class LeetCode0338 {
    public static void main(String args[]) {
        int num = 5;
        int[] res = countBits(num);
        for (int i = 0; i <= num; i++)
            System.out.print(res[i] + ",");
    }

    //Powers of 2 always have only one '1' in their binary representation.
    //Every positive number can be represented as a sum of a power of 2 and another positive number.
    public static int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0, 1};

        int[] bits = new int[num + 1];
        int powerOf2 = 1;
        bits[0] = 0;
        bits[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i == 2 * powerOf2) {
                bits[i] = 1;
                powerOf2 *= 2;
            } else {
                bits[i] = 1 + bits[i - powerOf2];
            }
        }
        return bits;
    }
}
