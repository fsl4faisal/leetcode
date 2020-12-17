package dec2020;

class GetSumAbsoluteDifferences {
	public int[] getSumAbsoluteDifferencesv2(int[] nums) {

		int[] output = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				output[i] += Math.abs(nums[i] - nums[j]);
			}
		}
		return output;
	}

	public int[] getSumAbsoluteDifferences(int[] nums) {

		int[] output = new int[nums.length];

		int cummSum = 0;
		for (int i = 0; i < nums.length; i++) {
			cummSum += nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			output[i] = Math.abs(nums.length * nums[i] - cummSum);
		}

		return output;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 4, 6, 8, 10 };
		int[] output = new GetSumAbsoluteDifferences().getSumAbsoluteDifferences(nums);

		print(output);
	}

	public static void print(int[] output) {
		for (int i : output)
			System.out.print(i + " ");
		System.out.println();
	}
}