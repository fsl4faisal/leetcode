package aug25th2018;

public class ReshapeTheMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		int origRow = nums.length;
		int origCol = nums[0].length;

		if (r * c != origCol * origRow) {
			return nums;
		}
		int[][] newMatrix = new int[r][c];

		int[] data = new int[origRow * origCol];
		int k = 0;
		for (int i = 0; i < origRow; i++) {
			for (int j = 0; j < origCol; j++) {
				data[k++] = nums[i][j];
			}
		}

		k = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newMatrix[i][j] = data[k++];
			}
		}

		return newMatrix;
	}
	
	public static void print(int[][] B){
		for(int i=0;i<B.length;i++){
			for(int j=0;j<B[i].length;j++)
				System.out.print(B[i][j]+" ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		ReshapeTheMatrix r = new ReshapeTheMatrix();
		int[][] nums2=r.matrixReshape(nums, 1, 5);
		print(nums2);
	}

}
