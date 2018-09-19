package sep18th2018;

public class MinCostClimbingStairs746 {

	public int minCostClimbingStairs(int[] cost) {
		int[] dp=new int[cost.length];
		if(cost.length>2) {
			dp[0]=cost[0];
			dp[1]=cost[1];
		}
		for(int i=2;i<cost.length;i++){
			dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
		}
		return Math.min(dp[cost.length-1], dp[cost.length-2]);
	}

	public static void main(String[] args) {

		System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(
				new MinCostClimbingStairs746().minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}
}
