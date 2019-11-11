public class _121BestTimetoBuyandSellStock {
    public static void main(String[] args){
        _121BestTimetoBuyandSellStock test = new _121BestTimetoBuyandSellStock();
        int[] input = new int[]{};
        System.out.println(test.maxProfit(input));
    }
    public int maxProfit(int[] prices) {
        if(prices.length < 1){
            return 0;
        }
        int minCost = prices[0];
        int[] profits = new int[prices.length];
        for(int i = 0; i < profits.length; i++){
            profits[i] = Math.max(0, prices[i] - minCost);
            if(prices[i] < minCost){
                minCost = prices[i];
            }
        }

        return max(profits);
    }

    private int max(int[] profits) {
        int max = profits[0];
        for(int i : profits){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
