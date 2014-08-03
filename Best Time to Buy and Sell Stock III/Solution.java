public class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if(len < 2)
    		return 0;
    	//profitA[i] means max profit in[0,i], B[i] means max profit in [i, len-1]. 
    	//if A end at i and B start from i only one transaction needed. cause buy at i then sell i get nothing.
    	int[] profitA = new int[len];
    	int[] profitB = new int[len];

    	int maxProfit = 0;

    	int buy = prices[0];
    	for(int i = 1; i < len; ++i){
    		//System.out.println(prices[i]);
    		profitA[i] = Math.max(profitA[i-1], prices[i] - buy);
    		if(buy > prices[i])
    			buy = prices[i];
    	}

    	int sell = prices[len-1];
    	for(int i = len-2; i >= 0; --i) {
    		profitB[i] = Math.max(profitB[i+1], sell - prices[i]);
    		if(sell < prices[i])
    			sell = prices[i];
    	}

    	for(int i = 0; i < len; ++i) {
    		maxProfit = Math.max(maxProfit, profitA[i] + profitB[i]);
    	}

    	return maxProfit;


    }
//    public int maxProfit1(int[] prices) {// O(n^2)
//    	int len = prices.length;
//    	if(len < 2)
//    		return 0;
//    	int maxProfit = 0;
//
//    	for(int i = 1; i < len; ++i) {
//    		int profitA = 0;
//    		int profitB = 0;
//    		int buyA = prices[0];
//    		int buyB = i == len-1 ? 0: prices[i+1];
//
//    		//first part 0 ~ i;
//    		for(int j = 1; j <= i; ++j) {
//    			if(profitA < prices[i] - buyA)
//    				profitA = prices[i] - buyA;
//    			if(buyA > prices[i])
//    				buyA = prices[i];
//    		}
//
//    		//second part i+1 ~ len-1
//    		for(int k = i+2; k < len; ++k) {
//    			if(profitB < prices[k] - buyB)
//    				profitB = prices[k] - buyB;
//    			if(buyB > prices[k])
//    				buyB = prices[k];
//    		}
//    		maxProfit = Math.max(maxProfit, profitA);
//    		maxProfit = Math.max(maxProfit, profitB);
//    		maxProfit = Math.max(maxProfit, profitA+profitB);
//    	}
//    	return maxProfit;
//        
//    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		char[][] A = {{'0','0','1','0'},{'0','0','0','1'},{'0','1','1','1'},{'0','0','1','1'}};
    		char[][] B = {{'0','1'},{'1','0'}};
    		int[] p = {1,2,4,3,1,5,4,6};
    		int[] p1 = {1,3,5,5,9};
    		System.out.println(s.maxProfit(p1));
    }
}