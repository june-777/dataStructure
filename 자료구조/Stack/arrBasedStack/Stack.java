package arrBasedStack;

import java.util.EmptyStackException;


/** Stack Abstract Data Type ; 사용자입장에서 Stack의 어떤 기능들이 있는가?
 * 
 * */
public interface Stack<E> {

	void push(E newElem);
	E pop() throws EmptyStackException;
	E top() throws EmptyStackException;
	
	int size();
	boolean isEmpty();
	
	
	
	
//	public int size();
//	public boolean isEmpty();
//	public T top() throws EmptyStackException;
//	
//	public void push(T newElem);
//	public T pop() throws EmptyStackException;
	
}
