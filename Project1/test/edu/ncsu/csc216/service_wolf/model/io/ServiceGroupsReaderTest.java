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
		//System.out.println("Testing service grpoup name first : " +  sg.get(0).getServiceGroupName());


		assertEquals(1, sg.size()); 
		assertEquals(4, sg.get(0).getIncidents().size());
		assertEquals(2, sg.get(0).getIncidents().get(0).getId());
		assertEquals(3, sg.get(0).getIncidents().get(1).getId());
		assertEquals(4, sg.get(0).getIncidents().get(2).getId()); 
		assertEquals(9, sg.get(0).getIncidents().get(3).getId());

		sg = null;
//		 testing to see if a service group can not be constructed with a missing
//		 service group name
		try {
		sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents4.txt");
		fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage()); 
		}
 
	//	System.out.println(sg.get(0).getServiceGroupName());

		
		//System.out.println( "hhhhhh " + sg.get(1).getServiceGroupName());
 
  
//		try {
//			sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents4.txt");
//			assertEquals(3, sg.size());
//			System.out.println("Testing service grpoup name: " +  sg.get(0).getServiceGroupName());
//			System.out.println("Testing service grpoup name: " +  sg.get(1).getServiceGroupName());
//		} catch (IllegalArgumentException e) {
//			//assertEquals(2, sg.size());
//			//assertEquals("Invalid service group name.", e.getMessage());
//		}

	} 

}
