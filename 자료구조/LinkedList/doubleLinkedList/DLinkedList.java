package doubleLinkedList;

/** Double Linked List를 어떻게 "논리적"으로 표현할 수 있는가?*/
public class DLinkedList<T> implements DllADT<T> {
	
	/*Field
	 * DLL을 논리적으로 표현하기 위해, header와 trailer special purpose node를 사용할 것이다.*/
	private Node<T> header;
	private Node<T> trailer;
	private int size;
	
	/*Default Constructor
	 * 아무런 인자를 받지 않고 DLL를 생성했을 때 즉, "Empty List"인 상황.
	 * Empty List: Header와 Trailer가 서로 가리키는 상황*/
	public DLinkedList() {
		// TODO Auto-generated constructor stub
		header = new Node<>();
		trailer = new Node<>(null, header, null);
		header.setNextN(trailer);
	}

	@Override
	public void addAfter(Node<T> beforeN, T newElem) {
		// TODO Auto-generated method stub
		/**Boundary Condition: trailer 노드 이후로 삽입하려할 때*/
		if (beforeN == trailer) {System.out.println("Trailer 이후에 삽입할 수 없습니다."); return;}
		
		/**readable code*/
		Node<T> newNode = new Node<>();			// 1. allocate new Node
		newNode.setElem(newElem);				// 2. set element
		newNode.setPrevN(beforeN);				// 3. set previous Node link
		newNode.setNextN(beforeN.getNextN());	// 4. set next Node link
		beforeN.getNextN().setPrevN(newNode);	// 5. update old next Node's previous Node Link
		beforeN.setNextN(newNode); 				// 6. update old prev Node's next Node Link
		size ++;
	}
	public void addFirst(T newElem) {
		addAfter(header, newElem);
	}

	@Override
	public void addBefore(Node<T> afterN, T newElem) {
		// TODO Auto-generated method stub
		/**Boundary Condition: trailer 노드 이후로 삽입하려할 때*/
		if (afterN == header) {System.out.println("Header 이전에 삽입할 수 없습니다."); return;}
		
		/**compact code*/
		// 1. allocate new Node, set element, prev node link and next node link
		Node<T> newNode = new Node<>(newElem, afterN.getPrevN(), afterN);			
		afterN.getPrevN().setNextN(newNode);	// 5. update old prev Node's previous Node Link
		afterN.setPrevN(newNode); 				// 6. update old next Node's next Node Link
		size ++;
	}
	public void addLast(T newElem) {
		addBefore(trailer, newElem);
	}

	@Override
	public void remove(Node<T> target) {
		// TODO Auto-generated method stub
		/**Boundary Case1: target이 header, trailer일 경우 삭제해선 안됨
		 * Boundary Case2: Empty List인 경우 삭제할 노드가 없음*/
		if (target == header || target == trailer) {System.out.println("삭제불가한 노드입니다."); return;}
		else if (isEmpty()) {System.out.println("Empty List입니다."); return;}
			
		target.getNextN().setPrevN(target.getPrevN());
		target.getPrevN().setNextN(target.getNextN());
		target.setPrevN(null);
		target.setNextN(null);
	}
	public void removeFirst() {
		if (isEmpty()) return;
		remove(header.getNextN());
	}
	public void removeLast() {
		if (isEmpty()) return;
		remove(trailer.getPrevN());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}
	
	public void printAll() {
		Node<T> cursor = header.getNextN();
		while (cursor != trailer) {
			System.out.println(cursor.getElem());
			cursor = cursor.getNextN();
		}
	}
	
	public static void main(String[] args) {
		DLinkedList<String> dll = new DLinkedList<String>();
		for (int i=0; i<2; i++) {
			dll.addAfter(dll.header, i+ " 번째 addAfter");
			dll.addFirst(i+ " 번째 addFirst");
		}
		System.out.println("----------------");
		dll.printAll();
		
		for (int i=0; i<2; i++) {
			dll.addBefore(dll.trailer, i+ " 번째 addBefore");
			dll.addLast(i+ " 번째 addLast");
		}
		System.out.println("----------------");
		dll.printAll();

		System.out.println("----------------");
		dll.remove(dll.header);
		dll.remove(dll.header.getNextN().getNextN());
		dll.remove(dll.trailer.getPrevN().getPrevN());
		dll.removeFirst();
		dll.removeLast();
		dll.printAll();
		

	}
	
}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



