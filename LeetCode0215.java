/* Kth Largest Element in an Array
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * */

import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode0215 {
    public static void main(String args[]) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest_heap(nums, k));
    }

    //利用小顶堆排序
    public static int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }

    //改进的快排
    public static int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, target);
    }

    public static int quickSort(int[] nums, int low, int high, int target) {
        // index为寻找基准元素的正确索引
        int index = getRandomIndex(nums, low, high);
        if (index == target) return nums[index];
        else {
            return index < target ? quickSort(nums, index + 1, high, target) : quickSort(nums, low, index - 1, target);
        }
    }

    public static int getRandomIndex(int[] nums, int low, int high) {
        Random random = new Random();
        int r = random.nextInt(high - low + 1) + low; //random.nextInt(n)返回介于(0,n]的随机数
        swap(nums, low, r); //将随机获取的那个值与low值交换
        return getIndex(nums, low, high);
    }

    public static int getIndex(int[] nums, int low, int high) {
        //基准数据
        int temp = nums[low];
        while (low < high) {
            //当队尾的元素大于等于基准元素时，向前挪动指针
            while (low < high && nums[high] >= temp)
                high--;
            //若队尾元素小于基准元素了，将其值赋值给low位置的值
            nums[low] = nums[high];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while (low < high && nums[low] <= temp)
                low++;
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            nums[high] = nums[low];
        }
        //跳出循环时low==high 此时low位置就是temp元素的正确位置啦
        nums[low] = temp;
        return low; //返回这个排序好元素的正确位置
    }

    public static void swap(int[] nums, int i, int j) { //交换i和j对应位置的值
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //快速排序
    /*public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            //index为寻找基准元素的正确索引
            int index = getIndex(nums, low, high);
            //对index之前和index之后的数组进行相同的操作使得整个数组变得有序
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    public static int getIndex(int[] nums, int low, int high) {
        //基准数据
        int temp = nums[low];
        while (low < high) {
            //当队尾的元素大于等于基准元素时，向前挪动指针
            while (low < high && nums[high] >= temp)
                high--;
            //若队尾元素小于基准元素了，将其值赋值给low位置的值
            nums[low] = nums[high];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while (low < high && nums[low] <= temp)
                low++;
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            nums[high] = nums[low];
        }
        //跳出循环时low==high 此时low位置就是temp元素的正确位置啦
        nums[low] = temp;
        return low; //返回这个排序好元素的正确位置
    }*/
}
