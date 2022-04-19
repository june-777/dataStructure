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

	// SUT (System(class) Under Test)
	private Stack<Integer> stack;//(private은 optional, Stack을 generic으로 선언했는데, 실제로 사용할 concrete한 타입을 선언하려면 타입 T를 구체화시켜줘야 함 Stack of T를 어떤 타입으로 쓸 것이냐 )
	private Stack<String> stringStack; // Generics의 장점: 공통적인 definition 한번만 선언하면 재사용 가능

	@Test
	void testPush() {
		/*보통 테스트는 Given, When, Then 스타일로 수행해주는 것이 좋음
		 * Given: Stack이 생성된 상황에서
		 * When: push를 했을 때,
		 * Then: 이 situation이 만족되는가?*/
		//Given
		stack = new ArrStack2<>(10); //**타입자체는 STack 타입이지만 실제 implement하고있는 타입은 ArrStakck2이니까 생성할 땐 Interface타입이 아닌 Concrete한 클래스 타입을 지정해줘야 함! **
									// CAPACITY가 10인 배열 스택을 만들겠다.
		//When
		stack.push(7);
		
		//Then
		assertEquals(7, stack.top() ); //어떤 일이 일어나야 정상? push(7)이 제대로 실행됐다고 볼 수 있는가? Stack의 top을 불렀을 떄, 7이 리턴돼야 정상.  assertEquals(기댓값, 실제실행된 값)
		
//		fail("Not yet implemented");
	}
	
	@Test
	void push_onFullStack_throwsException() {
		//Arrange (Given)
		stack = new ArrStack2<>(2);
		stack.push(1);
		stack.push(2);
		
		//Act (When) 
		//Assert (Then) // fullstack일때 어떤 일이 벌어져야하는가?
		assertThrows(IllegalStateException.class, () -> stack.push(3));
	}

	@Test // 훨씬 바람직한 방법
	void push_onFullStack_throwsException_anotherWay(){
		//Arrange (Given)
		stack = new ArrStack2<>(2);
		stack.push(1);
		stack.push(2);
		
		//Act (When) 
		IllegalStateException exception = assertThrows(IllegalStateException.class, ()->stack.push(3)); //Import Error 주의 (자동 Import가 안되네..)

		//Assert (Then)
		assertEquals("Stack is Full", exception.getMessage());

	}
	
	@Test
	void popTest(){
		// Given
		stack = new ArrStack2<>(10);
		stack.push(1);
		stack.push(2);
		
		// When
		int result = stack.pop();
		
		// Then(Assert)
		assertEquals(2, result);
	}
	
	@Test
	void pop_emptyStack_throwsException() {
		// Given
		stack = new ArrStack2<>(10);

		// When
		// Then
		assertThrows(EmptyStackException.class, ()->stack.pop());
	}
	
	@Test
	void top_emptyStack_throwsException() {
		// Given
		stack = new ArrStack2<>(10);

		// When
		// Then
		assertThrows(EmptyStackException.class, ()->stack.top());
	}
	
	@Test
	void testSize() {
		// Given
		stack = new ArrStack2<>(10);
		stack.push(777);
		stack.push(88);
		stack.push(9);
		assertEquals(3, stack.size());
	}
	
	@Test
	void testEmpty() {
		// Given
		stack = new ArrStack2<>(5);
		stack.push(5);
		stack.push(3);
		stack.pop();
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}
}
