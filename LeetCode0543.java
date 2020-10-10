/* Diameter of Binary Tree
 * Input:
 *        1
         / \
        2   3
       / \
      4   5
 * Output: 3
 * The length of the longest path is [4,2,1,3] or [5,2,1,3].
 * */

public class LeetCode0543 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{1, 2, 4, 0, 0, 5, 0, 0, 3, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = createTree(root, index, TREE_VALUE);
        System.out.println(diameterOfBinaryTree(root));

    }

    //Solution
    static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    public static int depth(TreeNode node) {
        if (node == null)
            return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

    //build tree form int[]
    public static TreeNode createTree(TreeNode node, int i, int[] TREE_VALUE) {
        if (0 == TREE_VALUE[i]) {
            return null;
        } else {
            node.setVal(TREE_VALUE[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++index, TREE_VALUE);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++index, TREE_VALUE);

        return node;
    }
}

