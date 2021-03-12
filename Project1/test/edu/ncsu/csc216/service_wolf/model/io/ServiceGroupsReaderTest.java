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
		System.out.println("code reaching here");
		try {
			ArrayList<ServiceGroup> sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents1.txt");
			System.out.println(sg.get(0).getIncidentById(2).getId());
			System.out.println("code reaching here");
			assertEquals(3, sg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 
	}

}
