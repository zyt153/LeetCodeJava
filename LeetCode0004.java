/* Median of Two Sorted Arrays
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * */

public class LeetCode0004 {
    public static void main(String args[]) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /*public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两数组并寻找中位数，时间复杂度O(m+n)
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        // nums1为空时，仅计算nums2的中位数
        if (m == 0) {
            if (n % 2 == 0)
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            else
                return nums2[n / 2];
        }
        // nums2为空时，仅计算nums1的中位数
        if (n == 0) {
            if (m % 2 == 0)
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            else
                return nums1[m / 2];
        }

        // nums1、nums2都不为空时
        int count = 0;
        int i = 0, j = 0;
        while (count != m + n) {
            // num1都放入了merge中
            if (i == m) {
                while (j != n)
                    merge[count++] = nums2[j++];
                break;
            }
            // num2都放入了merge中
            if (j == n) {
                while (i != m)
                    merge[count++] = nums1[i++];
                break;
            }
            // 其他情况需要作比较
            if (nums1[i] < nums2[j])
                merge[count++] = nums1[i++];
            else
                merge[count++] = nums2[j++];
        }
        // 合并完成返回中位数
        if (count % 2 == 0) {
            return (merge[count / 2 - 1] + merge[count / 2]) / 2.0;
        } else {
            return merge[count / 2];
        }
    }*/

    // 二分法，时间复杂度O(log(m+n))
    // https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    public static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0)
            return nums2[start2 + k - 1];

        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j])
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        else
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
}
