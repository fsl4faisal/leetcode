package dec2020;

class MinPartitions {
	public int minPartitions(String n) {
		int max = 0;
		for (int i = 0; i < n.length(); i++) {
			int number = n.charAt(i) - '0';
			max = Math.max(max, number);
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(new MinPartitions().minPartitions("32"));
		System.out.println(new MinPartitions().minPartitions("82734"));
		System.out.println(new MinPartitions().minPartitions("27346209830709182346"));
	}
}