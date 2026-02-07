package linkedList;

public class Main{
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.addList(10);
		list.addList(15);
		list.addList(20);
		list.addList(25);
		list.addList(30);
		
		list.printList();
		System.out.println("Size: " + list.listSize());
		System.out.println("Contains? (15): "+  list.isContains(15));

		list.remove(15);
		list.printList();
		
		list.reverse();
		list.printList();
		
		list.insertAt(2, 50);
		list.printList();
		
		System.out.println(list.isEmpty());
		System.out.println(list.getLast());
		System.out.println(list.getIndex(2));
		
		list.clear();
		list.printList();
	}
}