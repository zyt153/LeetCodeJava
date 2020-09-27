/* Trapping Rain Water
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * */

import java.util.Stack;

public class LeetCode0042 {
    public static void main(String args[]) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    //Two pointers
    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int ans = 0;
        int len = height.length;
        int[] Lmax, Rmax;
        Lmax = new int[len];
        Rmax = new int[len];
        Lmax[0] = height[0];
        Rmax[len - 1] = height[len - 1];
        //找到左边最大高度
        for (int i = 1; i < len; i++)
            Lmax[i] = Math.max(height[i], Lmax[i - 1]);
        //找到右边最大高度
        for (int i = len - 2; i >= 0; i--)
            Rmax[i] = Math.max(height[i], Rmax[i + 1]);
        //积水=当前位置 最大高度-height
        for (int i = 0; i < len - 1; i++) {
            ans += Math.min(Lmax[i], Rmax[i]) - height[i];
        }

        return ans;
    }

    //Monotonic stack 单调栈
    //利用栈单调性，如果栈中的元素是[3 1 0]，下一个元素是2，那么我们就可以知道前面很可能有一个坑，
    //将 0 pop出来之后，那么计算该处的水的量即：
    //找到两边极小值（在1 0 2中是 1），那么可容水量即为 （ 2 - 1 ）* （1 - 0 ） = 1，后面依次计算即可。
    public static int trapStack(int[] height) {
        if (height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int i, sum = 0;
        int len = height.length;

        for (i = 0; i < len; i++) {
            int width = 0;                                                  //宽度初始化
            while (!stack.empty() && height[stack.peek()] < height[i])      //如果栈非空并且满足栈顶元素小于即将进入的元素
            {
                int temp = stack.peek();
                stack.pop();
                if (stack.empty())
                    break;
                if (height[temp] == height[stack.peek()])
                    continue;
                width = i - stack.peek() - 1;                               //宽度计算
                int minHeight = Math.min(height[i], height[stack.peek()]);  //最小高度
                sum += width * (minHeight - height[temp]);                  //容量累计
            }
            stack.push(i);
        }
        return sum;
    }
}
