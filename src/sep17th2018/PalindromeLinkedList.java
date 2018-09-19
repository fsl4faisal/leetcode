package sep17th2018;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {

		int length = getLength(head);
		Stack<Integer> stack = new Stack<>();
		boolean even = length % 2 == 0 ? true : false;
		ListNode temp = head;

		int i = 0;
		while (i < length / 2) {
			stack.push(temp.val);
			temp = temp.next;
			i++;
		}
		if (even == false) {
			temp = temp.next;
		}
		while (!stack.isEmpty()) {

			if (stack.pop() != temp.val) {
				return false;
			}
			temp = temp.next;

		}
		return true;
	}

	public int getLength(ListNode head) {
		int length = 0;
		ListNode temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node.next = node2;
		node2.next=node3;
		node3.next=node4;
		System.out.println(new PalindromeLinkedList().isPalindrome(node));

	}
}
