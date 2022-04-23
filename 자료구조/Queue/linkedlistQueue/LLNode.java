package linkedlistQueue;

/**LinkedListQueue를 구현할 때, 각각의 "노드"를 나타내는 타입이 필요할 것임.
 * 1) 노드를 구성하는 필드 + 2) getter, setter*/
public class LLNode<T> {
	private LLNode<T> nextN;
	private T elem;
	
	public LLNode() { // 비어있는 노드
		// TODO Auto-generated constructor stub
		this(null, null);
	}
	public LLNode(T e, LLNode<T> n) {
		// TODO Auto-generated constructor stub
		elem = e;
		nextN = n;
	}
	
	public LLNode<T> getNextN() {
		return nextN;
	}
	public T getElem() {
		return elem;
	}
	public void setNextN(LLNode<T> newNext) {
		nextN = newNext;
	}
	public void setElem(T newElem) {
		elem = newElem;
	}
}
