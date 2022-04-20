package arrBasedStack;

import java.util.EmptyStackException;
//import java.util.EmptyStackException;
import java.lang.String;


/** Array-Based Stack
 * "TOP" "논리적인" 위치로 지정 (More efficient than "Physical Top"*/
public class ArrStack2<E> implements Stack<E> {

	private static final int CAPACITY = 10;
	private E[] data;
	private int top = -1; //top: 가장마지막에 Push된 Elem을 가리키도록 정의. 최초는 Empty이므로 top = -1;
	
	public ArrStack2() {
		this(CAPACITY);
	}
	public ArrStack2(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	@Override
	public void push(E newElem) throws StackFullException{
		// TODO Auto-generated method stub
		if (isFull()) throw new StackFullException("Stack is Full");
		data[++top] = newElem;
		
	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		return (top == data.length-1);
	}
	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyStackException();
		E answer = data[top--];
		data[top+1] = null;
		return answer;
	}

	@Override
	public E top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (top == -1) throw new EmptyStackException();
		E answer = data[top];
		return answer;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == -1);
	}
	
	@Override
	public int size() {
		return (top+1);
	}

	
}
