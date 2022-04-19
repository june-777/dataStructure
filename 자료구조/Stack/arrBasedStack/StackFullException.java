package arrBasedStack;

@SuppressWarnings("serial")
public class StackFullException extends RuntimeException{
	public StackFullException() {
		
	}
	public StackFullException(final String message) {
		super(message);
	}
}
