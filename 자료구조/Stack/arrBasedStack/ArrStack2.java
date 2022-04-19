package arrBasedStack;

import java.util.EmptyStackException;
//import java.util.EmptyStackException;
import java.lang.String;


/** Array-Based Stack
 * "TOP" "논리적인" 위치로 지정 (More efficient than "Physical Top"*/
public class ArrStack2<E> implements Stack<E> {

	/*Field
	 * Top: 가장 마지막으로 PUSH된 elem을 가리키도록 정의*/
	private int top = -1;
	private int size;
	private static final int CAPACITY = 5;
	private E[] data;
	/*Generic 타입E Element를 담을 배열의 타입을 무엇으로 해야하는가?
	 * 타입E 배열*/ 
	
	/*Default Constructor
	 * Empty Stack: top = -1*/
	public ArrStack2() {
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked") // 컴파일러 노란색 주의문구 조용히 시키기
	public ArrStack2(final int CAPACITY) {
		data = (E[]) new Object[CAPACITY]; //Empty Stack
		/* *** String[] sarr = new String[10]; 처럼 배열 선언시, String 통일시키는데 왜 T[] arr = new T[10]; 는 에러?
		 * !!!Generic타입에대해 배열생성은 허용되지 않음!!! (Concrete 타입의 배열만 생성가능) --> 꼼수부릴 수밖에 없음. 모든 객0체는 Object타입이기 때문에, Object 배열 만들고 실제는 T타입의 ARray이니까 T[]으로 타입캐스팅
		 * Generics사용의 유일하게 거슬리는 점*/
	}
	@Override
	public void push(final E newElem) throws IllegalStateException{
		// TODO Auto-generated method stub
		/*Base Case1: Full Stack*/
		if (isFull()) throw new IllegalStateException("Stack is Full");
		data[++top] = newElem; //prefix operation
		size++;
	}
	private boolean isFull() {
		// TODO Auto-generated method stub
		return top == data.length-1;
	}
	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Base Case1: Empty Stack*/
		if (isEmpty()) throw new EmptyStackException();
		E answer = data[top];
		data[top] = null;
		top --;
		size --;
		return answer;
	}
	@Override
	public E top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyStackException();
//		E answer = data[top];
		return data[top];
	}
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
	//	stack.push("11");
		
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
//	/*Field*/
//	private static final int CAPACITY = 5;
//	private int size = 0;
//	private int top = -1;
//	private E[] data;
//	/*Constructor*/
//	public ArrStack2() {
//		this(CAPACITY);
//	}
//	public ArrStack2(int capacity) {
//		data = (E[]) new Object[capacity];
//	}
//	
//	@Override
//	public int size() {
//		// TODO Auto-generated method stub
//		return size;
//	}
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return (top==-1);
//	}
//	public boolean isFull() {
//		return (size==data.length);
//	}
//	@Override
//	public E top() throws EmptyStackException {
//		// TODO Auto-generated method stub
//		/*Base Case: Empty Stack*/
//		if (isEmpty()) throw new EmptyStackException();
//		return data[top];
//	}
//	@Override
//	public E pop() throws EmptyStackException {
//		// TODO Auto-generated method stub
//		/*Base Case: Empty Stack*/
//		if (isEmpty()) throw new EmptyStackException();
//		E answer = data[top];
//		data[top] = null;
//		top -= 1;
//		size --;
//		return answer;
//	}
//	@Override
//	public void push(E newElem) throws IllegalStateException {
//		// TODO Auto-generated method stub
//		/*Base Case: Full Stack*/
//		if (isFull()) throw new IllegalAccessError("Stack is Full");
//		top += 1;
//		data[top] = newElem;
//		size++;
//	}
//	
//	public void printAll() {
//		for (E s: data) {
//			System.out.println(s);
//		}
//	}
//	
//	public static void main(String[] args) {
//		ArrStack2<String> stack = new ArrStack2<>();
//		stack.push("123");
//		stack.push("456");
//		stack.push("7");
//		stack.push("89");
//		stack.push("10");
////		stack.push("11");
//		
//		System.out.println("Top: " + stack.top());
//		stack.printAll();
//		System.out.println("--------------------");
//		System.out.println("Pop: " + stack.pop());
//		System.out.println("Top: " + stack.top());
//		stack.printAll();
//		System.out.println("--------------------");
//		System.out.println("Pop: " + stack.pop());
//		System.out.println("Top: " + stack.top());
//		stack.printAll();
//	
//	}
//	
//	
//	
//}
