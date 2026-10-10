public class L2_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        L2_BestTimeToBuyAndSellStock solution = new L2_BestTimeToBuyAndSellStock();
        System.out.println("Sample 1: " + solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Sample 2: " + solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
