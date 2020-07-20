import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
	int i = 0;

	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % 2 != 0)
			return false;
		return canPartition(nums, 0, 0, sum, new HashMap<String, Boolean>());
	}

	private boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state) {

		String current = index + " " + sum;
		if (state.containsKey(current))
			return state.get(current);
		if (sum * 2 == total)
			return true;
		if (sum * 2 > total || index >= nums.length)
			return false;
		boolean foundPartition = canPartition(nums, index + 1, sum + nums[index], total, state)
				|| canPartition(nums, index + 1, sum, total, state);
		state.put(current, foundPartition);

		System.out.println(state + " " + i);
		i++;
		return foundPartition;
	}
}

public class Partition_Equal_Subset_Sum {
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

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);

			boolean ret = new Solution().canPartition(nums);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}
}