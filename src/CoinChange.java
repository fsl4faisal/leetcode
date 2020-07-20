import java.util.Arrays;

class SolutionCoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.sort(coins);

		for (int i = 1; i <= amount; i++)
			dp[i] = amount + 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
			}
		}

		if (dp[amount] == amount + 1)
			return -1;
		return dp[amount];
	}
}

public class CoinChange {

	public static void main(String[] args) {

//		int[] coins = { 2, 3, 5 };
//
//		int amount = 21;

		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;

		int ret = new SolutionCoinChange().coinChange(coins, amount);

		String out = String.valueOf(ret);

		System.out.print(out);
	}

}