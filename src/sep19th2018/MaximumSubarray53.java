package sep19th2018;

public class MaximumSubarray53 {

	public int maxSubArray(int[] nums) {

//		int maxSum = Integer.MIN_VALUE;
//		for (int i = 0; i < nums.length; i++) {
//			int sum = 0;
//			for (int j = i; j < nums.length; j++) {
//				sum += nums[j];
//				if (sum > maxSum)
//					maxSum = sum;
//			}
//		}
//
//		return maxSum;
		
		int[] dp=new int[nums.length];
		int sum=nums[0];
		dp[0]=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
			sum=Math.max(dp[i], sum);
		}
		return sum;
	}

	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		System.out.println(new MaximumSubarray53().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(new MaximumSubarray53().maxSubArray(new int[] { -1 }));
	}
}
