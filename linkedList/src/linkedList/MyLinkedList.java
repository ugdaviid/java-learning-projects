package linkedList;

import java.util.Iterator;

import javax.management.RuntimeErrorException;

public class MyLinkedList{
	
	private Node head;
	
	public MyLinkedList() {
		this.head = null;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void printList() {
		
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public int sizeOfList() {
		
		int count = 0;
		Node current = head;
		
		while(current != null) {
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	public boolean isContains(int value) {

		Node current = head;
		
		while(current != null) {
			if(current.data == value) {
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clearList() {
		head = null;
	}
	
	public void removeFromList(int value) {
		
		if(head == null) return;
		
		if(head.data == value) {
			head = head.next;
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			if(current.next.data == value) {
				current.next = current.next.next;
				return;
			}
			
			current = current.next;
		}
	}
	
	public void reverseList() {
		
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void insertAt(int index, int value) {
		if(index < 0) return;
		
		Node newNode = new Node(value);
		
		if(index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		
		int count = 0;
		Node current = head;
		
		while(current != null && count < index - 1) {
			current = current.next;
			count++;
		}
		
		if(current == null) return;
		
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public int getLast() {
		if(head == null) throw new RuntimeException();
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		return current.data;
	}
	
	public int getIndex(int index) {
		if(index < 0) throw new IndexOutOfBoundsException();
		
		Node current = head;
		int count = 0;
		
		while(current != null) {
			if(count == index) {
				return current.data;
			}
			count++;
			current = current.next;
		}
		
		throw new IndexOutOfBoundsException();
		
	}
	
	public int findMiddle() {
		if(head == null) throw new RuntimeException("Empty list");
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
	
	public int nthFromEnd(int n) {

		Node fast = head;
		Node slow = head;
		
		for(int i = 0; i < n; i++) {
			if(fast == null) throw new RuntimeException();
			fast = fast.next;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
	
	public boolean hasCycle() {
		
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
}