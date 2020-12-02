/* Find Median from Data Stream
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode0295 {
    public static void main(String args[]) {
        MedianFinder median = new MedianFinder();
        median.addNum(2);
        median.addNum(1);
        System.out.println(median.findMedian());
        median.addNum(3);
        System.out.println(median.findMedian());
    }
}

class MedianFinder {
    private int count;

    //注释的部分为利用排序寻找中位数，时间复杂度为O(NlogN)
    //private ArrayList<Integer> nums;

    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        /*count = 0;
        nums = new ArrayList<>();*/

        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        /*count += 1;
        nums.add(num);
        Collections.sort(nums);
        System.out.println(nums);*/

        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0)
            maxheap.add(minheap.poll());
    }

    public double findMedian() {
        /*if (count % 2 == 0) {
            double left = nums.get(count / 2 - 1);
            double right = nums.get(count / 2);
            return (left + right) / 2;
        } else
            return nums.get(count / 2);*/

        if (count % 2 == 0)
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        else
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */