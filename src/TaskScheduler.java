import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TaskScheduler {

	static class Tuple {
		char ch;
		int frequency;

		public Tuple(char ch, int frequency) {
			this.ch = ch;
			this.frequency = frequency;
		}

		@Override
		public String toString() {
			return "[" + ch + ", " + frequency + "]";
		}

	}

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : tasks) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(new Comparator<Tuple>() {

			@Override
			public int compare(Tuple tuple1, Tuple tuple2) {
				return tuple2.frequency - tuple1.frequency;
			}

		});

		for (Entry<Character, Integer> entry : map.entrySet()) {
			queue.add(new Tuple(entry.getKey(), entry.getValue()));
		}

		/**
		 * Here I have to implement cool down time as well..!!
		 * 
		 * if I have a variable ..! then I would need variable for every number ..!
		 * 
		 * how about int[] arr=new int[26];
		 * 
		 */

		int[] arr = new int[26];

		int cpuTime = 0;
		while (!queue.isEmpty()) {
			Tuple tuple = null;
			
			if (queue.peek() != null) {
				if (arr[queue.peek().ch - 65] == 0) {
					tuple = queue.remove();
					arr[tuple.ch - 65] = n;
					if (tuple.frequency > 1)
						queue.add(new Tuple(tuple.ch, tuple.frequency - 1));
				}
			}
			for (int i = 0; i < arr.length; i++) {
				
				if(arr[i]>0) {
					if(tuple!=null && (tuple.ch-65) !=i){
						arr[i]--;
					}else if(tuple==null) {
						arr[i]--;
					}
				}
			}
			
			//print(arr);
			cpuTime++;

			System.out.println(tuple);
			
		}

		return cpuTime;

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print((char) (i + 65) + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		char[] tasks = { 'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;

		int minCPUIntervals = new TaskScheduler().leastInterval(tasks, n);
		System.out.println(minCPUIntervals);
	}
}
