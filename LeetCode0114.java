/* Flatten Binary Tree to Linked List
 * Input:   1
           / \
          2   5
         / \   \
        3   4   6
 * Output:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * */

import java.util.Stack;

public class LeetCode0114 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 6, 0, 0};
    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        flatten(root);
        TreeNode.output(root);
    }

    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = temp;
            root = root.right;
        }
    }
}
