package singleLinkedList;


public class Node<T> {
	
	private T element;
	private Node<T> nextN;
	
	public Node() { // 생성자: 해당 객체를 생성할 때, 어떤식으로 초기화할 것인가?
		// TODO Auto-generated constructor stub
		this(null, null);
	}
	public Node(T e, Node<T> n) {
		element = e;
		nextN = n;
	}
	
	public T getElem() {
		return element;
	}
	public Node<T> getNextN() {
		return nextN;
	}
	
	public void setElem(T newElem) {
		element = newElem;
	}
	public void setNextN(Node<T> newNode) {
		nextN = newNode;
	}
	
}
