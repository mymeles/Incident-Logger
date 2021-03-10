package edu.ncsu.csc216.service_wolf.model.incident;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test class for incident
 * 
 * @author meles
 *
 */
public class IncidentTest {

	// values to test the second constructor
	private static final int ID = 2;
	private static final String STATE = "Canceled";
	private static final String TITLE = "Piazza";
	private static final String CALLER = "sesmith5";
	private static final int REOPENCOUNT = 0;
	private static final String OWNER = "Unowned";
	private static final String STATUSD = "Not an Incident";
	private static ArrayList<String> MESSAGES = new ArrayList<String>() {
		{
			add("Set up piazza for Spring 2021");
			add("Canceled; not an NC State IT service");

		}
	};

	/**
	 * A test method for Incident constructor for whenb incident is created
	 */
	@Test
	public void testIncidentStringStringString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * A test method for Incident constructor when incident is read from a file
	 */
	@Test
	public void testIncidentIntStringStringStringIntStringStringArrayListOfString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * A tes method for Inceremtn counter
	 */
	@Test
	public void testIncrementCounter() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * A test method for setCounter
	 */
	@Test
	public void testSetCounter() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * A test method for toString
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * A test Method for update
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}
