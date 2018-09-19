package sep10th2018;

import java.util.HashSet;

public class ContainDuplicate {

	public boolean containsDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i))
				return true;
			else
				set.add(i);
		}
		return false;

	}

	public static void main(String[] args) {

		System.out.println(new ContainDuplicate().containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
		System.out.println(new ContainDuplicate().containsDuplicate(new int[] {1,3,4,2}));
	}
}
