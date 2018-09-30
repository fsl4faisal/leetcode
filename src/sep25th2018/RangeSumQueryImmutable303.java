package sep25th2018;

public class RangeSumQueryImmutable303 {

	static class NumArray {
		int[] number;

		public NumArray(int[] nums) {

			int sum=0;
			number = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				sum+=nums[i];
				number[i] += sum;
			}
			System.out.println(number);

		}

		public int sumRange(int i, int j) {
			if (i == 0)
				return number[j];

			return number[j ] - number[i-1];
		}
	}

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray obj =
	 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 * 
	 */
	public static void main(String[] args) {

		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray obj = new NumArray(nums);

		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}
}
