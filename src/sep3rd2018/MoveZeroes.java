package sep3rd2018;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		
		int[] newNums=new int[nums.length];
		int k=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0)
				newNums[k++]=nums[i];
		}
		k=0;
		for(int i:newNums)
			nums[k++]=i;
	}
	
	public static void print(int[] nums) {
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a= {0,1,0,3,12};
		print(a);
		new MoveZeroes().moveZeroes(a);
		print(a);
		
	}

}
