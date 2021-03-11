/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;


import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupWriter;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A concrete class that maintains a list of ServiceGroups, the active or
 * current serviceGroup, and handles events from the GUI. ServiceWolf implements
 * the Singleton Design Pattern and is accessed through the getInstance method.
 * 
 * @author meles
 *
 */
public class ServiceWolfManager {

	/**
	 * cretae an instance of servicewolf manager 
	 */
	private static ServiceWolfManager instance;
	
	
	
	/**
	 *  A represerntation of service groups 
	 */
	private ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
	
	/**
	 * the currentservice group 
	 */
	private ServiceGroup currentServiceGroup;
 
	/**
	 * A constructor for Service wolf manager 
	 */
	private ServiceWolfManager() {
		String name = null; 
		serviceGroups = new ArrayList<ServiceGroup>(); 

	}

	/**
	 * a methos tha returns the instance of selfWolfService Manager
	 * 
	 * @return a serviceWolf Manager
	 */
	public static ServiceWolfManager getInstance() {
		if (instance == null) {
			instance = new ServiceWolfManager();
		}
		return instance;
	}

	/**
	 * A method to save service groups to a file using service group writer
	 * 
	 * @param fileName a location where the file is saved
	 */
	public void saveToFile(String fileName) {
		try {
			ServiceGroupWriter.writeServiceGroupsToFile(fileName, serviceGroups);

		} catch (IOException e) {
			System.out.println("The file cannot be saved");
			e.printStackTrace();
		}

	}
	

	/**
	 * Uses the ServiceGroupReader to read the given fileName.
	 * 
	 * @param fileName location of a service file
	 */
	public void loadFromFile(String fileName) {
		
	}

	/**
	 * returns an array of incidents
	 * 
	 * @return a 2D array string
	 */
	public String[][] getIncidentsAsArray() {
		return null;
	}

	/**
	 * A method the retrives an incident by a refernce id
	 * 
	 * @param id an integer refernce to an incident
	 * @return an incident
	 */
	public Incident getIncidentById(int id) {
		return null;
	}

	/**
	 * executes command on a given incident
	 * 
	 * @param id      an integer refrencing incident
	 * @param command is a command to execute
	 */
	public void executeCommand(int id, Command command) {
		// implement execute ommand
	}

	/**
	 * a method to delet an incident by index number
	 * 
	 * @param idx an integer that refrences incidents
	 */
	public void deleteIncidentById(int id) {
		for(int i = 0; i < serviceGroups.size(); i++) {
			if(id == serviceGroups.get(i).getIncidents().get(i).getId()){
				serviceGroups.get(i).deleteIncidentById(id);
			}
		}
	}

	/**
	 * A method that adds incidents to service groups.
	 * 
	 * @param title   title of the incident
	 * @param caller  caller of the incident
	 * @param message message of the incident
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		// impelement add incident to service group
	}

	/**
	 * A method to load and read service groups from a given file name
	 * 
	 * @param filename is a string representaion of a file loaction to load service
	 *                 groups
	 */
	public void loadServiceGroup(String filename) {
		// implement load service group
	}

	/**
	 * retrives the service group name
	 * 
	 * @return a string value of a service group name
	 */
	public String getServiceGroupName() {
		return null;
	}

	/**
	 * Retrives a 1D array of service group list
	 * 
	 * @return a single array of service Group list
	 */
	public String[] getServiceGroupList() {
		return null;
	}

	/**
	 * a method to clear a service group
	 */
	public void clearServiceGroups() {
		// implement clear service groups
	}

	/**
	 * A method to edit service group of thier name
	 * 
	 * @param updateName a string value of upadte service group name
	 */
	public void editServiceGroup(String updateName) {
		// impement edit service groups
	}

	/**
	 * A method that adds service list to a list by name
	 * 
	 * @param servicegroup is a service group to add to list
	 */
	private void addServiceGroupToListByName(ServiceGroup servicegroup) {

	}

	/**
	 * a method to add service groups
	 * 
	 * @param serviceGroupName a string value of the service group name
	 */
	public void addServiceGroup(String serviceGroupName) {
		// impement add service group
	}

	/**
	 * A method that checks for duplicate service3 groups
	 * 
	 * @param sgName is the name of the service group
	 */
	private void checkDuplicateServiceName(String sgName) {
		// impement check duplicate
	}

	/**
	 * A method to delet a service group
	 */
	public void deleteServiceGroup() {
		// implement check duplicate
	}

	/**
	 * A methos to reset the incident manager for testing
	 */
	protected void resetManager() {
		
	}

}
