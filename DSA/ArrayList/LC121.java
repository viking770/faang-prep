public class LC121 {

    public static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int p : prices) {
            min = Math.min(min, p);
            profit = Math.max(profit, p - min);
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i< prices.length; i++){
            if(prices[i]<buy) buy = prices[i];
            else if(prices[i] - buy > profit) profit = prices[i] - buy;
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(LC121.maxProfit1(prices));
        System.out.println(LC121.maxProfit2(prices));
    }
    
}
