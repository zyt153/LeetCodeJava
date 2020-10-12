/* Binary Tree Inorder Traversal
 * Input:
 *          1
             \
              2
             /
            3
 * Output: [1,3,2]
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode0094 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{1, 0, 2, 3, 0, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(inorderTraversal(root));
    }

    //Recursive
    /*static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }

        return res;
    }*/

    //Stack
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
