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
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents5.txt");
		assertEquals(0, sg.size());

		// testing with incorrect state
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents6.txt");
		assertEquals(0, sg.size());

		// testing with missing state
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents7.txt");
		assertEquals(0, sg.size());

		// testing with missing title
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents8.txt");
		assertEquals(0, sg.size());

		// testing with empty caller
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents9.txt");

		assertEquals(0, sg.size());

		// testing with missing caller
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents10.txt");
		assertEquals(0, sg.size());

		// testing with negative reopen count
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents11.txt");
		assertEquals(0, sg.size());

		// testing with empty ownerr
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents12.txt");
		assertEquals(0, sg.size());

		// testing with missing owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents13.txt");
		assertEquals(0, sg.size());

		// testing with empty status
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents14.txt");
		assertEquals(0, sg.size());

		// testing with missing status
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents15.txt");
		assertEquals(0, sg.size());

		// testing with missing log
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents16.txt");
		assertEquals(0, sg.size());

		// testing with New state with incorrect owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents17.txt");
		assertEquals(0, sg.size());

		// testing with New state with incorrect status details
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents18.txt");
		assertEquals(0, sg.size());

		// testing with In Progress state with incorrect owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents19.txt");
		assertEquals(0, sg.size());

		// testing with In Progress state with incorrect status details
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents20.txt");
		assertEquals(0, sg.size());

		// testing with On Hold state with incorrect owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents21.txt");
		assertEquals(0, sg.size());

		// testing with On Hold state with incorrect status details

		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents22.txt");
		assertEquals(0, sg.size());

		// testing with Resolved state with incorrect owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents23.txt");
		assertEquals(0, sg.size());

		// testing with Resolved state with incorrect status details
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents24.txt");
		assertEquals(0, sg.size());

		// testing with Cancelled state with incorrect owner
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents25.txt");
		assertEquals(0, sg.size());

		// testing with Cancelled state with incorrect status details
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents26.txt");
		assertEquals(0, sg.size());

		// testing with Negative incident id
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents27.txt");
		assertEquals(0, sg.size());

	}

}
