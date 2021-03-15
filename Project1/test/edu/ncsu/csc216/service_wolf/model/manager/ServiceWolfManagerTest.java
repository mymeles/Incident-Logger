/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A class to test ServiceWolfManager
 * 
 * @author meles
 *
 */
public class ServiceWolfManagerTest {

	private ServiceWolfManager manager;

	/**
	 * Sets up the RegistrationManager and clears the data.
	 * 
	 * @throws Exception if error
	 */
	@Before
	public void setUp() throws Exception {

		manager = ServiceWolfManager.getInstance();
		manager.resetManager();

	}

	/**
	 * Test method for saveTofile
	 */
	@Test
	public void testSaveToFile() {

//		ServiceGroup g2;
//		ServiceGroup g3; 
//		ServiceGroup g1; 
//		manager.addServiceGroup("CSC");
//		manager.addIncidentToServiceGroup("jj", "jhasfdkjasy:", "asjhdgfakjh");
//		
//		manager.saveToFile("asjhdfaskjh");
		fail();

	}

	/**
	 * Test method for loadFromFile
	 */
	@Test
	public void testLoadFromFile() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals("OIT", manager.getServiceGroupName());
		assertEquals(3, manager.getServiceGroupList().length);

	}

	/**
	 * Test method for getIncidentAsArray
	 */
	@Test
	public void testGetIncidentsAsArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for getIncidentById
	 */
	@Test
	public void testGetIncidentById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for executecommand
	 */
	@Test
	public void testExecuteCommand() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for deleteIncidentById
	 */
	@Test
	public void testDeleteIncidentById() {
		manager.loadFromFile("test-files/incidents3.txt");
		manager.loadServiceGroup("CSC IT");
		assertEquals(4, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(2);
		assertEquals(3, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(9);
		assertEquals(2, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(4);
		assertEquals(1, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(3);
		assertEquals(0, manager.getIncidentsAsArray().length);
	}

	/**
	 * Test method for addIncidentToServiceGroup.
	 */
	@Test
	public void testAddIncidentToServiceGroup() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for loadServiceGroup
	 */
	@Test
	public void testLoadServiceGroup() {
		fail();
	}

	/**
	 * Test method for getServiceGroupName
	 */
	@Test
	public void testGetServiceGroupName() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals("OIT", manager.getServiceGroupName());
		assertEquals(1, manager.getIncidentById(1).getId());
		assertEquals("In Progress", manager.getIncidentById(1).getState());

	}

	/**
	 * Test method for getServiceGroupList
	 */
	@Test
	public void testGetServiceGroupList() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals(3, manager.getServiceGroupList().length);
		String[] list = manager.getServiceGroupList();
		assertEquals("CSC IT", list[0]);
		assertEquals("ITECS", list[1]);
		assertEquals("OIT", list[2]);

	}

	/**
	 * Test method for clearServiceGroup
	 */
	@Test
	public void testClearServiceGroups() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals(3, manager.getServiceGroupList().length);
		manager.clearServiceGroups();
		assertEquals(0, manager.getServiceGroupList().length);
	}

	/**
	 * Test method for editServiceGroup
	 */
	@Test
	public void testEditServiceGroup() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals("OIT", manager.getServiceGroupName());
		assertEquals(3, manager.getServiceGroupList().length);
		manager.editServiceGroup("NCSU IT");
		assertEquals("NCSU IT", manager.getServiceGroupName());
		assertEquals(3, manager.getServiceGroupList().length);

		// invalid name null
		try {
			manager.editServiceGroup(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals("NCSU IT", manager.getServiceGroupName());
			assertEquals(3, manager.getServiceGroupList().length);

		}

		// invalid name null
		try {
			manager.editServiceGroup("NCSU IT");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals("NCSU IT", manager.getServiceGroupName());
			assertEquals(3, manager.getServiceGroupList().length);

		}

		// invalid name null
		try {
			manager.editServiceGroup("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals("NCSU IT", manager.getServiceGroupName());
			assertEquals(3, manager.getServiceGroupList().length);

		}

	}

	/**
	 * Test method for addServiceGroup
	 */
	@Test
	public void testAddServiceGroup() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for deleteServiceGroup
	 */
	@Test
	public void testDeleteServiceGroup() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for resetmanager
	 */
	@Test
	public void testResetManager() {
		fail("Not yet implemented"); // TODO
	}

}
