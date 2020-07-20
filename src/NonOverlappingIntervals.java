import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class NonOverlappingIntervalsSolution {
	public int eraseOverlapIntervals(int[][] intervals) {

//		Arrays.sort(intervals, new Comparator() {
//			public int compare(Object obj1, Object obj2) {
//				int[] arr1 = (int[]) obj1;
//				int[] arr2 = (int[]) obj2;
//				return arr1[1] - arr2[1];
//			}
//		});

//		Arrays.sort(intervals, (Object obj1, Object obj2) -> {
//			int[] arr1 = (int[]) obj1;
//			int[] arr2 = (int[]) obj2;
//			return arr1[1] - arr2[1];
//		});
//		
		Arrays.sort(intervals, (int[] arr1, int[] arr2) -> {
			return arr1[1] - arr2[1];
		});

		Arrays.sort(intervals, (int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);

		print(intervals);
		int end = intervals[0][1];
		int length = intervals.length;
		int counter = 0;
		for (int i = 1; i < length; i++) {
			if (intervals[i][0] >= end) {
				end = intervals[i][0];
			} else {
				counter++;
				end = intervals[i][1];
			}
		}

		return counter;

	}

	/*
	 * void sort(int[][] intervals ){ int n=intervals.length; for(int i=0;i<n;i++){
	 * for(int j=i+1;j<n;j++){ if(intervals[i][1]>intervals[j][1])
	 * swap(intervals,i,j); } } }
	 * 
	 * void swap(int[][] intervals, int i, int j){ int startTemp=intervals[i][0];
	 * int endTemp=intervals[i][1];
	 * 
	 * intervals[i][0]=intervals[j][0]; intervals[i][1]=intervals[j][1];
	 * 
	 * intervals[j][0]=startTemp; intervals[j][1]=endTemp; }
	 */

	void print(int[][] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i][0] + " " + intervals[i][1]);
		}
	}
}

public class NonOverlappingIntervals {
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
		int[][] intervals = { { 0, 1 }, { 3, 4 }, { 1, 2 } };

		int ret = new NonOverlappingIntervalsSolution().eraseOverlapIntervals(intervals);

		String out = String.valueOf(ret);

		System.out.print(out);

	}
}