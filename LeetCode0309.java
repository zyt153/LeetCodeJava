/* Best Time to Buy and Sell Stock with Cooldown
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Similar: 121. Best Time to Buy and Sell Stock
 * */

public class LeetCode0309 {
    public static void main(String args[]) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[prices.length][3];
        f[0][0] = 0 - prices[0];
        //状态转移见
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        //最后拥有股票（0状态）无意义，因此仅从1、2状态中取最大值
        return Math.max(f[prices.length - 1][1], f[prices.length - 1][2]);

        /* 空间优化
        * f[i][..]只与f[i-1][..]有关，而与f[i-2][..]及之前的所有状态都无关，因此不必存储这些无关的状态。

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);*/
    }
}
