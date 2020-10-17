/* Best Time to Buy and Sell Stock
* Input: [7,1,5,3,6,4]
* Output: 5
* Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
* */

public class LeetCode0121 {
    public static void main(String args[]){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > maxprofit)
                maxprofit = prices[i] - min;
        }
        return maxprofit;
    }
}
