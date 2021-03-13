/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

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
		System.out.println("code reaching here");
		ArrayList<ServiceGroup> sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents1.txt");
		assertEquals(3, sg.size());
		assertEquals("In Progress", sg.get(2).getIncidentById(1).getState());
		
	
		
 
	}
 
}
