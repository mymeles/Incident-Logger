package edu.ncsu.csc216.service_wolf.model.command;

import static edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue.ASSIGN;
import static edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue.INVESTIGATE;
import static edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue.CANCEL;
import static edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue.RESOLVE;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test class for the class Command
 */
public class CommandTest {

	
	/**
	 * A string to represents command inforamtion 
	 */
	private static final  String INFO = "kkkk";
	
	/** 
	 * A String to represent command message 
	 */
	private static final String MESSAGE = "kkkkk";
	/**
	 * A test method for Command
	 */
	@Test
	public void testCommand() {
		Command c2 = new Command(ASSIGN, INFO, MESSAGE);
		assertEquals(ASSIGN, c2.getCommand());
		
		Command c1 = new Command(INVESTIGATE, null, MESSAGE);
		assertNull(null, c1.getCommandInformation());
		
		Command c3 = null;
		try {
			c3 = new Command(null, INFO, MESSAGE);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, c3);
			assertEquals("A Command MUST have a CommandValue", e.getMessage());
				
		} 
		
		try {
			 c3 = new Command(CANCEL, INFO, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, c3);
			assertEquals("A Command MUST have a commandMessage", e.getMessage());
		} 
		
		try { 
			c3 = new Command(ASSIGN, null, MESSAGE);
			fail();
		} catch (IllegalArgumentException e) { 
			assertNull(null, c3);
			assertEquals("These commands require an additional piece of information", e.getMessage());
		}
		
		try { 
			c3 = new Command(INVESTIGATE, INFO, MESSAGE);
			fail();
		} catch (IllegalArgumentException e) { 
			assertNull(null, c3);
			assertEquals("These commands do NOT require an additional piece of information", e.getMessage());
		}
	}  
  
	/**
	 * A test method for getCommand 
	 */
	@Test
	public void testGetCommand() {
		Command c2 = new Command(ASSIGN, INFO, MESSAGE);
		assertEquals(ASSIGN, c2.getCommand());
	}

	/**
	 * a test method for getcommandInformation
	 */
	@Test
	public void testGetCommandInformation() {
		Command c2 = new Command(ASSIGN, INFO, MESSAGE);
		assertEquals(INFO, c2.getCommandInformation());
	}

	/**
	 * A test method for getCommandMessage
	 */
	@Test
	public void testGetCommandMessage() {
		Command c2 = new Command(ASSIGN, INFO, MESSAGE);
		assertEquals(MESSAGE, c2.getCommandMessage());
	}

}
