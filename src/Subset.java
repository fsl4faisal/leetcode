import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SubsetSolution {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(nums, new ArrayList<>(), answer);
		return answer;
	}
	// [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

	void backTrack(int[] nums, List<Integer> current, List<List<Integer>> answer) {

		//System.out.println(current);
		List<Integer> temp = new ArrayList<>(current);
		Collections.sort(temp);
		if (!answer.contains(temp)) {
			answer.add(new ArrayList<Integer>(temp));
			//System.out.println("answer updated:" + answer);
		}

		for (int i = 0; i < nums.length; i++) {
			if (current.contains(nums[i]))
				continue;
			current.add(nums[i]);
			//System.out.println("Adding: " + nums[i] + " " + current);
			backTrack(nums, current, answer);
			current.remove(current.size() - 1);
			//System.out.println("Removed :" + current);
		}
	}

}

public class Subset {
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

	public static void main(String[] args) throws IOException {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 };

		List<List<Integer>> ret = new SubsetSolution().subsets(nums);

		System.out.print(ret);
	}
}