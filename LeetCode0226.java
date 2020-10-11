/* Invert Binary Tree
 * Input:
 *       4
       /   \
      2     7
     / \   / \
    1   3 6   9
 * Output:
 *       4
       /   \
      7     2
     / \   / \
    9   6 3   1
 * */

public class LeetCode0226 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{4, 2, 1, 0, 0, 3, 0, 0, 7, 6, 0, 0, 9, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        //TreeNode.output(root);
        TreeNode t = invertTree(root);
        TreeNode.output(t);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode R = invertTree(root.right);
        TreeNode L = invertTree(root.left);
        root.right = L;
        root.left = R;
        return root;
    }
}
