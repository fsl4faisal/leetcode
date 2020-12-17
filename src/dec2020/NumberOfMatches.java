package dec2020;

class NumberOfMatches {
	public int numberOfMatches(int n) {
		int matches = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				matches += (n / 2);
				n /= 2;
			} else {
				matches += (n - 1) / 2;
				n = (n - 1) / 2 + 1;
			}
		}
		return matches;
	}

	public static void main(String[] args) {

		System.out.println(new NumberOfMatches().numberOfMatches(7));
		System.out.println(new NumberOfMatches().numberOfMatches(14));

	}
}