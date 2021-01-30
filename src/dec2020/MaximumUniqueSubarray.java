package dec2020;

import java.util.HashSet;
import java.util.Set;

class MaximumUniqueSubarray {
	public int maximumUniqueSubarray(int[] nums) {

		int maxSum = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			Set<Integer> unique = new HashSet<>();
			if (!unique.contains(nums[i])) {
				unique.add(nums[i]);
				sum += nums[i];
			}else {
				
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// int[] nums = { 4, 2, 4, 5, 6 };
		int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };

		System.out.println(new MaximumUniqueSubarray().maximumUniqueSubarray(nums));
	}
}