package singleLinkedList;

// SLL 전체를 표현하기 위함
public class SLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public SLinkedList() { //** SLinkedList 만들 때, 어떤식으로 초기화할 것인가? 논리적으로 파라미터가 없다는건 아무것도 없다는 Empty List일테니..
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return (size==0);
	}
	
	public void addFirst(T newElem) {
//		Node<T> newNode = new Node<> ();
//		newNode.setElem(newElem);
//		newNode.setNextN(head);
//		head = newNode;
//		if (isEmpty()) tail = head;
//		size++;
		/*위에 4줄 한번에*/
		head = new Node<> (newElem, head);
		if (isEmpty()) tail = head;
		size++;
	}
//	public void addLast(T newElem) {
//		Node<T> newNode = new Node<>();
//		newNode.setElem(newElem);
//		newNode.setNextN(null);
//		tail.setNextN(newNode);
//		tail = newNode;		
//		if (isEmpty()) head = tail;
//		size ++;
//	}
	public T removeFirst() {
		
		if (isEmpty()) return null;
		head = head.getNextN();
		size--;
		if (size==0) tail = null;
		return head.getElem();
		
	}
	public static void main (String[] args) {
		System.out.println("test");
	}
	
	
}
	
	
	
	
	
	
	
	/* <Time Complexity>
	 * Inserting at the Head or Tail의 경우 노드의 개수와 상관이 없었음
	 * Removing at the Head: 노드의 개수와 상관 없음
	 * Removing at the Tail: 노드의 개수와 상관 !!있음!! 노드의 개수와 비례
	 * |
	 * ***Singly Linked List는 "nextNode"에 대한 정보만 존재하지, "previousNode"에 대한 정보는 존재하지 않음 즉, 거꾸로 갈 수가 없음.
	 * 즉, 앞으로 전진하는 operation은 쉽게할 수 있지만 뒤로 back하는 operation은 논리적으론 쉽지만 실제 구현은 쉽지않음
	 * |
	 * Removing at the Tail에서 tail노드가 이전의 노드를 가리키도록 갱신해야하는데, 이를 위해선 tail 이전의 노드가 어떤 노드인지 찾는 operation이 먼저 선행되어야 함
	 * 유일하게 head부터 시작해서 tail 노드의 이전 노드를 찾아가는 방법밖에 없음.
	 * |
	 * (참고) 각 자료구조의 operation의 효율성을 잘 알아야함
	 * 만약, 개발할 애플리케이션이 Inserting at the Head or Tail, Removing at the Head 를 Operation을 자주이용하면 SLL가 적절한 자료구조가 될 수 있지만
	 * Removing at the Tail을 자주 요구하면 SLL의 경우 비효율적인 자료구조.
	 * |
	 * (참고) 특정한 중간 노드를 검색해서 해당노드를 제거하던지, 이전에 추가하던지의 operation의 efficient는? --> 노드의 개수와 비례
	 * 
	 * <Doubly Linked List>
	 * SLL "거꾸로 갈 수가 없기 때문에" operation이 효율적이지 못한 문제.
	 * --> 거꾸로 갈 수 있는 링크도 노드에 추가하면 될 것임 "Doubly Linked List"
	 * 노드구조: 3개의 cell, 1)prevLink, 2)element, 3)nextLink
	 * |
	 * first, last node 어떻게 식별?
	 * in SLL) 두개의 참조변수 head, tail로 추적
	 * in DLL) Use Special Node a.k.a header, trailer
	 * 이 노드를 추가함으로써 많은 operation을 굉장히 쉽게할 수있게 해줌
	 * header, trailer 노드로 시작과 끝을 나타내게 해줌
	 * |
	 * 그림상으론 header, trailer노드가 일반적인 노드가 타입이 다른, 다른 구조를 갖는 것처럼 보이지만 실제로는 같은 타입의 노드를 사용
	 * header에선 단지 nextLink만 사용, trailer에선 prevLink만 사용되고 있는 것
	 * 나중에, 사용되지 않고있는 부분을 잘 활용하면 DLL을 이용한 operation을 구현할 때, 쉽게 구현할 수 있음.
	 * |
	 * Empty List 어떻게 표현?
	 * in SLL) head = tail = null;
	 * in DLL) header.nextLink = trailer & trailer.prevLink = header; 
	 * 
	 * 
	 * */
	
	/* <LInked List Alg 유의사항 2가지>
	 * 1. Boundary Condition: previously Empty List
	 * 		Boundary Condition에 대한 Code를 꼭 정의해줘야 함
	 * 		- Insert: Empty상태에서 추가될 때
	 * 		- Remove: 마지막 노드가 제거될 때
	 * 
	 * 2. Link update 순서
	 * 		head or tail을 먼저 갱신하면 그 head, tail에 대해 더 이상 접근이 불가
	 * 		Inserting at Tail일 때, 
	 * 		Step 1) 현재 tail의 nextlink를 newNode를 가리키게 먼저 갱신
	 * 		Step 2) Update tail to point to new node
	 * 
	 * 특히, Doubly Linked List의 경우 link update 순서에 더욱 유의해야함.
	 * */	
	
	
