package sep10th2018;

public class BestTimetoBuyAndSellStockii {

	public int maxProfit(int[] prices) {

		int total = 0;
		for(int i=0;i<prices.length-1;i++) {
			if(prices[i]<prices[i+1])
				total+=prices[i+1]-prices[i];
		}
		return total;
	}

	public static void main(String[] args) {

		int[] arr = { 7, 1, 5, 3, 6, 4 };
		System.out.println(new BestTimetoBuyAndSellStockii().maxProfit(arr));
	}
}
