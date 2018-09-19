package aug29th2018;

public class GoatLatin {

	public String toGoatLatin(String S) {

		String[] words = S.split(" ");

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			char ch = word.charAt(0);
			switch (ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				sb.append(word).append("ma");
				break;
			default:
				sb.append(word.substring(1, word.length())).append(word.charAt(0)).append("ma");
			}
			for(int k=0;k<=i;k++)
				sb.append("a");
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String str = "I speak Goat Latin";
		System.out.println(new GoatLatin().toGoatLatin(str));

	}

}
