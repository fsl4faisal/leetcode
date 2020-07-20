
class MyLinkedList {
	int val;
	MyLinkedList next;
	MyLinkedList head;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new MyLinkedList(0);
	}

	public MyLinkedList(int val) {
		this.val = val;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		System.out.println("Getting at index:" + index);
		MyLinkedList temp = head.next;
		int i = 0;
		while (temp != null) {
			if (i == index)
				return temp.val;
			temp = temp.next;
			i++;
		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		System.out.println("Adding at head:" + val);
		MyLinkedList node = new MyLinkedList(val);
		node.next = head.next;
		head.next = node;
		print();
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		System.out.println("Adding at Tail:" + val);
		MyLinkedList node = new MyLinkedList(val);
		MyLinkedList temp = head.next;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		print();
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		System.out.println("Adding at index:" + index + " val:" + val);
		if (index == 0) {
			addAtHead(val);
			return;
		}
		MyLinkedList node = new MyLinkedList(val);
		MyLinkedList temp = head.next;
		int i = 0;
		while (i < index - 1 && temp != null && temp.next != null) {
			temp = temp.next;
			i++;
		}
		if (index > i + 1) {
			return;
		}
		node.next = temp.next;
		temp.next = node;
		print();
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		System.out.println("Deleteing at index:" + index);
		int i = 0;
		MyLinkedList temp = head.next;
		if (index == 0 && head.next != null) {
			head.next = head.next.next;
			print();
			return;
		}

		while (i < index - 1 && temp != null && temp.next != null) {
			temp = temp.next;
			i++;
		}

		if (temp == null || temp.next == null) {
			print();
			return;
		}
		temp.next = temp.next.next;
		print();
	}

	public void print() {
		MyLinkedList temp = head.next;
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class DesignLinkedList {

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();

		obj.addAtHead(1);
		obj.addAtTail(3);
		obj.addAtIndex(1, 2);
		System.out.println(obj.get(1));
		obj.deleteAtIndex(1);
		System.out.println(obj.get(1));

	}
}
