package DP;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static int maxProfit(int[] prices){
		// 1, 4, 6, 0, 8
		int low_price = Integer.MAX_VALUE, max_profit = 0;
		for(int i : prices){
			low_price = Math.min(low_price, i);
			max_profit = Math.max(max_profit, i - low_price);
		}
		return max_profit;
	}
	
	public static int maxProfit2(int[] prices){
		int max_profit = 0;
		for(int i = 1; i < prices.length; i++){
			int profit = prices[i] - prices[i - 1];
			max_profit += Math.max(profit, 0);
		}
		return max_profit;
	}
	
	public static int maxProfit3(int[] prices){
		int max_profit = 0, n = prices.length;
		int[] left = new int[n], right = new int[n];
		int low = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			low = Math.min(low, prices[i]);
			left[i] = i == 0 ? 0 : Math.max(left[i - 1], prices[i] - low);
		}
		
		int high = Integer.MIN_VALUE;
		for(int i = n - 1; i >= 0; i--){
			high = Math.max(high, prices[i]);
			right[i] = i == n - 1 ? 0 : Math.max(right[i + 1], high - prices[i]);
		}
		
		for(int i = 0; i < n; i++){
			max_profit = Math.max(max_profit, left[i] + right[i]);
		}
		return max_profit;
	}
	
	

	public int maxProfit4(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMin =  -prices[1];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] - tmpMin);
                tmpMin =  Math.min(tmpMin, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
    
    /*
     * buy[i]  = max(rest[i-1]-price, buy[i-1]) 
	 * sell[i] = max(buy[i-1]+price, sell[i-1])
	 * rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
	 * 
	 * 
	 * rest[i] = sell[i-1]
	 * 
	 * 
	 * buy[i] = max(sell[i-2]-price, buy[i-1])
	 * sell[i] = max(buy[i-1]+price, sell[i-1])
     */
    
    public int maxProfit5(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

}
