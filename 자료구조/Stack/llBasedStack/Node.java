package llBasedStack;

public class Node<T> {
	private T element;
	private Node<T> nextN;
	
	public Node() {
		this(null);
	}
	public Node(T newElem) {
		element = newElem;
	}
	
	public T getElem() {
		return element;
	}
	public Node<T> getNextN(){
		return nextN;
	}
	
	public void setElem(T newElem) {
		element = newElem;
	}
	public void setNextN(Node<T> newNext) {
		nextN = newNext;
	}
}
