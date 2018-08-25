package aug25th2018;

/*
 * 
 * 
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
 * 
 * 
 */

public class ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int topLeft = getTopLeft(matrix, i, j);
				if (topLeft != -1 && topLeft != matrix[i][j])
					return false;
			}
		}
		return true;
	}

	int getTopLeft(int[][] matrix, int i, int j) {
		try {
			return matrix[i - 1][j - 1];
		} catch (ArrayIndexOutOfBoundsException ex) {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };

		ToeplitzMatrix obj = new ToeplitzMatrix();
		System.out.println(obj.isToeplitzMatrix(matrix));
	}
}
