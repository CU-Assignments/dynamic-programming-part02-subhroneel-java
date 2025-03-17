class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int n = prices.length;
        int[] hold = new int[n];   // Maximum profit when holding a stock
        int[] sell = new int[n];   // Maximum profit when selling a stock
        int[] cooldown = new int[n]; // Maximum profit during cooldown

        hold[0] = -prices[0]; // Buying on the first day
        sell[0] = 0; // No profit if we sell on the first day
        cooldown[0] = 0; // No cooldown on first day
        
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]); // Buy or continue holding
            sell[i] = hold[i - 1] + prices[i]; // Sell the stock
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]); // Previous cooldown or previous sell
        }
        
        return Math.max(sell[n - 1], cooldown[n - 1]); // Maximum profit is in sell or cooldown
    }
}
