/* House Robber III
 * Input:
 *   3
    / \
   4   5
  / \   \
 1   3   1
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * */

import java.util.HashMap;
import java.util.Map;

public class LeetCode0337 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{3, 4, 1, 0, 0, 3, 0, 0, 5, 0, 1, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(rob(root));
    }

    /*static Map<TreeNode, Integer> choose = new HashMap<TreeNode, Integer>();
    static Map<TreeNode, Integer> notchoose = new HashMap<TreeNode, Integer>();
    public static int rob(TreeNode root) {
        dfs(root);
        //getOrDefault(a, b)： if a exist then return a, else return default b
        return Math.max(choose.getOrDefault(root, 0), notchoose.getOrDefault(root, 0));
    }

    public static void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        choose.put(root, root.val + notchoose.getOrDefault(root.left, 0) +
                notchoose.getOrDefault(root.right, 0));
        notchoose.put(root, Math.max(choose.getOrDefault(root.left, 0), notchoose.getOrDefault(root.left, 0)) +
                Math.max(choose.getOrDefault(root.right, 0), notchoose.getOrDefault(root.right, 0)));
    }*/

    //Improve
    public static int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public static int[] dfs(TreeNode root) {
        if (root == null) {
            //int[rob this node, not rob this node]
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
