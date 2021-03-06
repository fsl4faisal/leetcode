package aug24th2018;

/*
 * 
 * Initially, there is a Robot at position (0, 0). 
 * Given a sequence of its moves, 
 * judge if this robot makes a circle, 
 * which means it moves back to the original place.
 * The move sequence is represented by a string. 
 * And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
 * The output should be true or false representing whether the robot makes a circle.
 * Example 1:
 * Input: "UD"
 * Output: true
 * 
 * Example 2:
 * Input: "LL"
 * Output: false
 * 
 * 
 * 
 * 
 */
public class JudgeCircle {

	public boolean judgeCircle(String moves) {

		int counterX = 0;
		int counterY = 0;
		for (int i = 0; i < moves.length(); i++) {
			char ch = moves.charAt(i);
			if (ch == 'U')
				counterY++;
			else if (ch == 'D')
				counterY--;
			else if (ch == 'L')
				counterX++;
			else if (ch == 'R')
				counterX--;
		}
		if (counterY == 0 && counterX == 0)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		JudgeCircle j=new JudgeCircle();
		System.out.println(j.judgeCircle("UD"));
		System.out.println(j.judgeCircle("LL"));
		
	}
}
