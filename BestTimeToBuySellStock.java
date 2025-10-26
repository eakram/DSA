public class BestTimeToBuySellStock {

    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i++){
            int current = 0;
            if (prices[i] > low){
                current = prices[i] - low;
                maxProfit = Math.max(current, maxProfit);
            } else {
                low = prices[i];
            }
        }
        return maxProfit;
    }
}
