
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class ConstructBinaryTreeFromPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = helper(preorder, inorder, 0, inorder.length - 1, 0);
		return root;
	}

	public TreeNode helper(int[] preorder, int[] inorder, int inorderStartIndex, int inorderEndIndex,
			int preorderStartIndex) {
		if (inorderStartIndex > inorderEndIndex || preorderStartIndex > preorder.length) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preorderStartIndex]);
		int i = inorderStartIndex;
		for (; inorder[i] != preorder[preorderStartIndex] && i < inorderEndIndex; i++) {
		}
		node.left = helper(preorder, inorder, inorderStartIndex, i - 1, ++preorderStartIndex);
		node.right = helper(preorder, inorder, i + 1, inorderEndIndex, ++preorderStartIndex);
		return node;
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		
		ConstructBinaryTreeFromPreorderAndInorder obj=new ConstructBinaryTreeFromPreorderAndInorder();
		TreeNode node=obj.buildTree(preorder, inorder);
		System.out.println(obj);
		
	}
}
