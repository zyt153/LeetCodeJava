/* Construct Binary Tree from Preorder and Inorder Traversal
 * Input: preorder = [3,9,20,15,7]
          inorder = [9,3,15,20,7]
 * Output:     3
              / \
             9  20
               /  \
              15   7
 * */

import java.util.HashMap;

public class LeetCode0105 {
    public static void main(String args[]) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode t = buildTree(preorder, inorder);
        TreeNode.output(t);
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        for (int i = 0; i < length; i++)
            map.put(inorder[i], i);
        return myBUildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    public static TreeNode myBUildTree(int[] preorder, int[] inorder, int preorder_left,
                                       int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right)
            return null;

        int preorder_root = preorder_left;
        int inorder_root = map.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);     //根节点为前序遍历的第一个节点
        int sizeOfLeft = inorder_root - inorder_left;              //左子树节点数

        //左子树
        root.left = myBUildTree(preorder, inorder, preorder_left + 1,
                preorder_left + sizeOfLeft, inorder_left, inorder_root - 1);
        //右子树
        root.right = myBUildTree(preorder, inorder, preorder_left + sizeOfLeft+1,
                preorder_right, inorder_root+1, inorder_right);
        return root;
    }
}
