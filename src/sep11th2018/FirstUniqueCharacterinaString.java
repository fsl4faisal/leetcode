package sep11th2018;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstUniqueCharacterinaString {

	public int firstUniqChar(String s) {

		LinkedHashMap<Character, int[]> linkedMap = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int[] arr = { i, 1 };
			if (!linkedMap.containsKey(ch)) {
				linkedMap.put(ch, arr);
			} else {
				arr=linkedMap.get(ch);
				arr[1]++;
			}
		}
		for(Character ch:linkedMap.keySet()) {
			int[] arr=linkedMap.get(ch);
			if(arr[1]==1)
				return arr[0];
		}
		return -1;
		
//		for(Entry<Character, int[]> entry:linkedMap.entrySet()) {
//			System.out.print(entry.getKey()+" ");
//			for(int i:entry.getValue())
//				System.out.print(i+" ");
//			System.out.println();
//		}
//		return 0;

	}

	public static void main(String[] args) {

		String s = "leetcode";
		System.out.println(new FirstUniqueCharacterinaString().firstUniqChar(s));
		System.out.println(new FirstUniqueCharacterinaString().firstUniqChar("loveleetcode"));
	}
}
