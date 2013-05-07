package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	
	public RecursiveSingleLinkedListImpl(){
		
	}
	
	@Override
	public boolean isEmpty() {
		return (data==null)? true : false;
	}

	@Override
	public int size() {
		return (next==null) ? 0 : 1 + next.size();
	}

	@Override
	public T search(T element) {
		if (isEmpty()) return null;
		else {
			if (data.equals(element)) return data;
			else return next.search(element);
		}
		
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			data = element;
			next = new RecursiveSingleLinkedListImpl<>();
		}
		else{
			next.insert(element);
		}
			
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()){
			if (data==element){
				data = next.data;
				next = next.next;
			}
			//remove last
			else next.remove(element);
		}
	}
	
	@Override
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[size()];
		int index = 0;
		toArray(index, result, this);
		
		return result;
	}
	
	private void toArray(int index, T[] array, RecursiveSingleLinkedListImpl<T> node){
		
		if (!node.isEmpty()){
			array[index++] = node.data;
			toArray(index, array, node.next);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		if(!isEmpty()){
			toString(builder, this);
		}
		builder.append("]");
		return builder.toString();
	}
	
	private void toString(StringBuilder builder, RecursiveSingleLinkedListImpl<T> node){
		if(!node.isEmpty()){
			builder.append(node.getData().toString());
			if (!node.next.isEmpty()){
				builder.append(", ");
			}
			toString(builder, node.next);
		}
	}

	@Override
	public T getFirst() {
		if (!isEmpty()){
			return data;
		}
		else{
			return null;
		}

	}

}
