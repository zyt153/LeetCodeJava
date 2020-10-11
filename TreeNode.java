public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public static int index = 0;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
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
