/* Lowest Common Ancestor of a Binary Tree
 * Input: p = 5, q = 4,
 *         3
          / \
         5   1
        / \ / \
       6  2 0  8
         / \
        7   4
 * Output: 5
 * */

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode0236 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{3, 5, 6, 0, 0, 2, 7, 0, 0, 4, 0, 0, 1, 0, 0, 0, 8, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    static Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    static Set<Integer> visited = new HashSet<Integer>();

    public static void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p != null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q!=null){
            if(visited.contains(q.val))
                return q;
            q = parent.get(q.val);
        }
        return null;
    }
}
