/* Merge Two Binary Trees
 * Input:
 *     Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
 * Output:
 * Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
 * */

public class LeetCode0617 {
    public static int index = 0;
    public static int[] TREE_VALUE1 = new int[]{1, 3, 5, 0, 0, 0, 2, 0, 0};
    public static int[] TREE_VALUE2 = new int[]{2, 1, 0, 4, 0, 0, 3, 0, 7, 0, 0};

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode();
        t1 = createTree(t1, index, TREE_VALUE1);
        //output(t1);
        index = 0;
        TreeNode t2 = new TreeNode();
        t2 = createTree(t2, index, TREE_VALUE2);
        //output(t2);
        TreeNode t = mergeTrees(t1, t2);
        output(t);

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
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
    //output tree
    public static void output(TreeNode t) {
        if (t == null)
            return;
        System.out.println(t.val);
        output(t.left);
        output(t.right);
    }
}