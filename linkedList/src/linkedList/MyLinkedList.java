package linkedList;

import java.lang.reflect.UndeclaredThrowableException;

public class MyLinkedList{
	
	private Node head;
	
	public MyLinkedList() {
		this.head = null;
	}
	
	public void addList(int value) {
		
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
	
	public int listSize() {
		Node current = head;
		int count = 0;
		
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
	
	public void remove(int value) {
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
	
	public void reverse() {
		
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
			newNode = head;
			head = newNode.next;
			return;
		}
		
		int count = 0;
		Node current = head;
		
		while(current != null && count < index -1) {
			current = current.next;
			count++;
		}
		
		if(current == null) return;
		
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public void clear() {
		head = null;
	}
	
	public int getIndex(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node current = head;
		int count = 0;
		
		while(current != null) {
			if(count == index) {
				return current.data;
			}
			
			current = current.next;
			count++;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getLast() {
		if(head == null) {
			throw new RuntimeException("Empty list");
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		return current.data;
	}
	
}