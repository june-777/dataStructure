package arrBasedStack;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


/*TDD (Test-Driven Development)
 * Failing Test --> Make it Pass (failing Test 통과시키기 충분할 만큼의 production code생성) --> refactoring (코드 가다듬기) --> ... */ 


class ArrStack2Test {
	private Stack<Integer> stack; // Generic T에 대해 Integer로 정의.
	
	/*아직 구현안된 기능들에 대해 Failing Test*/	
	@Test
	void testPush() throws Exception {
		//Given
		stack = new ArrStack2<>(5);
		//When
		stack.push(7);
		//Then (Assert)
		assertEquals(7, stack.top());
	}
	/*기본 push는 성공.. "Boundary Case"는 없는지 항상 고려
	 * Boundary Case: Full Stack일 때, Push상황*/
	@Test
	void testPush_fullStack_throwException() throws Exception {
		//Given
		stack = new ArrStack2<>(2);
		//When
		stack.push(2);
		stack.push(3);
		//Then(Assert)
		assertThrows(StackFullException.class, () -> stack.push(1));
	}
	@Test
	void testPush_fullStack_throwException_anotherway() throws Exception {
		//Given
		stack = new ArrStack2<>(2);
		//When
		stack.push(2);
		stack.push(3);
		StackFullException exception = assertThrows(StackFullException.class, () -> stack.push(1));
		//Then(Assert)
		assertEquals("Stack is Full", exception.getMessage());

	}
	
	@Test
	void testPop() throws Exception {
		//Given
		stack = new ArrStack2<>(3);
		//When
		stack.push(5);
		//Then
		assertEquals(5, stack.pop());
	}
	@Test /*Boundary Case: Empty Stack일 때, pop하는 상황*/
	void testPop_emptyStack_throwException() throws Exception {
		//Given
		stack = new ArrStack2<>(3);
		//When
		stack.push(5);
		stack.pop();
		//Then
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}
	
	@Test 
	void testTop() throws Exception {
		//Given
		stack = new ArrStack2<>(3);
		//When
		stack.push(5);
		stack.push(7);
		stack.push(8);
		//Then
		assertEquals(8, stack.top());
		assertEquals(3, stack.size()); ///top을 해도 size의 변화가 없는지까지 확인
	}
	@Test /*Boundar Case: Empty Stack일 때, top하는 상황*/
	void testTop_emptyStack_throwException() throws Exception {
		//Given
		stack = new ArrStack2<>(5);
		//When
		stack.push(5);
		stack.push(7);
		stack.pop();
		stack.pop();
		//Then
		assertThrows(EmptyStackException.class, () -> stack.top());
	}
	
	@Test
	void testSize() throws Exception{
		//Given
		stack = new ArrStack2<>(2);
		//When
		stack.push(3);
		stack.push(2);
		//Then
		assertEquals(2, stack.size());
	}
	
	
	
}
