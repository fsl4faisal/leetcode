package dec2020;

import java.util.HashSet;
import java.util.Set;

public class HalvesAreAlike {
	public boolean halvesAreAlike(String s) {

		s = s.toLowerCase();
		int countVowel = 0;
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		for (int i = 0; i <s.length() / 2; i++) {
			char ch = s.charAt(i);
			if (vowels.contains(ch))
				countVowel++;
		}
		for (int i = s.length() / 2 ; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (vowels.contains(ch))
				countVowel--;
		}
		return countVowel == 0;

	}

	public static void main(String[] args) {
		System.out.println(new HalvesAreAlike().halvesAreAlike("book"));
	}
}
