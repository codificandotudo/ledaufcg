package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> 
										implements DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;
	DoubleLinkedListNode<T> head;
	
	
	public DoubleLinkedListImpl(){
		head = new DoubleLinkedListNode<T>();
		last = head;
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element,
										new DoubleLinkedListNode<T>(),
										new DoubleLinkedListNode<T>());
		
		newHead.next = head;
		head.previous = newHead;
		
		if (head.isNIL()){
			last = newHead;
		}
		
	}
	
	public void insert(T element){
		insertFirst(element);
	}

	@Override
	public void removeFirst() {
		
	}

	@Override
	public void removeLast() {

	}

}
