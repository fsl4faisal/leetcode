package sep11th2018;

public class TwoSum_II_InputArrayisSorted {

	public int[] twoSum(int[] numbers, int target) {

		int[] ans = new int[2];
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { i+1, j+1 };
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return new int[]{i,j};
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int[] ans = new TwoSum_II_InputArrayisSorted().twoSum(arr, 9);
		System.out.println(ans[0] + ","+ans[1]);
	}
}
