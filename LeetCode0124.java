/* Binary Tree Maximum Path Sum
 * Input:
 *         -10
           /  \
          9   20
             /  \
            15   7
 * Output: 42
 * */

public class LeetCode0124 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{-10, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(maxPathSum(root));
    }

    public static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        int pathValue = root.val + leftMax + rightMax;   //包含当前根节点的完整路径值
        max = Math.max(max, pathValue);                  //更新max
        return root.val + Math.max(leftMax, rightMax);   //返回当前节点能给上层贡献的最大值
    }
}
