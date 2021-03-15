/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A test class for ServiceGroupWriterTest
 * 
 * @author meles
 *
 */
public class ServiceGroupWriterTest {

	/**
	 * Array list message for incident 0
	 */
	private static final ArrayList<String> MESSAGES1 = new ArrayList<String>() {
		/** 
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("Set up piazza for Spring 2021");
			add("Canceled; not an NC State IT service");

		}
	};

	/**
	 * An incidnet for testing servicegroup
	 */
	private Incident in = new Incident(2, "Canceled", "Piazza", "sesmith5", 0, "Unowned", "Not an Incident", MESSAGES1);

	/**
	 * ArrayList Message for incident
	 */
	private static final ArrayList<String> MESSAGES2 = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("When I go to wolfware.ncsu.edu, I get a 500 error");

		}
	};
	/**
	 * an incidnet for testing serviceGroup
	 */
	private Incident in1 = new Incident(3, "New", "Moodle down", "sesmith5", 0, "Unowned", "No Status", MESSAGES2);

	/**
	 * Test method for writeServiceGroupsToFile
	 */
	@Test
	public void testWriteServiceGroupsToFile() {

		ArrayList<ServiceGroup> serviceGroup = new ArrayList<ServiceGroup>();
		ServiceGroup s = new ServiceGroup("CSC IT");
		s.addIncident(in);
		s.addIncident(in1);
		assertEquals(2, s.getIncidents().size());

		ServiceGroup s1 = new ServiceGroup("IETS");
		s1.addIncident(in);
		s1.addIncident(in1);
		assertEquals(2, s1.getIncidents().size());


		serviceGroup.add(s);
		serviceGroup.add(s1);
		assertEquals(2, serviceGroup.size());


		ServiceGroupWriter.writeServiceGroupsToFile("test-files/test-Incident1.txt", serviceGroup);

		checkFiles("test-files/exp_i1.txt", "test-files/test-Incident1.txt");
	} 

	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
				Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
