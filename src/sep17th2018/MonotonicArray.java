package sep17th2018;

public class MonotonicArray {

	public boolean isMonotonic(int[] A) {

		boolean increasing = true;
		boolean decresing = true;
		for (int i = 0; i < A.length - 1; i++) {
			if(A[i]>A[i+1])
				increasing=false;
		}
		for (int i = 0; i < A.length - 1; i++) {
			if(A[i]<A[i+1])
				decresing=false;
		}
		if(increasing==false && decresing==false)
			return false;
		else if(increasing)
			return increasing;
		else
			return decresing;
	}

	public static void main(String[] args) {

		//System.out.println(new MonotonicArray().isMonotonic(new int[] {1,2,4,5}));
		//System.out.println(new MonotonicArray().isMonotonic(new int[] {6,5,4,4}));
		//System.out.println(new MonotonicArray().isMonotonic(new int[] {1,3,2}));
		System.out.println(new MonotonicArray().isMonotonic(new int[] {11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
	}
}
