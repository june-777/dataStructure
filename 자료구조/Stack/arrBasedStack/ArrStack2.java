package arrBasedStack;

import java.util.EmptyStackException;

/** Array-Based Stack
 * "TOP" "논리적인" 위치로 지정 (More efficient than "Physical Top"*/
public class ArrStack2<E> implements Stack<E> {
	
	/*Field*/
	private static final int CAPACITY = 5;
	private int size = 0;
	private int top = -1;
	private E[] data;
	/*Constructor*/
	public ArrStack2() {
		this(CAPACITY);
	}
	public ArrStack2(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top==-1);
	}
	public boolean isFull() {
		return (size==data.length);
	}
	@Override
	public E top() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Base Case: Empty Stack*/
		if (isEmpty()) throw new EmptyStackException();
		return data[top];
	}
	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Base Case: Empty Stack*/
		if (isEmpty()) throw new EmptyStackException();
		E answer = data[top];
		data[top] = null;
		top -= 1;
		size --;
		return answer;
	}
	@Override
	public void push(E newElem) throws IllegalStateException {
		// TODO Auto-generated method stub
		/*Base Case: Full Stack*/
		if (isFull()) throw new IllegalAccessError("Stack is Full");
		top += 1;
		data[top] = newElem;
		size++;
	}
	
	public void printAll() {
		for (E s: data) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		ArrStack2<String> stack = new ArrStack2<>();
		stack.push("123");
		stack.push("456");
		stack.push("7");
		stack.push("89");
		stack.push("10");
//		stack.push("11");
		
		System.out.println("Top: " + stack.top());
		stack.printAll();
		System.out.println("--------------------");
		System.out.println("Pop: " + stack.pop());
		System.out.println("Top: " + stack.top());
		stack.printAll();
		System.out.println("--------------------");
		System.out.println("Pop: " + stack.pop());
		System.out.println("Top: " + stack.top());
		stack.printAll();
	
	}
	
	
	
}
