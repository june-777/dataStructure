package llBasedStack;

import java.util.EmptyStackException;

public interface Stack<T>{
	void push(T element);
	T pop() throws EmptyStackException;
	T top() throws EmptyStackException;
	int size();
	boolean isEmpty();
	
}
