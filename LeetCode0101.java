/* Symmetric Tree
 * Input:
 *          1
           / \
          2   2
         / \ / \
        3  4 4  3
 * Output: True
 * */

public class LeetCode0101 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{1, 2, 3, 0, 0, 4, 0, 0, 2, 4, 0, 0, 3, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return recursive(root, root);
    }

    public static boolean recursive(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;

        boolean res = false;
        if (t1.val == t2.val && recursive(t1.left, t2.right) && recursive(t1.right, t2.left))
            res = true;
        return res;
    }
}
