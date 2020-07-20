import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {

	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 1; i < intervals.length;) {
			if (intervals[i][0] <= end) {
				end = Math.max(intervals[i][1],end);
				i++;
			} else {
				List<Integer> interval = new ArrayList<>();
				interval.add(Math.min(start, intervals[i][0]));
				interval.add(end);
				ans.add(interval);
				start = intervals[i][0];
				end = intervals[i][1];
				i++;
			}
		}
		List<Integer> interval = new ArrayList<>();
		interval.add(start);
		interval.add(end);
		ans.add(interval);
		int[][] answer = convert(ans);
		// print(ans);

		return answer;
	}

	void print(List<List<Integer>> intervals) {
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).get(0) + " " + intervals.get(i).get(1));
		}
	}

	int[][] convert(List<List<Integer>> intervals) {
		int[][] answer = new int[intervals.size()][2];

		for (int i = 0; i < intervals.size(); i++) {
			answer[i][0] = intervals.get(i).get(0);
			answer[i][1] = intervals.get(i).get(1);
		}
		return answer;

	}

	public static void main(String[] args) {
//		int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] input = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
		
//		int[][] input = { { 1, 4 }, { 4, 5 } };
		MergeIntervals merge = new MergeIntervals();
		int[][] answer = merge.merge(input);

		print(answer);
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}