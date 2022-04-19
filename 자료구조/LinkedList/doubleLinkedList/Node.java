package doubleLinkedList;

/** Node를 어떻게 "논리적"으로 표현할 수 있는가?*/
public class Node<T> implements NodeADT<T>{ // 컨테이너 역할을 하는 "노드 안에"들어가는 Element의 타입이 무엇인지 모르니 Generic타입으로 한다.
	
	/*Field
	 * 노드는 논리적으로 Element, prevNode, nextNode로 구성된다.
	 * Element는 노드안에 들어가는 value이므로 Generic 타입 T.
	 * prevNode, nextNode는 "노드를 가리키므로" Node<T>타입.*/
	private T element;
	private Node<T> prevN;
	private Node<T> nextN;
	
	/*Default Constructor
	 * 노드객체를 생성시 어떻게 초기화 할 것인가?*/
	public Node() {
		// TODO Auto-generated constructor stub
		this(null, null, null);
	}
	/*Constructor*/
	public Node(T e, Node<T> p, Node<T> n) {
		element = e;
		prevN = p;
		nextN = n;
	}
	@Override
	public T getElem() {
		// TODO Auto-generated method stub
		return element;
	}
	@Override
	public Node<T> getNextN() {
		// TODO Auto-generated method stub
		return nextN;
	}
	@Override
	public Node<T> getPrevN() {
		// TODO Auto-generated method stub
		return prevN;
	}
	@Override
	public void setElem(T newElem) {
		// TODO Auto-generated method stub
		element = newElem;
	}
	@Override
	public void setNextN(Node<T> newNextN) {
		// TODO Auto-generated method stub
		nextN = newNextN;
	}
	@Override
	public void setPrevN(Node<T> newPrevN) {
		// TODO Auto-generated method stub
		prevN = newPrevN;
	}

	
}
	





















