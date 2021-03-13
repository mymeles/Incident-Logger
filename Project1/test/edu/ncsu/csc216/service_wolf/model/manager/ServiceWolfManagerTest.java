/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;


import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A class to test ServiceWolfManager
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
		
		ServiceGroup g2;
		ServiceGroup g3; 
		ServiceGroup g1; 
		manager.addServiceGroup("CSC");
		manager.addIncidentToServiceGroup("jj", "jhasfdkjasy:", "asjhdgfakjh");
		
		manager.saveToFile("asjhdfaskjh");
		
		
	}

	/**
	 * Test method for loadFromFile
	 */
	@Test
	public void testLoadFromFile() {
		fail("Not yet implemented"); // TODO
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
		fail("Not yet implemented"); // TODO
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
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for getServiceGroupName
	 */
	@Test
	public void testGetServiceGroupName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for getServiceGroupList
	 */
	@Test
	public void testGetServiceGroupList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for clearServiceGroup
	 */
	@Test
	public void testClearServiceGroups() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for editServiceGroup
	 */
	@Test
	public void testEditServiceGroup() {
		fail("Not yet implemented"); // TODO
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
