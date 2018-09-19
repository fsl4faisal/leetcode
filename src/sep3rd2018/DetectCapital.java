package sep3rd2018;

public class DetectCapital {

	public boolean detectCapitalUse(String word) {
		
		int counter=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)>='A' && word.charAt(i)<='Z') {
				counter++;
			}
		}
		if(counter==word.length()||counter==0)
			return true;
		else if(counter==1 && word.charAt(0)>='A'&& word.charAt(0)<='Z')
			return true;
		return false;
	}

	public static void main(String[] args) {

		System.out.println(new DetectCapital().detectCapitalUse("faisal"));
		System.out.println(new DetectCapital().detectCapitalUse("USA"));
		System.out.println(new DetectCapital().detectCapitalUse("Faisal"));
		System.out.println(new DetectCapital().detectCapitalUse("FaisaL"));
	}
}
