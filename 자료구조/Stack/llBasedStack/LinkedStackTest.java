package llBasedStack;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class LinkedStackTest {
	Stack<Integer> stack;
	
	@Test
	void testPush() {
		//Given
		stack = new LinkedStack<>(); // Empty Stack
		//When
		stack.push(7);
		stack.push(9);
		stack.push(10);
		//Then
		assertEquals(10, stack.top());
	}
	
	@Test
	void testPop() {
		//Given
		stack = new LinkedStack<>();
		//When
		stack.push(1);
		stack.push(3);
		stack.push(5);
		int answer = stack.pop();
		//Then
		assertEquals(5, answer);
	}
	
	@Test
	void testPop_emptyStack_throwException() throws EmptyStackException{
		//Given
		stack = new LinkedStack<>();
		//When //Then
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}
	
	@Test
	void testtop() {
		//Given
		stack = new LinkedStack<>();
		//When
		stack.push(5);
		stack.push(1);
		stack.push(55);
		//Then(Assert)
		assertEquals(55, stack.top());
		assertEquals(3, stack.size());
	}
	@Test
	void testtop_emptyStack_throwException() throws EmptyStackException{
		//Given
		stack = new LinkedStack<>();
		//When 
		stack.push(5);
		stack.pop();
		//Then
		assertThrows(EmptyStackException.class, ()->stack.top());
	}
	
	@Test
	void testEmpty() {
		//Given
		stack = new LinkedStack<>();
		//When
		stack.push(5);
		stack.push(7);
		stack.push(9);
		stack.top();
		stack.pop();
		stack.pop();
		stack.pop();
		//Then
		assertTrue(stack.isEmpty(), "is not Empty");
		
	}
	

}
