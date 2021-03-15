package edu.ncsu.csc216.service_wolf.model.incident;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

/**
 * Test class for incident
 * 
 * @author meles
 *
 */
public class IncidentTest {

	// create a commad

	/**
	 * A command for testing
	 */
	private Command commad;

	// values to test the second constructor

	/**
	 * An integer id for test incident
	 */
	private static final int ID = 2;
	/**
	 * A string state fot test incidnet
	 */
	private static final String STATE = "Canceled";
	/**
	 * A string name title for incident
	 */
	private static final String TITLE = "Piazza";
	/**
	 * A string name caller for incident
	 */
	private static final String CALLER = "sesmith5";
	/**
	 * An integer named reopencount for incident
	 */
	private static final int REOPENCOUNT = 0;
	/**
	 * A string named Owner for incident
	 */
	private static final String OWNER = "Unowned";
	/**
	 * A string named statusd for incident
	 */
	private static final String STATUSD = Incident.CANCELLATION_NOT_AN_INCIDENT;
	/**
	 * An arraylist of strings contatning incident messages
	 */
	private static final ArrayList<String> MESSAGES = new ArrayList<String>() {
		/**
		 * A default serialVersionUID for arraylist
		 */
		private static final long serialVersionUID = 1L;

		{
			add("Set up piazza for Spring 2021");
			add("Canceled; not an NC State IT service");

		}
	};

	/**
	 * a setup that sets the counter to zero for everytest
	 * 
	 * @throws Exception if the counter can not be set
	 */
	@Before
	public void setUp() throws Exception {
		// Reset the counter at the beginning of every test.
		Incident.setCounter(0);
	}

	/**
	 * A test method for Incident constructor for whenb incident is created
	 */
	@Test
	public void testIncidentStringStringString() {

		// check for a valid incident
		Incident in = null;
		in = new Incident(TITLE, CALLER, "Set up piazza for spring 2021");
		assertEquals(TITLE, in.getTitle());
		assertEquals(CALLER, in.getCaller());
		assertEquals(0, in.getId());
		assertEquals("- Set up piazza for spring 2021\n", in.getIncidentLogMessages());

		// test incident contructor with null title
		Incident in1 = null;
		try {
			in1 = new Incident(null, CALLER, "Set up piazza for spring 2021");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}

		// test incident constructor with empty title
		try {
			in1 = new Incident("", CALLER, "Set up piazza for spring 2021");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}

		// test incident contructor with null caller
		try {
			in1 = new Incident(TITLE, null, "Set up piazza for spring 2021");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}
		// test incident contructor with empty caller
		try {
			in1 = new Incident(TITLE, "", "Set up piazza for spring 2021");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}

		// test incident constructor with empty message
		try {
			in1 = new Incident(TITLE, CALLER, "");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}

		// test incdient constructor with empty message
		try {
			in1 = new Incident(TITLE, CALLER, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);
		}

		// assign = new Command(CommandValue.ASSIGN, "Assigned", "asking for a new
		// setup");

	}

	/**
	 * A test method for Incident constructor when incident is read from a file
	 */
	@Test
	public void testIncidentIntStringStringStringIntStringStringArrayListOfString() {
		// test valid incident construction
		Incident in = null;
		in = new Incident(ID, STATE, TITLE, CALLER, REOPENCOUNT, OWNER, STATUSD, MESSAGES);
		assertEquals(TITLE, in.getTitle());
		assertEquals(CALLER, in.getCaller());
		assertEquals(ID, in.getId());
		assertEquals(STATE, in.getState());
		assertEquals(REOPENCOUNT, in.getReopenCount());
		assertEquals(OWNER, in.getOwner());
		assertEquals(STATUSD, in.getStatusDetails());
		assertEquals("- Set up piazza for Spring 2021\n- Canceled; not an NC State IT service\n",
				in.getIncidentLogMessages());

		Incident in1 = null;
		// Invalid state with null value
		try {
			in1 = new Incident(ID, STATE, TITLE, CALLER, REOPENCOUNT, OWNER, null, MESSAGES);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
			assertNull(null, in1);

		}
		// invalid canceld state
		try {
			in1 = new Incident(ID, STATE, TITLE, CALLER, REOPENCOUNT, OWNER, "Invalid status", MESSAGES);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, in1);
			assertEquals("Incident cannot be created.", e.getMessage());
		}

		// create a valid newState incident
		Incident in2 = null;
		in2 = new Incident(4, Incident.NEW_NAME, TITLE, CALLER, REOPENCOUNT, Incident.UNOWNED, Incident.NO_STATUS,
				MESSAGES);
		assertEquals(TITLE, in2.getTitle());
		assertEquals(CALLER, in2.getCaller());
		assertEquals(4, in2.getId());
		assertEquals(Incident.NEW_NAME, in2.getState());
		assertEquals(REOPENCOUNT, in2.getReopenCount());
		assertEquals(OWNER, in2.getOwner());
		assertEquals(Incident.NO_STATUS, in2.getStatusDetails());
		assertEquals("- Set up piazza for Spring 2021\n- Canceled; not an NC State IT service\n",
				in2.getIncidentLogMessages());

