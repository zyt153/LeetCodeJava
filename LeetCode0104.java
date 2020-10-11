/* Maximum Depth of Binary Tree
 * Input:
 *      3
       / \
      9  20
        /  \
       15   7
 * Output: depth = 3
 * */

public class LeetCode0104 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return Math.max(L, R) + 1;
    }

}
