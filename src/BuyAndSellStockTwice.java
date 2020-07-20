import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class SolutionBuyAndSellStockTwice {

	public int maxProfit(int[] prices) {

		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < prices.length; i++) {
			int profit1 = oneTransactionWithMemoization(prices, 0, i - 1, map);
			int profit2 = oneTransactionWithMemoization(prices, i, prices.length - 1, map);
			max = Math.max(max, profit1 + profit2);
		}
		return max;

	}

	public int oneTransactionWithMemoization(int[] prices, int start, int end, Map<Integer, Integer> map) {
		int max = 0;
		int smallest = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (prices[i] < smallest) {
				smallest = prices[i];
			}
			max = Math.max(max, prices[i] - smallest);
		}

		return max;
	}

	public int maxProfitv2(int[] prices) {

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			int profit1 = oneTransaction(prices, 0, i - 1);
			int profit2 = oneTransaction(prices, i, prices.length - 1);
			max = Math.max(max, profit1 + profit2);
		}
		return max;

	}

	public int oneTransaction(int[] prices, int start, int end) {
		int max = 0;
		int smallest = Integer.MAX_VALUE;
		int smallestIndex = 0;
		for (int i = start; i <= end; i++) {
			if (prices[i] < smallest) {
				smallest = prices[i];
				smallestIndex = i;
			}
			max = Math.max(max, prices[i] - smallest);

		}

		return max;
	}
}

public class BuyAndSellStockTwice {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] prices = stringToIntegerArray(line);

			int ret = new SolutionBuyAndSellStockTwice().maxProfit(prices);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}