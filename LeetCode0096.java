/* Unique Binary Search Trees
 * Input: 3
 * Output: 5
 * Explanation: Given n = 3, there are a total of 5 unique BST's:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * */

public class LeetCode0096 {
    public static void main(String args[]) {
        int n = 3;
        System.out.println(numTrees(n));
    }

    /*
     * 1.给出的n代表有n个节点，1,2,3,4,5，……n，这些节点组成的不同形态的二叉查找树，如果中序遍历这些树，得到的序列就是 1,2,3,4,5，……n。
     * 2.根据二叉查找树可以知道，某根节点x，它的左子树的值全<=x（当然本题不存在等于的情况），它的右子树的值全>=x，所以，当它的根节点是 1 的时候，
     *   左子树个数为 nums[0] ，右子树的个数为 nums[n-1]， 当它的根节点为 2 的时候， 左子树个数为 nums[1]， 右子树的个数为 nums[n-2]……
     * 3.这棵树的不同形态的二叉查找树的个数，就是根节点的左子树的个数*右子树的个数，即左边的所有情况乘以右边的所有情况。
     * 4.动态规划，从前到后计算出当有i个节点时,它有多少种不同形态的树。
     *   当节点个数为0时有一种形态的树（空树），当节点个数为1时有一种形态的树，之后就可以向下继续计算节点为2,3,4,5，……n。
     * */
    public static int numTrees(int n) {
        if (n == 0 || n == 1)
            return n;
        //当节点个数为0时有一种形态的树（空树），当节点个数为1时有一种形态的树
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {      //动态规划，从前到后计算出当有i个节点时,它有多少种不同形态的树
            for (int j = 1; j <= i; j++)    //从1到i充当root的情况（此时n=i）
                nums[i] += nums[j - 1] * nums[i - j];
        }
        return nums[n];
    }
}
