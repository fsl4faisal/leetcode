import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {

	public List<Integer> topKFrequentV2(int[] nums, int k) {

		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(new FrequentComparator());
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}

		while (k != 0) {
			ans.add(pq.poll().getKey());
			k--;
		}

		return ans;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		// Array of lists
		// @SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[nums.length];

		for (Integer key : map.keySet()) {
			if (buckets[map.get(key)] == null) {
				buckets[map.get(key)] = new ArrayList<>();
				buckets[map.get(key)].add(key);
			} else {
				buckets[map.get(key)].add(key);
			}
		}
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] != null) {
				for (Integer item : buckets[i]) {
					if (k > 0) {
						ans.add(item);
						k--;

					}
				}
			}
		}

		return ans;
	}

	public class FrequentComparator implements Comparator<Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			return o2.getValue() - o1.getValue();
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(new Top_K_Frequent_Elements().topKFrequent(nums, k));
	}
}
