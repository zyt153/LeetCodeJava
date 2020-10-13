/* Binary Tree Level Order Traversal
 * Input:
 *      3
       / \
      9  20
        /  \
       15   7
 * Output: [[3], [9,20], [15,7]]
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0102 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{3, 9, 0, 0, 20, 15, 0, 0, 7, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {          //process level per iteration
            List<Integer> level = new ArrayList<>();    //store one level
            for (int countLevel = queue.size(); countLevel > 0; countLevel--) {
                root = queue.remove();      //remove the first treenode in the queue
                level.add(root.val);

                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            list.add(level);
        }

        return list;
    }
}
