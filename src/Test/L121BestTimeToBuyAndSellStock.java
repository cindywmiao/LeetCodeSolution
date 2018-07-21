package Test;

public class L121BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int ans = 0, lowPrice= Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
        	lowPrice = Math.min(lowPrice, prices[i]);
        	ans = Math.max(ans, prices[i] - lowPrice);
        }
        return ans;
    }
}
