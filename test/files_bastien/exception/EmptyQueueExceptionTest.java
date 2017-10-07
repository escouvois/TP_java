package files_bastien.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import files.exception.EmptyQueueException;

public class EmptyQueueExceptionTest {

	@Test
	public void testExceptionMessage() {
		String message = "Message";
		try {
			throw new EmptyQueueException(message);
		} catch(EmptyQueueException e){
			if(!e.getMessage().equals(message)) {
				fail();
			}
		}
	}

}
