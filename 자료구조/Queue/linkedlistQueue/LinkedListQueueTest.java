package linkedlistQueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListQueueTest {
	Queue<String> queue;
	
	@Test
	void testEnqueue() {
		//Given
		queue = new LinkedListQueue<>();
		//When
		queue.enqueue("안녕하세요");
		queue.enqueue("잘가세요");
		//Then
		assertEquals("안녕하세요", queue.front());
	}
	
	@Test
	void testDequeue() {
		//Given
		queue = new LinkedListQueue<>();
		//When
		queue.enqueue("안녕");
		queue.enqueue("잘가");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("안녕하시오");
		
		//Then
		assertEquals("안녕하시오", queue.dequeue());
	}
	@Test
	void testDequeue_emptyqueue() {
		//Given
		queue = new LinkedListQueue<String>();
		//When
		queue.enqueue("Hi");
		queue.dequeue();
		//Then
		assertThrows(IllegalStateException.class, () -> queue.dequeue());
	}
	@Test
	void testSize() {
		//Given
		queue = new LinkedListQueue<String>();
		//When Then
		queue.enqueue("안녕");
		queue.enqueue("하이");
		queue.dequeue();
		assertEquals(1, queue.size());
		queue.dequeue();
		assertTrue( queue.isEmpty());
	
	}
	

}
