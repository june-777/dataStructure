package arrBasedStack;

import java.util.EmptyStackException;


/** Stack Abstract Data Type ; 사용자입장에서 Stack의 어떤 기능들이 있는가?
 *  Stack의 요구사항은?
 * */
public interface Stack<T> {
	
	void push(T newElem) throws StackFullException;
	T pop() throws EmptyStackException;
	T top() throws EmptyStackException;
	boolean isEmpty();
	int size();
	//boolean isFull(); Stack은 Array-based, LL-based로 구현가능. 어떻게 구현하느냐에따라 Full Stack이 없을 수 있으니 isFull()는 ADT에서 제외.
}
