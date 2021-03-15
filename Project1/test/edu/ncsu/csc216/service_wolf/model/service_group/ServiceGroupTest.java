/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * A test class for SeriviceGroup
 * 
 * @author meles
 *
 */
public class ServiceGroupTest {

	/**
	 * a ServiceGroup called serviceGroup
	 */
	private ServiceGroup serviceGroup;
	
	/** 
	 * A command for  testing 
	 */
	private Command commad;

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
	 * arraylist message for incidnet
	 */
	private static final ArrayList<String> MESSAGES3 = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("Please set up Jenkins VMs for Spring 2021 semester.");
			add("Assigned to C. Gurley");
			add("Set up test VM. Awaiting verification from caller.");
			add("VM works great, please deploy the rest."); 
			add("VMs deployed. Marked resolved.");
			add("One of the VMs has the wrong version of Checkstyle installed.");
			add("Updated version of Checkstyle.");

		}
	}; 
	
	/**
	 * a setup that sets the counter to zero for everytest 
	 * @throws Exception if the counter can not be set 
	 */
	@Before
	public void setUp() throws Exception {
		// Reset the counter at the beginning of every test.
		Incident.setCounter(0);
	}
	/**
	 * an incident to test serviceGroup
	 */
	private Incident in2 = new Incident(4, "Resolved", "Set up Jenkins VMs", "sesmith5", 1, "cgurley",
			"Permanently Solved", MESSAGES3);

	/**
	 * Test method for serviceGroup 
	 */
	@Test 
	public void testServiceGroup() {
		serviceGroup = new ServiceGroup("CSC IT");
		assertEquals("CSC IT", serviceGroup.getServiceGroupName());
		assertEquals(0, serviceGroup.getIncidents().size());

		serviceGroup = null;
		try {
			serviceGroup = new ServiceGroup(""); 
		} catch (IllegalArgumentException e) {
			assertNull(null, serviceGroup);
			assertEquals("Invalid service group name.", e.getMessage()); 
		}
		try {
			serviceGroup = new ServiceGroup(null);
		} catch (IllegalArgumentException e) {
			assertNull(null, serviceGroup);
			assertEquals("Invalid service group name.", e.getMessage());
		}
 
	} 

	/**
	 * Test method for setIncidentCounter
	 */
	@Test
	public void testSetIncidentcounter() {
		ServiceGroup sg = null;
		sg = new ServiceGroup("CSC IT"); 
		assertEquals(0, sg.getIncidents().size());
		sg.addIncident(in);  
		sg.addIncident(in1);
		sg.addIncident(in2);  
		assertEquals(3, sg.getIncidents().size()); 
		sg.setIncidentCounter();  
		
		
		Incident u = new Incident("title", "James", "Set up piazza for spring 2021");
		assertEquals(5, u.getId());
		assertEquals("title", u.getTitle());
		assertEquals("New", u.getState());
		assertEquals(Incident.NO_STATUS, u.getStatusDetails());
		assertEquals("- Set up piazza for spring 2021\n", u.getIncidentLogMessages());
		assertEquals("James", u.getCaller());
	}
 
	/**
	 * Test method for addIncident
	 */ 
	@Test
	public void testAddIncident() {
		serviceGroup = null;
		serviceGroup = new ServiceGroup("CSC IT");
		assertEquals(0, serviceGroup.getIncidents().size());
		serviceGroup.addIncident(in1);
		serviceGroup.addIncident(in);
		serviceGroup.addIncident(in2);
		assertEquals(3, serviceGroup.getIncidents().size());

		// make sure it is added in order
		assertEquals(2, serviceGroup.getIncidents().get(0).getId());
		assertEquals(3, serviceGroup.getIncidents().get(1).getId());
		assertEquals(4, serviceGroup.getIncidents().get(2).getId());
				
		try {
			serviceGroup.addIncident(in1);
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Incident cannot be created.", e.getMessage());
		}

	}

	/**
	 * Test method for getIncidentbyId
	 */
	@Test
	public void testGetIncidentById() {
		serviceGroup = new ServiceGroup("CSC IT");
		assertEquals(0, serviceGroup.getIncidents().size());
		serviceGroup.addIncident(in1);
		serviceGroup.addIncident(in); 
		serviceGroup.addIncident(in2);
		assertEquals(in1, serviceGroup.getIncidentById(3));
		assertNull(null, serviceGroup.getIncidentById(9));
	}

	/**
	 * Test method for executeCommand
	 */
	@Test
	public void testExecuteCommand() {
		serviceGroup = new ServiceGroup("CSC IT");
		assertEquals(0, serviceGroup.getIncidents().size());
		serviceGroup.addIncident(in1);
		serviceGroup.addIncident(in);
		serviceGroup.addIncident(in2);
		
		commad = new Command(CommandValue.CANCEL, "Not an Incident", "not an NC State IT service");
		serviceGroup.executeCommand(3, commad);
		assertEquals("Canceled", serviceGroup.getIncidentById(3).getState());
		assertEquals("Unowned", serviceGroup.getIncidentById(3).getOwner());
	}
  
	/**
	 * Test method for deletIncidentById 
	 */ 
	@Test
	public void testDeleteIncidentById() {
		serviceGroup = new ServiceGroup("CSC IT");
		assertEquals(0, serviceGroup.getIncidents().size());
		serviceGroup.addIncident(in1);
		serviceGroup.addIncident(in);
		serviceGroup.addIncident(in2);
		serviceGroup.deleteIncidentById(4);
		assertEquals(3, serviceGroup.getIncidents().size());

		assertEquals(2, serviceGroup.getIncidents().size());
		assertEquals("New", serviceGroup.getIncidentById(3).getState());
		serviceGroup.deleteIncidentById(2);
		assertEquals(1, serviceGroup.getIncidents().size());
		
		try {
			serviceGroup.deleteIncidentById(-1);
		} catch (IllegalArgumentException e) {
			assertEquals("Incident cannot be deleted.", e.getMessage());
			assertEquals(1, serviceGroup.getIncidents().size());
		}
		//assertNull(null, serviceGroup.getIncidentById(9));

	}

}
