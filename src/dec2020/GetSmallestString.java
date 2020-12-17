package dec2020;

class GetSmallestString {
	public String getSmallestString(int n, int k) {

		StringBuffer sb=new StringBuffer("");
		while(k-n+1>26 && n>1) {
			sb.append('z');
			k-=26;
			n--;
		}
		sb.append((char)(k-n+1+96));
		while(n>1) {
			sb.append('a');
			n--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
//		System.out.println(new GetSmallestString().getSmallestString(5, 73));
//		System.out.println(new GetSmallestString().getSmallestString(3, 27));
		System.out.println(new GetSmallestString().getSmallestString(5, 31));
	}
}