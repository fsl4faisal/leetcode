package aug24th2018;

public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		/*
		 * 
		 * Input: [[1,1,0],[1,0,1],[0,0,0]]
		 * 
		 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then,
		 * invert the image: [[1,0,0],[0,1,0],[1,1,1]]
		 * 
		 * Output: [[1,0,0],[0,1,0],[1,1,1]]
		 * 
		 */

		int[][] rev = new int[A.length][];
		for (int i = 0; i < A.length; i++) {
				rev[i]=new int[A[i].length];
			for (int j = A[i].length - 1, k = 0; j >= 0; j--) {
				rev[i][k++] = A[i][j];
			}
		}
		
		for(int i=0;i<rev.length;i++){
			for(int j=0;j<rev[i].length;j++){
				if(rev[i][j]==1)
					rev[i][j]=0;
				else
					rev[i][j]=1;
			}
		}

		return rev;
	}

	public static void main(String[] args) {
		FlippingAnImage f = new FlippingAnImage();
		int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		int[][] B=f.flipAndInvertImage(A);
		print(B);
	}
	
	public static void print(int[][] B){
		for(int i=0;i<B.length;i++){
			for(int j=0;j<B[i].length;j++)
				System.out.print(B[i][j]+" ");
			System.out.println();
		}
	}
}
