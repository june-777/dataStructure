package arrayQueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {
	Queue<Integer> queue;
	
	@Test
	void testEnqueue() throws Exception {
		//Given
		queue = new ArrayQueue<>();
		//When
		queue.enqueue(123);

		//Then(Assert)
		assertEquals(123, queue.front());
	}
	@Test
	void testEnqueue_fullqueue() throws Exception {
		//Given
		queue = new ArrayQueue<>(3);
		//When
		queue.enqueue(1);
		queue.enqueue(2);
		FullQueueException exception = assertThrows(FullQueueException.class, () -> queue.enqueue(4));
		
		//Then(Assert)
		assertEquals("Queue is Full", exception.getMessage());
	}
	
	@Test
	void testDequeue() throws Exception {
		//Given
		queue = new ArrayQueue<>();
		//When
		queue.enqueue(777);
		queue.enqueue(888);
		//Then(Assert)
		assertEquals(777, queue.dequeue()); //(FIFO)
	}
	@Test
	void testDequeue_emptyqueue() throws Exception {
		//Given
		queue = new ArrayQueue<>();
		//When
		queue.enqueue(77);
		queue.dequeue();
		//Then
		assertThrows(EmptyQueueException.class, () -> queue.dequeue());
	}
	
	@Test
	void testSize() throws Exception{
		//Given
		queue = new ArrayQueue<>();
		//When
		queue.enqueue(111);
		queue.enqueue(22);
		queue.dequeue();
		queue.enqueue(14);
		
		//Then(Assert)
		assertEquals(2, queue.size());
	}
	
	@Test
	void testEmpty() throws Exception{
		//Given
		queue = new ArrayQueue<>();
		//When
		queue.enqueue(11);
		queue.dequeue();
		//Then
		assertTrue(queue.isEmpty());
	}
	
	

}
