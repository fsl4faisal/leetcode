package jan2020;

public class MaximumSubArray {

	public int maxSubArray(int[] nums) {

		int globalMax = nums[0];
		int sum = 0;

		int minNegativeNum = checkForNegatives(nums);
		if (minNegativeNum != -1) {
			return nums[minNegativeNum];
		}
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < 0) {
				sum = 0;
			}
			globalMax = Math.max(globalMax, sum);

		}
		return globalMax;

	}

	public int checkForNegatives(int[] nums) {
		boolean flag = false;
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return -1;
			}
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	public static void main(String[] args) {
		 int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//int[] input = { -1 };
		System.out.println(new MaximumSubArray().maxSubArray(input));

	}
}
