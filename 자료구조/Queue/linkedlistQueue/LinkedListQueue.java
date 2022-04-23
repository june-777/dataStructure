package linkedlistQueue;

public class LinkedListQueue<T> implements Queue<T> {

	/*Field*/
	private LLNode<T> front;
	private LLNode<T> rear;
	private int size = 0;
	
	/*Default Constructor (Empty Queue)*/
	public LinkedListQueue() {
		// TODO Auto-generated constructor stub
		front = null;
		rear = null;
	}
	/*Enqueue at the rear*/
	@Override
	public void enqueue(T newElem) {
		// TODO Auto-generated method stub
		LLNode<T> newNode = new LLNode<>(newElem, null);
		if (rear == null)  //Boundary Case: Empty인 경우 rear.getNextN는 null이므로 아래의 statement를 수행할 필요가 없다
			front = newNode;
		else
			rear.setNextN(newNode);
		rear = newNode;
		size++;
	}

	/*Dequeue at the front*/
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (rear == null) throw new IllegalStateException("Queue is Empty");
		T answer = front.getElem();
		front = front.getNextN();
		if (front == null)
			rear = null;
		size --;
		
		return answer;
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		return front.getElem();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (rear==null);
	}

}
