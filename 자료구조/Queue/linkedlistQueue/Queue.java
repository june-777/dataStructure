package linkedlistQueue;

public interface Queue<T> {
	void enqueue(T newElem);
	T dequeue();
	T front();
	int size();
	boolean isEmpty();
}
