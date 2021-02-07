/* Container With Most Water
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7],
 * Output: 49
 * */

package Array;

public class LeetCode0011 {
    public static void main(String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int area = 0;
        int Lpoint = 0, Rpoint = height.length - 1;
        while(Lpoint != Rpoint){
            area = Math.max( (Rpoint - Lpoint) * Math.min(height[Lpoint], height[Rpoint]), area );
            if(height[Lpoint] <= height[Rpoint])
                Lpoint += 1;
            else
                Rpoint -= 1;
        }
        return area;
    }
}
