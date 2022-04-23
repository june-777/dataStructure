package arrayQueue;

import java.util.EmptyStackException;

public interface Queue<T> {
	T dequeue() throws EmptyQueueException;
	T front();
	void enqueue(T newElem) throws FullQueueException;
	int size();
	boolean isEmpty();
}
