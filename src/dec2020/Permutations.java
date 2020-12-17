package dec2020;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[i]);
			backtrack(nums, i, list, answer, nums.length);
			// list.remove(list.size() - 1);
		}
		List<List<Integer>> ans = new ArrayList<>();
		ans.addAll(answer);
		return ans;

	}

	public void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> answer, int size) {
		if (list.size() == size) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			answer.add(temp);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			backtrack(nums, index, list, answer, size);
			list.remove(list.size() - 1);
			index++;
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		List<List<Integer>> answer = new Permutations().permute(nums);
		System.out.println(answer);
	}
}
