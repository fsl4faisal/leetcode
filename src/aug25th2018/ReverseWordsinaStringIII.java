package aug25th2018;

/*
 * Given a string, you need to reverse the order of characters 
 * in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be 
any extra space in the string.
 * 
 * 
 */
public class ReverseWordsinaStringIII {

	public String reverseWords(String s) {
		
		String[] strArr=s.split(" ");
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<strArr.length;i++){
			for(int j=strArr[i].length()-1;j>=0;j--){
				sb.append(strArr[i].charAt(j));
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}
	

	public static void main(String[] args) {
		String str="Let's take LeetCode contest";
		ReverseWordsinaStringIII obj=new ReverseWordsinaStringIII();
		System.out.println(obj.reverseWords(str));
	}
}
