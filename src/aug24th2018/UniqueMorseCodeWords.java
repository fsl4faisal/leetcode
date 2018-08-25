package aug24th2018;

import java.util.HashMap;

public class UniqueMorseCodeWords {
	public int uniqueMorseRepresentations(String[] words) {
		String[] morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--.." };

		HashMap<String, Integer> map = new HashMap();
		for (int i = 0; i < words.length; i++) {
			StringBuilder str = new StringBuilder();
			for (int j = 0; j < words[i].length(); j++) {
				char ch = (char) (words[i].charAt(j) - 97);
				str.append(morseCode[ch]);
			}
			if (map.containsKey(str.toString()))
				map.put(str.toString(), map.get(str.toString()) + 1);
			else
				map.put(str.toString(), 1);
		}

		return map.size();

	}

	public static void main(String[] args) {
		UniqueMorseCodeWords w = new UniqueMorseCodeWords();
		String[] words = new String[] { "gin", "zen", "gig", "msg" };
		int k=w.uniqueMorseRepresentations(words);
		System.out.println(k);
	}
}
