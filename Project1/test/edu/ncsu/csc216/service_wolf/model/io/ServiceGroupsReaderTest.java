/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A test calss for ServiceGroupReader
 * 
 * @author meles
 *
 */
public class ServiceGroupsReaderTest {

	/**
	 * Test method for readServiceGroupsFile
	 */
	@Test
	public void testReadServiceGroupsFile() {

		ArrayList<ServiceGroup> sg = null;
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents1.txt");
		assertEquals(3, sg.size());
		assertEquals("In Progress", sg.get(2).getIncidentById(1).getState());

		// testing if incidents are added in order by thier ID
		sg = null;
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents2.txt");
		// System.out.println("Testing service grpoup name first : " +
		// sg.get(0).getServiceGroupName());

		assertEquals(1, sg.size());
		assertEquals(4, sg.get(0).getIncidents().size());
		assertEquals(2, sg.get(0).getIncidents().get(0).getId());
		assertEquals(3, sg.get(0).getIncidents().get(1).getId());
		assertEquals(4, sg.get(0).getIncidents().get(2).getId());
		assertEquals(9, sg.get(0).getIncidents().get(3).getId());

		sg = null;

		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents4.txt");
		assertEquals(0, sg.size());

		// testing a file with missing id
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents5.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with incorrect state
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents6.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing state
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents7.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing title
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents8.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with empty caller
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents9.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing caller
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents10.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with negative reopen count
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents11.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with empty owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents12.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents13.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with empty status
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents14.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing status
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents15.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with missing log
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents16.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with New state with incorrect owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents17.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with New state with incorrect status details
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents18.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with In Progress state with incorrect owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents19.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with In Progress state with incorrect status details
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents20.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with On Hold state with incorrect owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents21.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with On Hold state with incorrect status details
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents22.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with Resolved state with incorrect owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents23.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with Resolved state with incorrect status details
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents24.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with Cancelled state with incorrect owner
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents25.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with Cancelled state with incorrect status details
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents26.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

		// testing with Negative incident id
		try {
			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents27.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, sg.size());
			assertEquals("Unable to load file.", e.getMessage());
		}

	}

}
