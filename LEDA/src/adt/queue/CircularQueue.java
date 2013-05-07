package adt.queue;

public class CircularQueue<T> implements Queue<T> {
	
	private T array[];
	private int tail;
	private int head;
	private int size;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int size){
		array = (T[]) new Object[size];
		tail=0;
		size=0;
		head=0;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		if (element ==null)
			return;
		
		array[tail] = element;
		tail = (tail+1) % array.length;
		size++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		T result = array[head];
		head = (head+1) % array.length;
		size--;
		return result;
	}

	@Override
	public T head() {
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return head==tail;
	}

	@Override
	public boolean isFull() {
		return size() == array.length;
	}
	
	public int size(){
		return size;
	}

}
