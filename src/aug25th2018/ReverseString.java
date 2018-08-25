package aug25th2018;

public class ReverseString {

	public String reverseString(String s) {

		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--)
			sb.append(s.charAt(i));

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		ReverseString obj = new ReverseString();
		System.out.println(obj.reverseString(str));
	}

}
