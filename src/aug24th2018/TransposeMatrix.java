package aug24th2018;

public class TransposeMatrix {
	
	public int[][] transpose(int[][] A) {
		int[][] B=new int[A[0].length][A.length];
		
		
		for(int i=0;i<B.length;i++){
			for(int j=0;j<B[i].length;j++){
				B[i][j]=A[j][i];
			}
		}
		
		
		return B;
	}

	public static void print(int[][] B){
		for(int i=0;i<B.length;i++){
			for(int j=0;j<B[i].length;j++)
				System.out.print(B[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] A={{1,2,3},{4,5,6}};
		TransposeMatrix t=new TransposeMatrix();
		int[][] B=t.transpose(A);
		int[][] C={{1,2,3},{4,5,6},{7,8,9}};
		print(B);
		B=t.transpose(C);
		print(B);
		
		int[][] D={{1,2,3}};
		B=t.transpose(D);
		print(B);
		
	}
}
