package Extra;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int sum = 0, cheapestBuy = prices[0];
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] - cheapestBuy > sum) {
                sum = prices[j] - cheapestBuy;
            }
        }
        for (int i = 0; i < prices.length; i++) {
            if (cheapestBuy > prices[i]) {
                cheapestBuy = prices[i];
                for (int j = i; j < prices.length; j++) {
                    if (prices[j] - prices[i] > sum) {
                        sum = prices[j] - prices[i];
                    }
                }
            }

        }
        return sum;
    }
}
