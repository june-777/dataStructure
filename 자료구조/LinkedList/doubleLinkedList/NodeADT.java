package doubleLinkedList;

public interface NodeADT<T> { // 컨테이너 노드 안에 어떤 타입의 Element가 들어갈지 모르니 Generic 타입을 사용.
	public T getElem();
	public Node<T> getNextN();
	public Node<T> getPrevN();
	
	public void setElem(T newElem);
	public void setNextN(Node<T> newNextN);
	public void setPrevN(Node<T> newPrevN);
}
