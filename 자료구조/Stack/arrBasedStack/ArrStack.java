package arrBasedStack;

import java.util.EmptyStackException;

/** Array-based Stack
 *  "TOP" "물리적인" 위치로 지정  **/
public class ArrStack<T> implements Stack<T> {
	
	/*Field*/
	private int top;
	private int size = 0;
	private T[] data;
	private static final int CAPACITY = 5;
	/*Constructor*/
	public ArrStack() {
		this(CAPACITY);
	}
	public ArrStack(int capacity) {
		data = (T[]) new Object[5];
	}
	/*Overriding*/
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}
	public boolean isFull() {
		return (size==data.length);
	}
	@Override
	public T top() throws EmptyStackException {
		// TODO Auto-generated method stub
		return data[top];
	}
	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Base Case: Empty List*/
		if (isEmpty()) throw new EmptyStackException();
		T answer = data[top];
		/*Left Slash all Element*/
		for (int i=0; i<size-1; i++) {
			data[i] = data[i+1];
		}
		size++;			
		return answer;
	}
		


	@Override
	public void push(T newElem) throws IllegalStateException {
		// TODO Auto-generated method stub
		/*Base Case1: Full Stack*/
		if (isFull()) throw new IllegalStateException("Stack is Full");
		/*Base Case2: Empty List*/
		else if (isEmpty()) { data[top] = newElem; size++; }
		else {
			/*Right Slash all Element*/
			for (int i=size-1; i>=0; i--) {
				data[i+1] = data[i];
			}
			data[top] = newElem;
			size ++;
		}
	}
	
	public void printAll() {
		for (T s: data) {
			System.out.println(s);
		}
	}
	
	public static void main (String[] args) {
		ArrStack<Integer> stack = new ArrStack<>();
		stack.push(123);
		stack.push(456);
		stack.push(78);
		stack.push(9);
		stack.push(10);
		stack.printAll();
		
		System.out.println("Pop: "+ stack.pop() + "\nStack: ");
		stack.printAll();
	}

	
	
	
	
	
	
}
//	public static final int CAPACITY = 5;
//	private E[] data;
//	private int top = 0;
//	private int size = 0;
//	
//	public ArrStack() {
//		// TODO Auto-generated constructor stub
//		this(CAPACITY);
//	}
//	public ArrStack(int capacity) {
//		data = (E[]) new Object[capacity];
//	}
//	
//	
//	@Override
//	public int size() {
//		// TODO Auto-generated method stub
//		return size;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return (size == 0);
//	}
//
//	@Override
//	public E top() throws EmptyStackException {
//		// TODO Auto-generated method stub
//		System.out.println();
//		return null;
//	}
//
//	@Override
//	public void push(E newElem) {
//		// TODO Auto-generated method stub
//		// Full List
//		if (size == data.length) return;
//		// Empty List
//		else if (data[top] == null) {
//			data[top] = newElem;
////			System.out.println("test");
//		}
//		else {
//			for (int i=data.length-1; i>top; i--) {
//				data[i] = data[i-1];
////				System.out.println(i);
//			}
//			data[top] = newElem;
//		}
//		size++;
////		System.out.println(size);
//	}
//
//	@Override
//	public E pop() throws EmptyStackException {
//		// TODO Auto-generated method stub
//		if (size == 0) return null;
//		E answer = data[top];
//		for (int i=0; i<data.length-1; i++) {
//			data[i] = data[i+1];
////			System.out.println("test");
//		}
//		data[data.length-1] = null;
//		
//		size --;
//		return answer;
//	}
//	
//	public void printAll() {
//		for (E s: data) {
//			System.out.println(s);
//		}
//	}
//	
//	
//	public static void main(String[] args) {
//		ArrStack<String> arrstack = new ArrStack<>();
//
//	
//		arrstack.push("5");
//		arrstack.push("3");
//		arrstack.push("1");
//		arrstack.push("0");
//		arrstack.push("2");
//		System.out.println("Print All : ");
//		arrstack.printAll();
////		arrstack.push("22");
//		
//		System.out.println("Pop: " + arrstack.pop());
//		arrstack.printAll();
//	}
//
//}
