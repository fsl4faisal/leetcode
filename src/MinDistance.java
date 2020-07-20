import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class MinDistanceSolution {
	public int minDistance(String word1, String word2) {

		Map<String, Integer> map = new HashMap<>();
		return getMinEditDistance(word1, word2, 0, 0, 0, map);

	}

	public int getMinEditDistance(String str1, String str2, int counter, int index1, int index2,
			Map<String, Integer> map) {
		System.out.println(str1 + " " + counter);
		if (index1 > str1.length() && index2 > str2.length()) {
			return counter;
		}
//		if (map.containsKey(str1)) {
//			return map.get(str1);
//		}

		if (index1 < str1.length() && index2 < str2.length() && str1.charAt(index1) == str2.charAt(index2)) {
			int equal = getMinEditDistance(str1, str2, counter, index1 + 1, index2 + 1, map);
//			map.put(str1, equal);
//			return map.get(str1);
			return equal;
		} else {
			int afterDelete = Integer.MAX_VALUE;
			if (index1 < str1.length()) {
				String delete = deleteOperation(str1, index1);

				// map.put(delete, getMinEditDistance(delete, str2, counter + 1, index1 + 1,
				// index2 + 1, map));
				// afterDelete = map.get(delete);
				afterDelete = getMinEditDistance(delete, str2, counter + 1, index1 + 1, index2 + 1, map);
			}
			int afterReplace = Integer.MAX_VALUE;
			if (index1 < str1.length() && index2 < str2.length()) {
				String replace = replaceOperation(str1, index1, str2.charAt(index2));
//				map.put(replace, getMinEditDistance(replace, str2, counter + 1, index1 + 1, index2 + 1, map));
//				afterReplace = map.get(replace);
				afterReplace = getMinEditDistance(replace, str2, counter + 1, index1 + 1, index2 + 1, map);
			}

			int afterInsert = Integer.MAX_VALUE;
			if (index1 <= str1.length() && index2 < str2.length()) {
				String insert = insertOperation(str1, index1, str2.charAt(index2));
//				map.put(insert, getMinEditDistance(insert, str2, counter + 1, index1 + 1, index2 + 1, map));
//				afterInsert = map.get(insert);
				afterInsert = getMinEditDistance(insert, str2, counter + 1, index1 + 1, index2 + 1, map);
			}
//			map.put(str1, Math.min(afterDelete, Math.min(afterReplace, afterInsert)));
//			return map.get(str1);
			return Math.min(afterDelete, Math.min(afterReplace, afterInsert));

		}
	}

	private String deleteOperation(String str, int index) {
		return str.substring(0, index) + str.substring(index + 1, str.length());
	}

	private String replaceOperation(String str, int index, char ch) {
		return str.substring(0, index) + ch + str.substring(index + 1, str.length());
	}

	private String insertOperation(String str, int index, char ch) {
		// System.out.println("InsertOperation:"+str+" "+ index+" "+ch);
		return str.substring(0, index) + ch + str.substring(index, str.length());
	}
}

public class MinDistance {
	public static String stringToString(String input) {

//		JSONArray jsonArray = new JSONArray(input);
//		return jsonArray.getString(0);
		return input;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String word1 = in.readLine();
		String word2 = in.readLine();

		int ret = new MinDistanceSolution().minDistance(word1, word2);

		String out = String.valueOf(ret);

		System.out.println(out);

	}
}