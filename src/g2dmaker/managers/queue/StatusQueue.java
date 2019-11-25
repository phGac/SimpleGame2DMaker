package g2dmaker.managers.queue;

public class StatusQueue {
	
	private final class Node {
		public String name;
		public Node next;
		
		public Node(final String name) {
			this.name = name;
			this.next = null;
		}
	}
	
	private Node head;
	private Node last;

	private int length;
	private final int maxLenght;
	
	public StatusQueue(final int maxLength) {
		this.maxLenght = maxLength;
	}
	
	public boolean enqueue(String name) {
		Node newNode = new Node(name);
		if(head == null) {
			head = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		length++;
		return true;
	}
	
	public String dequeue() {
		if(head == null)
			return null;
		
		Node aux = head;
		head = aux.next;
		if(head == null) {
			last = null;
		}
		length--;
		return aux.name;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public boolean isFull() {
		return (length >= maxLenght);
	}
	
	public boolean find(String toFind) {
		if(head == null)
			return false;
		else if(head.name.equals(toFind)) {
			return true;
		} else {
			boolean founded = false;
			Node aux = head.next;
			while(aux != null) {
				if(aux.name.equals(toFind)) {
					founded = true;
					break;
				}
				aux = aux.next;
			}
			return founded;
		}
	}
}
