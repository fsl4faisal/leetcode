package sep3rd2018;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {

		int[] arr = new int[nums.length + 1];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0)
				list.add(i);
		}

		return list;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
		
		System.out.println(new FindAllNumbersDisappearedinanArray().findDisappearedNumbers(arr));
	}
}
