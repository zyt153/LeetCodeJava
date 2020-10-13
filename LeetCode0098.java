/* Validate Binary Search Tree
 * Input:
 *         5
          / \
         1   4
            / \
           3   6
 * Output: false
 * */

import java.util.Stack;

public class LeetCode0098 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{5, 1, 0, 0, 4, 3, 0, 0, 6, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(isValidBST(root));
    }

    //二分搜索树的中序遍历为从小到大排列
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        double last = - Double.MAX_VALUE;       //题目有一个[-2147483648]测试例

        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= last)
                return false;
            last = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
