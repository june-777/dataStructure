package arrayQueue;

import java.util.EmptyStackException;

/** Array-based Queue
 *  #--------------#	
 *  |  |5 |9 |7 |  |	
 *  #--------------#
 *  front: 1 (큐에 들어있는 첫번째 Elem의 Index)
 *  rear : 4 (큐에 들어있는 마지막 Elem의 그 다음 Index; 다음 enqueue할 Elem의 Index)
 *  
 * 	Empty Condition: front == rear
 * 	Full Condition: (rear+1) % N == front
 * 	큐에 비어있는 칸이 하나일 때를 Full로 정의한다(그림참고).
 *  #--------------#	
 *  |  |5 |9 |7 |9 |	
 *  #--------------#
 * 
 * */

public class ArrayQueue<T> implements Queue<T>{

	private static final int CAPACITY=5;
	private int front;
	private int rear;
	private T[] data;
	
	
	public ArrayQueue() { // ArrayQueue 객체를 생성할 때 최초상태. 즉, Empty Queue. (어떻게 초기화해야 Empty Queue를 나타내는 것인지 고민해봐야 함)
		// TODO Auto-generated constructor stub
		this(CAPACITY);
	}
	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
		front = rear;
	}
	
	/*Edge Case는 없는가?
	 * Edge Case: Empty일 때, dequeue하는 경우 *그럼 Empty는 어떻게 나타내는가?
	 * r==f -> Empty */
	@Override
	public T dequeue() throws EmptyQueueException{
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyQueueException("Queue is Empty");
		
		T answer = data[front];
		front = (front + 1) % data.length; //(Circular Fashion이기 때문에 인덱스가 배열의 마지막을 넘어가면 다시 0으로 돌아가야한다. 단순히 front ++; 하면 안된다)
		
		return answer;
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		return data[front];
	}

	/*Edge Case는 없는가?
	 * Full일 때, enqueue하려고 하면? * 그럼 Full은 어떻게 나타낼 수 있는가? 
	 * 지금 구현하는 ArrayQueue는 elem이 배열의 크기만큼 꽉찬게 아닌, 하나 적은 상태를 Full이라고 정의할 것이다. (Full과 Empty를 구분하기 위함)
	 * 따라서, Full의 조건은 (rear+1) % data.length == front 가 성립한다.
	 * */
	@Override
	public void enqueue(T newElem) throws FullQueueException {
		// TODO Auto-generated method stub
		if ((rear+1) % data.length == front) throw new FullQueueException("Queue is Full");
		
		data[rear] = newElem;
		rear = (rear+1) % data.length;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (data.length + rear - front) % data.length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (rear==front);
	}

}
