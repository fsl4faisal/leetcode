import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Subset_IISolution {
	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(nums, new ArrayList<>(), answer);
		return answer;
	}

	void backTrack(int[] nums, List<Integer> current, List<List<Integer>> answer) {

		// System.out.println("Printing current:" + current);
		if (current.size() == nums.length) {
			List<Integer> temp = new ArrayList<>(current);
			Collections.sort(temp);
			if (!answer.contains(current) && checkIfAllPresent(nums, temp))
				answer.add(new ArrayList<>(current));
		} else {
			for (int i = 0; i < nums.length; i++) {
				current.add(nums[i]);
				backTrack(nums, current, answer);
				current.remove(current.size() - 1);
			}

		}
	}

	boolean checkIfAllPresent(int[] nums, List<Integer> temp) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != temp.get(i))
				return false;
		}
		return true;
	}

}
/*
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 */

public class Subset_II {
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

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		int[] nums = { -1, 2, -1, 2, 1, -1, 2, 1 };

		List<List<Integer>> ret = new Subset_IISolution().permuteUnique(nums);

		System.out.print(ret);
	}

}