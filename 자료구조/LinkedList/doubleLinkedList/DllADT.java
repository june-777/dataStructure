package doubleLinkedList;

public interface DllADT<T> {
	
	/*addAfter, addBefore을 활용하면 addFirst, addLast도 구현가능할 것임. 따라서, 별도의 ADT 생성X*/
	public void addAfter(Node<T> beforeN, T newElem);
	public void addBefore(Node<T> afterN, T newElem);
	public void remove(Node<T> target);
	
	public int size();
	public boolean isEmpty();
}
