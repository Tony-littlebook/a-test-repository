package test;

public class SolutionOfMaxProfit {
	public int maxProfit(int[] prices) {
        if(prices == null) 
            return 0;
        int profit = theMaxProfit(prices, 0, prices.length - 1);
        if(profit > 0)
            return profit;
        else
            return 0;
    }
    public int theMaxProfit(int[] prices, int i, int j){
        if(i == j)
            return Integer.MIN_VALUE;
        else if(i + 1== j)
            return prices[j] - prices[i];
        else{
            int mid = (i + j) / 2;
            int profit = theMax(prices, mid + 1, j) - theMin(prices, i, mid);
            return Math.max(profit, Math.max(theMaxProfit(prices, mid +1, j), 
                                             theMaxProfit(prices, i, mid)));
            
        }
    }
    public int theMax(int[] prices, int i, int j){
        int max = prices[i];
        for(int k = i; k <= j; ++k){
            if(prices[k] > max)
                max = prices[k];
        }
        return max;
    }
    public int theMin(int[] prices, int i, int j){
        int min = prices[i];
        for(int k = i; k <= j; ++k){
            if(prices[k] < min)
                min = prices[k];
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfMaxProfit a = new SolutionOfMaxProfit();
		int [] prices = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9};
        System.out.println(a.maxProfit(prices));
	}

}
