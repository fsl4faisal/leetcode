package sep11th2018;

import java.util.HashMap;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {

		HashMap<Character, Integer> magMap = new HashMap<>();
		HashMap<Character, Integer> ransomMap = new HashMap<>();

		for (int i = 0; i < ransomNote.length(); i++) {
			ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
		}
		for (int i = 0; i < magazine.length(); i++) {
			magMap.put(magazine.charAt(i), magMap.getOrDefault(magazine.charAt(i), 0) + 1);
		}
		
		for(char ch:ransomMap.keySet()) {
			if(magMap.getOrDefault(ch, 0)<ransomMap.get(ch))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new RansomNote().canConstruct("a", "b"));
		System.out.println(new RansomNote().canConstruct("aa", "ab"));
		System.out.println(new RansomNote().canConstruct("aa", "aab"));
	}

}
