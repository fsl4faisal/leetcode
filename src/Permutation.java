import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class PermutationSolution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		permute(nums, new ArrayList<>(), answer);
		for (int i = 0; i < answer.size(); i++) {
			// System.out.println(answer.get(i));
		}
		return answer;
	}

	void permute(int[] nums, List<Integer> temp, List<List<Integer>> answer) {
		if (temp.size() == nums.length) {
			answer.add(new ArrayList<>(temp));
			System.out.println(temp);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i]))
				continue;
			temp.add(nums[i]);
			System.out.println("Adding:" + nums[i] + " index:" + i + " " + temp);
			permute(nums, temp, answer);
			temp.remove(temp.size() - 1);
			System.out.println("index:" + i + " BackTracking:" + temp);
		}
	}

}

public class Permutation {
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

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static String int2dListToString(List<List<Integer>> nums) {
		StringBuilder sb = new StringBuilder("[");
		for (List<Integer> list : nums) {
			sb.append(integerArrayListToString(list));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> ret = new PermutationSolution().permute(nums);

		String out = int2dListToString(ret);

		System.out.print(out);

	}
}
