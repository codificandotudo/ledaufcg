package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	
	public void insert(T element){
		if (isEmpty()){
			data = element;
			next = new RecursiveDoubleLinkedListImpl<T>();
			previous = new RecursiveDoubleLinkedListImpl<T>();
		}
		else{
			next.insert(element);
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if (isEmpty()){
			insert(element);
		}
		else{
			RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<T>();
            auxNode.data = data;
            auxNode.next = next;
            ((RecursiveDoubleLinkedListImpl<T>) next).previous = auxNode;
            auxNode.previous = this;
           
            data = element;
            next = auxNode;
            previous = new RecursiveDoubleLinkedListImpl<T>();
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()){
			this.data = next.data;
			this.next = next.next;
		}
	}

	@Override
	public void removeLast() {
		if (next.isEmpty()){
			remove(this.data);
		}
		else{
			((DoubleLinkedList<T>)next).removeLast();
		}
	}

	public T getFirst(){
		if (!isEmpty()){
			return data;
		}
		else{
			return null;
		}
	}
	

	
}
