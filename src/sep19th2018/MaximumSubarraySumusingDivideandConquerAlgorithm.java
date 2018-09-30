package sep19th2018;

public class MaximumSubarraySumusingDivideandConquerAlgorithm {

	public int maxCrosssingSum(int[] arr, int l, int m, int h) {
		System.out.println("maxCrosssingSum " + l + " " + m + " " + h);
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum += arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum += arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}
		return left_sum + right_sum;
	}

	int maxSubArray(int[] arr, int l, int h) {
		System.out.println("maxSubArray " + l + " " + h);
		if (l == h - 1)
			return arr[l];
		int m = (l + h) / 2;

		return Math.max(Math.max(maxSubArray(arr, l, m), maxSubArray(arr, m + 1, h)), maxCrosssingSum(arr, l, m, h));
	}

	public static void main(String[] args) {

		int[] arr = { -2, -5, 6, -2, -3, 1, 5, -6 };
		System.out.println(new MaximumSubarraySumusingDivideandConquerAlgorithm().maxSubArray(arr, 0, arr.length - 1));

	}
}
