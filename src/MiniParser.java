import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface INestedInteger {

	public boolean isInteger();

	public Integer getInteger();

	public void setInteger(int value);

	public void add(NestedInteger ni);

	public List<NestedInteger> getList();
}

class NestedInteger implements INestedInteger {

	Integer value;
	List<NestedInteger> list = new ArrayList<>();

	public NestedInteger() {

	}

	public NestedInteger(int value) {
		this.value = value;
	}

	@Override
	public boolean isInteger() {
		if (list.isEmpty())
			return true;
		return false;
	}

	@Override
	public Integer getInteger() {
		if (list.isEmpty())
			return value;
		return null;
	}

	@Override
	public void setInteger(int value) {
		this.value = value;

	}

	@Override
	public void add(NestedInteger ni) {
		list.add(ni);
	}

	@Override
	public List<NestedInteger> getList() {
		if (value != null)
			return null;
		return list;
	}

	@Override
	public String toString() {
		return " (" + value + ", list=" + list + ")";
	}

}

class MiniParser {

	/**
	 * Tricky to understand..!
	 * 
	 * @param s
	 * @return
	 */
	public NestedInteger deserializev1(String s) {
		if (s.isEmpty())
			return null;
		if (s.charAt(0) != '[')
			return new NestedInteger(Integer.valueOf(s));

		Stack<NestedInteger> stack = new Stack<>();
		int l = 0;
		NestedInteger curr = null;

		for (int r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);

			if (ch == '[') {
				if (curr != null) {
					stack.push(curr);
				}
				curr = new NestedInteger();
				l = r + 1;
			} else if (ch == ',') {
				if (s.charAt(r - 1) != ']') {
					String num = s.substring(l, r);
					curr.add(new NestedInteger(Integer.valueOf(num)));
				}
				l = r + 1;
			} else if (ch == ']') {
				String num = s.substring(l, r);
				if (!num.isEmpty())
					curr.add(new NestedInteger(Integer.valueOf(num)));
				if (!stack.isEmpty()) {
					NestedInteger pop = stack.pop();
					pop.add(curr);
					curr = pop;
				}

				l = r + 1;

			}
		}
		return curr;

	}

	public NestedInteger deserialize(String s) {
		NestedInteger ret = new NestedInteger();
		if (s == null || s.length() == 0)
			return ret;
		if (s.charAt(0) != '[')
			ret.setInteger(Integer.parseInt(s));

		else if (s.length() > 2) {
			int start = 1, count = 0;
			for (int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				if (count == 0 && (c == ',' || i == s.length() - 1)) {
					ret.add(deserialize(s.substring(start, i)));
					start = i + 1;
				} else if (c == '[')
					count++;
				else if (c == ']')
					count--;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		String s = "[123,[456,[789,1233]]]";
		NestedInteger ans = new MiniParser().deserialize(s);

		System.out.println(ans);
	}
}