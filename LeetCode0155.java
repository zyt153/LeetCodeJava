/* Min Stack
 * Example:
 * Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
          [[],[-2],[0],[-3],[],[],[],[]]
 * Output: [null,null,null,null,-3,null,0,-2]
 * */

import java.util.Stack;

public class LeetCode0155 {
    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //存储顺序为（底）x min x min x min ...（顶）
        min = stack.size() > 0 ? Math.min(x, stack.peek()) : x;
        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        if(stack.pop() == stack.peek()){
            //如果最小值被出栈，则更新当前最小值
            stack.pop();
            min = stack.peek();
        }
        else
            stack.pop();
    }

    public int top() {
        int temp = stack.pop();
        int top = stack.peek();
        stack.push(temp);
        return top;
    }

    public int getMin() {
        return stack.peek();
    }
}
