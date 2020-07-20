
public class IntegerBreak {

	public int integerBreak(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			System.out.println("i:" + i);
			int max = 1;
			for (int j = 1; j <= i / 2; j++) {
				int factor1 = Math.max(j, dp[j]);
				int factor2 = Math.max(i - j, dp[i - j]);
				System.out.println(j + " " + dp[j] + " " + factor1);
				System.out.println(i - j + " " + dp[i - j] + " " + factor2);
				max = Math.max(max, factor1 * factor2);
				System.out.println("MAX:" + max);
			}
			dp[i] = max;
			print(dp);

		}

		return dp[n];
	}

	private void print(int[] dp) {
		for (int i : dp)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		System.out.println(new IntegerBreak().integerBreak(15));
	}
}
