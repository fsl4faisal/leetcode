import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PalindromePartitioning {
	public List<List<String>> partition(String s) {

		List<List<String>> answer = new ArrayList<>();

		backTrack(s, new ArrayList<String>(), answer, new HashMap<String, Boolean>());
		return answer;
	}

	void backTrack(String input, List<String> current, List<List<String>> answer, Map<String, Boolean> map) {
		if (input.equals("")) {
			System.out.println("Adding in the answer:" + current + " input:" + input);
			answer.add(new ArrayList<String>(current));
		}
		for (int i = 1; i <= input.length(); i++) {
			
			if (!isPalindrome(input.substring(0, i), map)) {
				System.out.println(" Checking for palindrome: Skipping:" + input.substring(0, i));
				continue;
			}
			System.out.println("Adding:");
			current.add(input.substring(0, i));
			System.out.println("Current:" + current);
			backTrack(input.substring(i), current, answer, map);
			System.out.println("BackTracking: current:" + current);
			current.remove(current.size() - 1);
			System.out.println("BackTracking: after removing last element current:" + current);
		}

	}

	boolean isPalindrome(String input, Map<String, Boolean> map) {
		int length = input.length();
		// if (length == 0)
		// return false;
		if (map.containsKey(input))
			return map.get(input);

		if (length == 1) {
			map.put(input, true);
			return true;
		}

		int rightIndex = length - 1;
		int leftIndex = 0;

		while (leftIndex <= rightIndex) {
			if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
				map.put(input, false);
				return false;
			}

			leftIndex++;
			rightIndex--;
		}
		map.put(input, true);
		return true;
	}

	public static void main(String[] args) {
		String input = "seesse";
		PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
		List<List<String>> answer = palindromePartitioning.partition(input);

		System.out.println("answer:" + answer);
	}

}
