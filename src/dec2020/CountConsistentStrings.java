package dec2020;

import java.util.HashSet;
import java.util.Set;

class CountConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {

		Set<Character> set = new HashSet<>();
		int counter = 0;

		for (int i = 0; i < allowed.length(); i++)
			set.add(allowed.charAt(i));

		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			for (int j = 0; j < words[i].length(); j++) {
				if (!set.contains(words[i].charAt(j))) {
					flag = false;
					break;
				}

			}
			if (flag)
				counter++;

		}
		return counter;

	}

	public static void main(String[] args) {

		String allowed = "ab";
		String[] words = { "ad", "bd", "aaab", "baa", "badab" };
		System.out.println(new CountConsistentStrings().countConsistentStrings(allowed, words));
	}
}