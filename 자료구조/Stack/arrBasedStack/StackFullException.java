package arrBasedStack;

@SuppressWarnings("serial")
public class StackFullException extends Exception{
	
	public StackFullException() {
		
	}
	public StackFullException(String message) {
		super(message);
	}
}
