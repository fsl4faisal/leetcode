package aug25th2018;

import java.util.Stack;

public class BaseballGame {

	public int calPoints(String[] ops) {

		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (int i = 0; i < ops.length; i++) {
			char ch = ops[i].charAt(0);
			// Its a positive integer
			if (ch >= '1' && ch <= '9') {
				int point=Integer.parseInt(ops[i]);
				stack.push(point);
				sum += point;
			} else if (ch == 'C') {
				int lastPoint = stack.pop();
				sum -= lastPoint;
			} else if (ch == 'D') {
				int lastPoint = stack.peek();
				sum += (lastPoint * 2);
				stack.push(lastPoint * 2);
			} else if (ch == '+') {
				int lastPoint1 = stack.pop();
				int lastPoint2 = stack.pop();
				sum += (lastPoint1 + lastPoint2);
				stack.push(lastPoint2);
				stack.push(lastPoint1);
				stack.push(lastPoint1 + lastPoint2);
			} else if (ch == '-') {
				// int point = (int) ops[i].charAt(1) - 48;
				int point = Integer.parseInt(ops[i]);
				sum += point;
				stack.push(point);
			}

		}

		return sum;
	}

	public static void main(String[] args) {
		String[] ops = { "-21", "-66", "39", "+", "+" };

		BaseballGame bg = new BaseballGame();
		System.out.println(bg.calPoints(ops));

	}

}
