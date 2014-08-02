public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)
        	return 0;
        int profit = 0;
        int buy = prices[0];
        //int sell = 0;
        for(int i = 1; i < len; ++i) {
        	if(prices[i-1] > prices[i]){ // find the increasing sequence
        		//sell at i - 1
        		profit += prices[i-1] - buy;
        		buy = prices[i];
        	}
        }
        profit += prices[len-1] - buy;

        return profit;
    }
}