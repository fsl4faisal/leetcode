import java.util.LinkedList;

class DoubleLinkedList {
	int key;
	int value;
	DoubleLinkedList prev;
	DoubleLinkedList next;
	DoubleLinkedList head;
	DoubleLinkedList tail;

	public DoubleLinkedList() {

	}

	public DoubleLinkedList(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public void addFirst(DoubleLinkedList node) {
		if (head == null) {
			head = new DoubleLinkedList();
			head.next = node;
			node.prev = head;
		} else {
			node.prev = head;
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
		}

		if (tail == null) {
			tail = new DoubleLinkedList();
			tail.prev = node;
			node.next = tail;
		}

		print();
	}

	public int removeLast() {
		System.out.println("Removing Last");
		int key = tail.prev.key;
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		print();
		return key;
	}

	public void remove(DoubleLinkedList node) {
		System.out.println("Remove node" + node);
		if (node.prev == head) {
			head.next = node.next;
			node.next.prev = head;
		}

		else if (node.next == tail) {
			removeLast();
		}

		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;

		}

		print();
	}

	public void print() {
		DoubleLinkedList temp = head;
		while (temp != null) {
			System.out.print("(" + temp.key + " " + temp.value + ")->");
			temp = temp.next;
		}
		System.out.println();
	}

	public String toString() {
		return "[" + key + ", " + value + "]";
	}

}

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		DoubleLinkedList node1 = new DoubleLinkedList(1, 12);
		DoubleLinkedList node2 = new DoubleLinkedList(2, 4);
		DoubleLinkedList node3 = new DoubleLinkedList(3, 14);
		DoubleLinkedList node4 = new DoubleLinkedList(4, 24);
		list.addFirst(node1);
		list.addFirst(node2);
		list.addFirst(node3);
		list.addFirst(node4);
		// list.removeLast();
		list.remove(node2);
		list.print();
		// list.remove(node4);

		LinkedList list2 = new LinkedList<>();
	}

}
