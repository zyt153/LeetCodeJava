/* Serialize and Deserialize Binary Tree
 * Input:
 *         1
          / \
         2   3
            / \
           4   5
 * Output: Same as input
 * */

import com.sun.source.tree.Tree;

public class LeetCode0297 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{1, 2, 0, 0, 3, 4, 0, 0, 5, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(serialize(root));
        TreeNode.output(deserialize(serialize(root)));
    }

    // Encodes a tree to a single string.
    static String str = new String();

    public static String serialize(TreeNode root) {
        if (root == null)
            str += "null" + ",";
        else {
            str += str.valueOf(root.val) + ",";
            serialize(root.left);
            serialize(root.right);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    static int index1 = 0;

    public static TreeNode deserialize(String data) {
        TreeNode root = new TreeNode();
        String[] s = data.split(",");
        return repreorder(root, index1, s);
    }

    public static TreeNode repreorder(TreeNode node, int i, String[] s) {
        if (s[i].equals("null")) {
            return null;
        } else {
            node.val = Integer.valueOf(s[i]);
        }

        TreeNode leftChild = new TreeNode();
        node.left = repreorder(leftChild, ++index1, s);
        TreeNode rightChild = new TreeNode();
        node.right = repreorder(rightChild, ++index1, s);

        return node;
    }
}
