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

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A class to test ServiceWolfManager
 * 
 * @author meles
 *
 */
public class ServiceWolfManagerTest {

	/**
	 * 
	 */
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
		manager.addServiceGroup("one");
		assertEquals(1, manager.getServiceGroupList().length);

		manager.addIncidentToServiceGroup("title1", "caller1", "message1");
		assertEquals("2", manager.getIncidentsAsArray()[0][0]);
		assertEquals("New", manager.getIncidentsAsArray()[0][1]);
		assertEquals("title1", manager.getIncidentsAsArray()[0][2]);
		assertEquals("No Status", manager.getIncidentsAsArray()[0][3]);

		manager.addIncidentToServiceGroup("title2", "caller2", "message2");
		assertEquals("2", manager.getIncidentsAsArray()[0][0]);
		assertEquals("New", manager.getIncidentsAsArray()[0][1]);
		assertEquals("title2", manager.getIncidentsAsArray()[0][2]);
		assertEquals("No Status", manager.getIncidentsAsArray()[0][3]);
		manager.addIncidentToServiceGroup("title3", "caller3", "message3");
		assertEquals("3", manager.getIncidentsAsArray()[0][0]);
		assertEquals("New", manager.getIncidentsAsArray()[0][1]);
		assertEquals("title3", manager.getIncidentsAsArray()[0][2]);
		assertEquals("No Status", manager.getIncidentsAsArray()[0][3]);
		manager.addIncidentToServiceGroup("title2", "caller2", "message2");
		assertEquals(3, manager.getIncidentsAsArray().length);

		manager.addServiceGroup("two");
		assertEquals(2, manager.getServiceGroupList().length);

		manager.addIncidentToServiceGroup("title1", "caller1", "message1");
		manager.addIncidentToServiceGroup("title2", "caller2", "message2");
		manager.addIncidentToServiceGroup("title3", "caller4", "message3");

		manager.addServiceGroup("tree");
		assertEquals(3, manager.getServiceGroupList().length);
		manager.addIncidentToServiceGroup("title1", "caller1", "message1");
		manager.addIncidentToServiceGroup("title2", "caller2", "message2");
		manager.addIncidentToServiceGroup("title3", "caller4", "message3");

	}

	/**
	 * Test method for loadFromFile
	 */
	@Test
	public void testLoadFromFile() {
		manager.loadFromFile("test-files/incidents3.txt");
		assertEquals("OIT", manager.getServiceGroupName());
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupList()[0]);
		assertEquals("ITECS", manager.getServiceGroupList()[1]);
		assertEquals("OIT", manager.getServiceGroupList()[2]);

	}

	/**
	 * Test method for getIncidentAsArray
	 */
	@Test
	public void testGetIncidentsAsArray() {
		manager.loadFromFile("test-files/incidents1.txt");
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupList()[0]);
		assertEquals("ITECS", manager.getServiceGroupList()[1]);
		assertEquals("OIT", manager.getServiceGroupList()[2]);
		assertEquals("CSC IT", manager.getServiceGroupName());

		// check if the ids of each incident that exit on current service are correct
		assertEquals("CSC IT", manager.getServiceGroupList()[0]);
		assertEquals("2", manager.getIncidentsAsArray()[0][0]);
		assertEquals("Canceled", manager.getIncidentsAsArray()[0][1]);
		assertEquals("Piazza", manager.getIncidentsAsArray()[0][2]);
		assertEquals("Not an Incident", manager.getIncidentsAsArray()[0][3]);

		// chek for null current state
		manager.deleteIncidentById(2);
		assertEquals(3, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(4);
		assertEquals(2, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(3);
		assertEquals(1, manager.getIncidentsAsArray().length);

		manager.deleteIncidentById(9);
		assertEquals(0, manager.getIncidentsAsArray().length);

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
		manager.loadFromFile("test-files/incidents1.txt");
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
		manager.loadFromFile("test-files/incidents1.txt");
		manager.loadServiceGroup("OIT");
		assertEquals("1", manager.getIncidentsAsArray()[0][0]);
		assertEquals("In Progress", manager.getIncidentsAsArray()[0][1]);

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
		assertNull(null, manager.getServiceGroupList());
		assertNull(null, manager.getServiceGroupName());
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

		manager.editServiceGroup("ServverGroup");
		assertEquals("ServverGroup", manager.getServiceGroupName());
		assertEquals(3, manager.getServiceGroupList().length);

	}

	/**
	 * Test method for addServiceGroup
	 */
	@Test
	public void testAddServiceGroup() {
		assertNull(null, manager.getServiceGroupName());

		manager.loadFromFile("test-files/incidents1.txt");
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupName());

		try {
			manager.addServiceGroup(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals(3, manager.getServiceGroupList().length);
			assertEquals("CSC IT", manager.getServiceGroupName());

		}

		try {
			manager.addServiceGroup("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals(3, manager.getServiceGroupList().length);
			assertEquals("CSC IT", manager.getServiceGroupName());

		}

		try {
			manager.addServiceGroup("CSC IT");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid service group name.", e.getMessage());
			assertEquals(3, manager.getServiceGroupList().length);
			assertEquals("CSC IT", manager.getServiceGroupName());
		}

		manager.addServiceGroup("serverGroup");
		assertEquals(4, manager.getServiceGroupList().length);
		assertEquals("serverGroup", manager.getServiceGroupName());

	}

	/**
	 * Test method for deleteServiceGroup
	 */
	@Test
	public void testDeleteServiceGroup() {
		manager.loadFromFile("test-files/incidents1.txt");
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupName());

		manager.deleteServiceGroup();
		assertEquals(2, manager.getServiceGroupList().length);
		assertEquals("ITECS", manager.getServiceGroupName());

		manager.deleteServiceGroup();
		assertEquals(1, manager.getServiceGroupList().length);
		assertEquals("OIT", manager.getServiceGroupName());

		try {
			manager.deleteServiceGroup();
			fail();
		} catch (IllegalArgumentException e) {

			assertEquals("No service group selected.", e.getMessage());
		}
		assertNull(null, manager.getServiceGroupList().length);

	}

}
