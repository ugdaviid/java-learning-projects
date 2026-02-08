package linkedList;

public class Main{
	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();

		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(30);
		
		list.printList();
		System.out.println("Size: " + list.sizeOfList());
		System.out.println("isContains?: " + list.isContains(30));
		System.out.println("isEmpty?: " + list.isEmpty());
		
		list.clearList();
		list.printList();

		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(30);

		list.removeFromList(30);
		list.printList();
		
		list.reverseList();
		list.printList();
		
		list.insertAt(2, 555);
		list.printList();

		System.out.println("Last: " + list.getLast());
		System.out.println("getIndex: " + list.getIndex(1));
		System.out.println("Middle: " + list.findMiddle());
		System.out.println("nthFromback (3):" + list.nthFromEnd(3));
		
		
	}
}