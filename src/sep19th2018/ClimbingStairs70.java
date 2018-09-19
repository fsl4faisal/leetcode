package sep19th2018;

public class ClimbingStairs70 {

	public int climbStairs(int n) {
		int[] saveSteps = new int[n + 1];

		return climb(n, saveSteps);
	}

	public int climb(int n, int[] saveSteps) {
		if (saveSteps[n] != 0)
			return saveSteps[n];
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			saveSteps[n] = climb(n - 1, saveSteps) + climb(n - 2, saveSteps);
			return saveSteps[n];
		}

	}

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs70().climbStairs(5));
		System.out.println(new ClimbingStairs70().climbStairs(2));
		System.out.println(new ClimbingStairs70().climbStairs(3));
		System.out.println(new ClimbingStairs70().climbStairs(44));
	}
}
