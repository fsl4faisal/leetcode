package dec2020;

class ReformatNumber {
	public String reformatNumber(String number) {

		number = number.replaceAll(" ", "").replaceAll("-", "");
		// System.out.println(number);
		int i = 0;
		int j = number.length();
		StringBuffer sb = new StringBuffer("");
		while (i < j) {
			if ((j - i) > 4) {
				sb.append(number.substring(i, i + 3));
				i += 3;
			} else if ((j - i) == 3 && i + 3 == j) {
				sb.append(number.substring(i, i + 3));
				i += 3;

			} else {
				sb.append(number.substring(i, i + 2));
				i += 2;
			}
			sb.append("-");
		}
		return sb.substring(0, sb.length() - 1).toString();
	}

	public static void main(String[] args) {

		System.out.println(new ReformatNumber().reformatNumber("1-23-45 6"));

		System.out.println(new ReformatNumber().reformatNumber("1-23-45 6"));
		System.out.println(new ReformatNumber().reformatNumber("123 4-567"));
		System.out.println(new ReformatNumber().reformatNumber("123 4-5678"));
		System.out.println(new ReformatNumber().reformatNumber("12"));
		System.out.println(new ReformatNumber().reformatNumber("--17-5 229 35-39475 "));

	}
}