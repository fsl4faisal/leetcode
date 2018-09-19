package sep18th2018;

public class BestTimetoBuyanSellStock121 {

	public int maxProfit(int[] prices) {
		
		//int[][] arr=new int[prices.length][prices.length];
		
		int max=0;
		for(int i=0;i<prices.length;i++) {
			//arr[i][0]=prices[i];
			for(int j=i+1;j<prices.length;j++) {
				//System.out.print(arr[i][j]+" ");
				int diff=prices[j]-prices[i];
				if(max<diff)
					max=diff;
			}
			//System.out.println();
		}
		
		//print(arr);
		
		return max;
	}
	public void print(int[][] arr) {
		System.out.println("Print:");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		System.out.println(new BestTimetoBuyanSellStock121().maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
