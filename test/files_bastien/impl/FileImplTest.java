package files_bastien.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import files.impl.FileImpl;
import files.exception.EmptyQueueException;

public class FileImplTest {
	
	FileImpl testFile;
	
	@Before
	public void beforeEachTest() {
		testFile = new FileImpl();
	}

	@Test
	public void testFileImplAddInEmptyFile() {
		
		testFile.add(new Integer(1));
		if(testFile.length() != 1) {
			fail();
		}
	}
	
	@Test
	public void testFileImplAddInANotEmptyFile() {
		
		testFile.add(new Integer(1));
		testFile.add(new Integer(5));

		if(testFile.length() != 2) {
			fail();
		}
	}
	
	@Test
	public void testFileImplFirstInEmptyFile() {
		try {
			testFile.first();
			
			//Dans le cas ou aucune erreur n'est envoy�e.
			fail();
		}catch(EmptyQueueException e) {
			//Le test passe
		}catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testFileImplFirstInANotEmptyFile() {
		testFile.add(new Integer(1));
		try {
			testFile.first();
		}catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testFileImplisEmptyOnEmptyFile() {
		if(!testFile.isEmpty()) {
			fail();
		}
	}
	
	@Test
	public void testFileImplisEmptyNotFile() {
		testFile.add(new Integer(1));
		if(testFile.isEmpty()) {
			fail();
		}
	}
	
	@Test
	public void testFileImplRemoveOnEmptyFile() {
		try {
			testFile.remove();
			fail();
		}catch(EmptyQueueException e) {
			//Le test passe
		}catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testFileImplRemoveOnNotEmptyFile() {
		testFile.add(new Integer(1));
		try {
			testFile.remove();
		}catch(Exception e) {
			fail();
		}
	}

}
