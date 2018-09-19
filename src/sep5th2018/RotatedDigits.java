package sep5th2018;

public class RotatedDigits {

	public int rotatedDigits(int N) {
		int counter=0;
		for(int i=1;i<=N;i++) {
			if(isValid(i))
				counter++;
		}
		return counter;
	}
	private boolean isValid(int i) {
		boolean valid=false;
		while(i>0) {
			if(i%10==2||i%10==5||i%10==6||i%10==9)
				valid=true;
			if(i%10==3||i%10==7||i%10==4)
				return false;
			i=i/10;
		}
		return valid;
	}

	public static void main(String[] args) {

		System.out.println(new RotatedDigits().rotatedDigits(10));
		System.out.println(new RotatedDigits().rotatedDigits(857));//247
	}
}
