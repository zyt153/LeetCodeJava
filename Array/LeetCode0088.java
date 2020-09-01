/* Merge Sorted Array
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * */

package Array;

import java.util.Arrays;

public class LeetCode0088 {
    public static void main(String args[]) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (j >= 0){
            if(i < 0 || nums2[j] > nums1[i]){
                nums1[end] = nums2[j];
                j --;
            }
            else{
                nums1[end] = nums1[i];
                i --;
            }
            end --;
        }
    }
}
