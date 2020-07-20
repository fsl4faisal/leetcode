
class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0;

		int tempM = m;
		while (i < m && j < n) {
			if (nums1[i] >= nums2[j]) {
				tempM = shiftRight1(nums1, tempM);
				nums1[i] = nums2[j];
				j++;
				//i++;
			} else {
				i++;
			}
			print(nums1);
		}
		i = tempM;
		while (i < nums1.length && j < n) {
			nums1[i++] = nums2[j++];
		}
	}

	public void print(int[] nums) {
		for (int i : nums)
			System.out.print(i + " ");
		System.out.println();
	}

	public int shiftRight1(int[] nums, int m) {
		int newM = m;

		while (m != 0) {
			nums[m] = nums[--m];
		}
		return newM + 1;
	}

	public static void main(String[] args) {

		int[] nums1 = { 4, 5, 6, 0, 0, 0 };
		int[] nums2 = { 1, 2, 3 };
		int m = 3;
		int n = 3;
		
		new MergeSortedArray().merge(nums1, m, nums2, n);
		for(int i: nums1)
			System.out.print(i+" ");

	}
}