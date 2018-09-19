package sep2nd2018;

import java.util.HashSet;

public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		
		int counter=0;
		HashSet<Integer> max=new HashSet<Integer>();
		for(int i:nums) {
			if(i==1)
				counter++;
			else if(i==0) {
				max.add(counter);
				counter=0;
			}
		}
		max.add(counter);
		int maxx=0;
		for(Integer i:max) {
			if(i>maxx)
				maxx=i;
		}
		//System.out.println(max);
		return maxx;
	}

	public static void main(String[] args) {
		int[] a={ 1,1,0,1,1,1};
		
		
		System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(a));
	}

}
