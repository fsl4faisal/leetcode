import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> finalAns = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}

		for (int i = 0; i < nums.length - 1; i++) {
			int a = nums[i];
			List<List<Integer>> list = new ArrayList<>();
			twoSum(nums, i + 1, -1 * a, list);
			set.addAll(list);
		}

		for (List<Integer> ans : set)
			finalAns.add(ans);
		return finalAns;
	}

	public void twoSum(int[] list, int startIndex, int target, List<List<Integer>> ansList) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = startIndex; i < list.length; i++) {
			if (map.containsKey(target - list[i])) {
				List<Integer> temp = new ArrayList<>(Arrays.asList(target - list[i], list[i], -1 * target));
				Collections.sort(temp);
				ansList.add(temp);
			}
			map.put(list[i], i);
		}

	}

	public static void main(String[] args) {
		int[] nums = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
		List<Integer> list = new ArrayList<>(Arrays.asList(1212, 12));
		List<List<Integer>> finalAns = new ThreeSum().threeSum(nums);
		System.out.println(finalAns);

	}

}