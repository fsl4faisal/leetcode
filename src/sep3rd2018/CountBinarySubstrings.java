package sep3rd2018;

public class CountBinarySubstrings {

	public int countBinarySubstrings(String s) {

		int res=0,currentRun=1,prevRun=0;
		
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1)) {
				currentRun++;
			}else {
				prevRun=currentRun;
				currentRun=1;
			}
			if(prevRun>=currentRun)
				res++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		String str="00110011";
		
		System.out.println(new CountBinarySubstrings().countBinarySubstrings(str));
		System.out.println(new CountBinarySubstrings().countBinarySubstrings("10101"));
		
	}
}
