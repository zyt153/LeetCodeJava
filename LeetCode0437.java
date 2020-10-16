/* Path Sum III
 * Input: sum = 8
 *        10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1
 * Output: 3
 * The paths that sum to 8 are:
    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11
 * */

import java.util.ArrayList;
import java.util.List;

public class LeetCode0437 {
    public static int index = 0;
    public static int[] TREE_VALUE = new int[]{10, 5, 3, 3, 0, 0, -2, 0, 0, 2, 0, 1, 0, 0, -3, 0, 11, 0, 0};

    public static void main(String args[]) {
        TreeNode root = new TreeNode();
        root = TreeNode.createTree(root, index, TREE_VALUE);
        int sum = 8;
        System.out.println(pathSum(root, sum));
    }

    static int counter = 0;
    //两次迭代
    /*public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        dfs(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return counter;
    }

    public static void dfs(TreeNode root, int sum, int currentSum) {
        if (root == null)
            return;
        currentSum += root.val;
        if (currentSum == sum)
            counter += 1;
        dfs(root.left, sum, currentSum);
        dfs(root.right, sum, currentSum);
    }*/

    //一次迭代，使用list
    public static int pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0, new ArrayList<Integer>());
        return counter;
    }

    public static void dfs(TreeNode node, int sum, int currSum, List<Integer> list) {
        if (node == null)
            return;

        currSum += node.val;
        list.add(node.val);
        int tmp = currSum;

        for (Integer i : list) {
            if (tmp == sum)
                counter++;
            tmp -= i;       //逐个去掉最上面的节点，并判断是否等于sum
        }

        dfs(node.left, sum, currSum, new ArrayList<>(list));
        dfs(node.right, sum, currSum, new ArrayList<>(list));
    }
}
