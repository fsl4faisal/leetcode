package aug29th2018;

public class LongestUncommonSubsequenceI {

	public int findLUSlength(String a, String b) {

		if(a.equals(b))
			return -1;
		else
			return a.length()>b.length()?a.length():b.length();
					
		
	}

	public static void main(String[] args) {
		String a="faisal";
		String b="aisa";
		
		System.out.println(new LongestUncommonSubsequenceI().findLUSlength(a, b));
	}

}
