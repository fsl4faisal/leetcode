package sep20th2018;

public class HouseRobber198 {

	public int rob(int[] nums) {

		int prevYes = 0, prevNo = 0;

		for (int n : nums) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n + temp;
		}
		return Math.max(prevNo, prevYes);

	}

	public static void main(String[] args) {

//		System.out.println(new HouseRobber198().rob(new int[] { 1, 2, 3, 1 }));
//		System.out.println(new HouseRobber198().rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(new HouseRobber198().rob(new int[] { 2, 1, 1, 2 }));
	}
}
