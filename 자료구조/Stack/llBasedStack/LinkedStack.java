package llBasedStack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	private Node<T> top;
	private int size;
	
	public LinkedStack() { //Empty Stack
		top = null;
		size = 0;
	}
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		Node<T> newNode = new Node<T>(element);	// 1. allocate new Node
		newNode.setNextN(top); 					// 2. 새로운 노드의 링크를 old top으로 갱신
		top = newNode;							// 3. Top 갱신
		size ++;
	}

	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Edge Case 먼저 고려. Empty Stack*/
		if (top == null) throw new EmptyStackException();
		
		T answer = top.getElem(); // remove과정에서 top을 변경시, old top에 대한 접근이 불가하므로 리턴값 임시저장
		/*For Garbage Collection*/
		top.setElem(null);
		
		top = top.getNextN();
		
		size --;
		return answer;
	}

	@Override
	public T top() throws EmptyStackException {
		// TODO Auto-generated method stub
		/*Edge Case먼저 고려. Empty Stack*/
		if (top==null) throw new EmptyStackException();
		return top.getElem();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top==null);
	}

}
