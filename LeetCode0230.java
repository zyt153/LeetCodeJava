/* Kth Smallest Element in a BST
 * Input: k = 3,
 *         5
          / \
         3   6
        / \
       2   4
      /
     1
 * Output: 3
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode0230 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{5, 3, 2, 1, 0, 0, 0, 4, 0, 0, 6, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        int k = 3;
        System.out.println(kthSmallest(root, k));
    }

    //递归：中序遍历即为从小到大排序，找到第k个元素即可
    /*static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            res.add(root.val);
            inorder(root.right);
        }
        return res;
    }

    public static int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k - 1);
    }*/

    //迭代：用stack
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int num = 0;
        int res;

        while(curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res = curr.val;
            num ++;
            curr = curr.right;

            if(num == k)
                return res;
        }
        return 0;
    }
}
