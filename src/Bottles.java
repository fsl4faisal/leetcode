class Bottles {
	public int numWaterBottles(int numBottles, int numExchange) {
		int totalBottles = 0;
		int emptyBottles = 0;
		int unusedBottles = 0;
		do {
			totalBottles += numBottles;
			emptyBottles = numBottles + unusedBottles;
			numBottles = emptyBottles / numExchange;
			unusedBottles = emptyBottles % numExchange;
		} while ((unusedBottles + numBottles) >= numExchange);
		totalBottles += numBottles;
		return totalBottles;
	}

	public static void main(String[] args) {
		System.out.println(new Bottles().numWaterBottles(9, 3));
		System.out.println(new Bottles().numWaterBottles(15, 4));
		System.out.println(new Bottles().numWaterBottles(5, 5));
		System.out.println(new Bottles().numWaterBottles(2, 3));
		System.out.println(new Bottles().numWaterBottles(15, 8));
	}
}