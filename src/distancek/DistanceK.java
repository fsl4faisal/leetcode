package distancek;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class DistanceK {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> res = new LinkedList<>();

		if (k == 0) {
			res.add(target.val);
		} else {
			dfs(res, root, target.val, k, 0);
		}

		return res;
	}

	private int dfs(List<Integer> res, TreeNode node, int target, int k, int depth) {
		if (node == null)
			return 0;

		if (depth == k) {
			res.add(node.val);
			return 0;
		}

		int left, right;

		if (node.val == target || depth > 0) {
			left = dfs(res, node.left, target, k, depth + 1);
			right = dfs(res, node.right, target, k, depth + 1);
		} else {
			left = dfs(res, node.left, target, k, depth);
			right = dfs(res, node.right, target, k, depth);
		}

		if (node.val == target)
			return 1;

		if (left == k || right == k) {
			res.add(node.val);
			return 0;
		}

		if (left > 0) {
			dfs(res, node.right, target, k, left + 1);
			return left + 1;
		}
		if (right > 0) {
			dfs(res, node.left, target, k, right + 1);
			return right + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left1 = new TreeNode(5);
		TreeNode right1 = new TreeNode(1);
		root.left = left1;
		root.right = right1;

		TreeNode leftLeft1 = new TreeNode(6);
		TreeNode leftRight1 = new TreeNode(2);
		left1.left = leftLeft1;
		left1.right = leftRight1;

		TreeNode right1left = new TreeNode(0);
		TreeNode right1Right = new TreeNode(8);
		right1.left = right1left;
		right1.right = right1Right;

		TreeNode leftRight1Left = new TreeNode(7);
		TreeNode leftRight1Right = new TreeNode(4);

		leftRight1.left = leftRight1Left;
		leftRight1.right = leftRight1Right;

		List<Integer> res = new DistanceK().distanceK(root, left1, 2);
		System.out.println(res);
	}
}
