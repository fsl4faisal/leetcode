package findMaxForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.json.JSONArray;

class Solution {
	public int findMaxForm(String[] strs, int m, int n) {

		int[] zeros = new int[strs.length];
		int[] ones = new int[strs.length];

		for (int i = 0; i < strs.length; i++) {
			int numberOfOnes = 0;
			int numberOfZeros = 0;
			for (int j = 0; j < strs[i].length(); j++) {
				if (strs[i].charAt(j) == '0') {
					numberOfZeros++;
				} else {
					numberOfOnes++;
				}
			}
			zeros[i] = numberOfZeros;
			ones[i] = numberOfOnes;
		}
		for (int i : zeros)
			System.out.print(i + " ");
		System.out.println();
		for (int i : ones)
			System.out.print(i + " ");
		System.out.println();
		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return knapsack(zeros, ones, m, n, 0, dp);

	}

	int knapsack(int[] zeros, int[] ones, int m, int n, int index, int[][][] dp) {
		if (index == zeros.length) {
			return 0;
		}
		if (dp[index][m][n] != -1) {
			return dp[index][m][n];
		} else if (m < zeros[index] || n < ones[index]) {
			return knapsack(zeros, ones, m, n, index + 1, dp);
		} else {
			int temp1 = 1 + knapsack(zeros, ones, m - zeros[index], n - ones[index], index + 1, dp);
			int temp2 = knapsack(zeros, ones, m, n, index + 1, dp);
			int result = Math.max(temp1, temp2);
			dp[index][m][n] = result;
			return result;
		}
	}
}

public class FindMaxForm {
	public static String[] stringToStringArray(String line) {

		JSONArray jsonArr = new JSONArray(line);
		String[] arr = new String[jsonArr.length()];
		for (int i = 0; i < jsonArr.length(); i++) {
			arr[i] = (String) jsonArr.get(i);
		}

		return arr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String[] strs = stringToStringArray(line);
			line = in.readLine();
			int m = Integer.parseInt(line);
			line = in.readLine();
			int n = Integer.parseInt(line);

			int ret = new Solution().findMaxForm(strs, m, n);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}