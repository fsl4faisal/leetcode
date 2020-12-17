
public class FenwickTree {

	public static void main(String[] args) {
		int[] nums = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
		NumArray obj = new NumArray(nums);
		//obj.update(i, val);
		//int param_2 = obj.sumRange(i, j);
	}
}

class NumArray {
	int[] binaryIndexTree;

	public NumArray(int[] nums) {
		binaryIndexTree = new int[nums.length + 1];
		binaryIndexTree[0] = 0;

	}

	public void update(int i, int val) {
		
		

	}

	public int sumRange(int i, int j) {

	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */