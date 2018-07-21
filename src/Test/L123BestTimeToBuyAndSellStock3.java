package Test;

public class L123BestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
        int ans = 0, len = prices.length, lowPrice = Integer.MAX_VALUE, highPrice = Integer.MIN_VALUE;
        int[] left = new int[len], right = new int[len];
        for(int i = 0; i < len; i++){
        	lowPrice = Math.min(lowPrice, prices[i]);
        	left[i] = Math.max(i == 0 ? 0 : left[i - 1], prices[i] - lowPrice);
        }
        for(int i = len - 1; i >= 0; i--){
        	highPrice = Math.max(highPrice, prices[i]);
        	right[i] = Math.max(i == len - 1 ? 0 : right[i + 1], highPrice - right[i]);
        }
        for(int i = 0; i < len; i++){
        	ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }
}
