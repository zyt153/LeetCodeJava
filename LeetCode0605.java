/* Can Place Flowers
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * */

public class LeetCode0605 {
    public static void main(String args[]){
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int pre = 0;
        int next = 0;
        for (int i = 0; i < flowerbed.length; i++){
            if (i != 0)
                pre = flowerbed[i - 1];
            if (i != flowerbed.length - 1)
                next = flowerbed[i + 1];
            if (pre == 0 && next == 0 && flowerbed[i] != 1){
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