		// check Incalid new state
		Incident in3 = null;
		try {
			in3 = new Incident(4, "New", TITLE, CALLER, REOPENCOUNT, "Unowned", "Invalid status", MESSAGES);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, in3);
			assertEquals("Incident cannot be created.", e.getMessage());
		}

		try {
			in3 = new Incident(4, "New", TITLE, CALLER, REOPENCOUNT, "owned", "Not an Incident", MESSAGES);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, in3);
			assertEquals("Incident cannot be created.", e.getMessage());
		}

		// test inprogress valid and invalid
		Incident in4 = null;
		// test valid
		in4 = new Incident(5, "In Progress", TITLE, CALLER, REOPENCOUNT, "James", Incident.NO_STATUS, MESSAGES);
		assertEquals(TITLE, in4.getTitle());
		assertEquals(CALLER, in4.getCaller());
		assertEquals(5, in4.getId());
		assertEquals("In Progress", in4.getState());
		assertEquals(REOPENCOUNT, in4.getReopenCount());
		assertEquals("James", in4.getOwner());
		assertEquals(Incident.NO_STATUS, in4.getStatusDetails());
		assertEquals("- Set up piazza for Spring 2021\n- Canceled; not an NC State IT service\n",
				in2.getIncidentLogMessages());
		// Test invalid
		in4 = null;

		// test inprogress with setting the owner to UNOWNED
		try {
			in4 = new Incident(6, "In Progress", TITLE, CALLER, REOPENCOUNT, Incident.UNOWNED, Incident.NO_STATUS,
					MESSAGES);
			fail();
		} catch (IllegalArgumentException e) { 
			assertNull(null, in4);
			assertEquals("Incident cannot be created.", e.getMessage());
		}

		// test onHold states
		Incident in5 = null;
		in5 = new Incident(10, "On Hold", TITLE, CALLER, REOPENCOUNT, "James", Incident.HOLD_AWAITING_CHANGE, MESSAGES);
		in5 = null;

		try {
			in5 = new Incident(10, "On Hold", TITLE, CALLER, REOPENCOUNT, Incident.UNOWNED,
					Incident.HOLD_AWAITING_CHANGE, MESSAGES);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(null, in5);
			assertEquals("Incident cannot be created.", e.getMessage());
		}
	}

//	/**
//	 * A tes method for Inceremtn counter
//	 */
//	@Test
//	public void testIncrementCounter() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * A test method for setCounter
//	 */
//	@Test
//	public void testSetCounter() {
//		fail("Not yet implemented"); // TODO 
//	}
//
	/**
	 * A test method for toString
	 */
	@Test
	public void testToString() {
		Incident in = null;
		in = new Incident(ID, STATE, TITLE, CALLER, REOPENCOUNT, OWNER, STATUSD, MESSAGES);
		assertEquals(TITLE, in.getTitle());
		assertEquals(CALLER, in.getCaller());
		assertEquals(ID, in.getId());
		assertEquals(STATE, in.getState());
		assertEquals(REOPENCOUNT, in.getReopenCount());
		assertEquals(OWNER, in.getOwner());
		assertEquals(STATUSD, in.getStatusDetails());
		assertEquals("- Set up piazza for Spring 2021\n- Canceled; not an NC State IT service\n",
				in.getIncidentLogMessages());
		assertEquals("* 2,Canceled,Piazza,sesmith5,0,Unowned,Not an Incident\n" + "- Set up piazza for Spring 2021"
				+ "\n" + "- Canceled; not an NC State IT service\n", in.toString());

	}

	/**
	 * A test Method for update
	 */
	@Test
	public void testUpdate() {
		Incident in = null;
		in = new Incident(TITLE, CALLER, "Set up piazza for spring 2021");
		assertEquals(TITLE, in.getTitle());
		assertEquals(CALLER, in.getCaller());
		assertEquals(0, in.getId());
		assertEquals("- Set up piazza for spring 2021\n", in.getIncidentLogMessages());
		commad = new Command(CommandValue.CANCEL, "Not an Incident", "not an NC State IT service");

		in.update(commad);
		assertEquals(Incident.UNOWNED, in.getOwner());
		assertEquals(Incident.CANCELED_NAME, in.getState());
		assertEquals("- Set up piazza for spring 2021\n- not an NC State IT service\n", in.getIncidentLogMessages());
		
		in = null;
		commad = null;
		in = new Incident(TITLE, CALLER, "Set up piazza for spring 2021");
		commad = new Command(CommandValue.ASSIGN, "James", "IN progress; have been assign an owner");
		in.update(commad);
		assertEquals("In Progress", in.getState()); 
		assertEquals("James", in.getOwner());
		assertEquals(CALLER, in.getCaller());
		assertEquals(1, in.getId());
		assertEquals("- Set up piazza for spring 2021\n- IN progress; have been assign an owner\n", in.getIncidentLogMessages());

		
		// Test invalid command for new state 
		in = null;
		commad = null;	
		try {
			in = new Incident(TITLE, CALLER, "Set up piazza for spring 2021");
			commad = new Command(CommandValue.RESOLVE, "Not an Incident", "not an NC State IT service");
			in.update(commad);
			fail();
		} catch (UnsupportedOperationException e) { 
			assertEquals(TITLE, in.getTitle());
			assertEquals(2, in.getId());
			assertEquals(CALLER, in.getCaller());
		}

	}

}
