/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupWriter;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
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
	 * A represerntation of service groups
	 */
	private ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();

	/**
	 * the currentservice group
	 */
	private ServiceGroup currentServiceGroup;
	
	String name;

	/**
	 * A constructor for Service wolf manager
	 */
	private ServiceWolfManager() {
		name = null;
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

		ServiceGroupWriter.writeServiceGroupsToFile(fileName, serviceGroups);

	}

	/**
	 * Uses the ServiceGroupReader to read the given fileName.
	 * 
	 * @param fileName location of a service file
	 */
	public void loadFromFile(String fileName) {

		serviceGroups = ServiceGroupsReader.readServiceGroupsFile(fileName);
		System.out.println("tsting file here now ;;;;;;" + serviceGroups.get(0).getServiceGroupName());
		currentServiceGroup = serviceGroups.get(0);

		Collections.sort(serviceGroups, new Comparator<ServiceGroup>() {
			@Override
			public int compare(ServiceGroup sg1, ServiceGroup s2) {
				return sg1.getServiceGroupName().compareToIgnoreCase(s2.getServiceGroupName());
			}
		});

	}

	/**
	 * returns an array of incidents
	 * 
	 * @return a 2D array string
	 */
	public String[][] getIncidentsAsArray() {
		if (currentServiceGroup == null) {
			return null;
		} else {
			String[][] list = new String[currentServiceGroup.getIncidents().size()][4];
			for (int i = 0; i < currentServiceGroup.getIncidents().size(); i++) {
				list[i][0] = Integer.toString(currentServiceGroup.getIncidents().get(i).getId());
				list[i][2] = currentServiceGroup.getIncidents().get(i).getState();
				list[i][2] = currentServiceGroup.getIncidents().get(i).getTitle();
				list[i][2] = currentServiceGroup.getIncidents().get(i).getState();
			}
			return list;
		}
	}

	/**
	 * A method the retrives an incident by a refernce id
	 * 
	 * @param id an integer refernce to an incident
	 * @return an incident
	 */
	public Incident getIncidentById(int id) {
		return currentServiceGroup.getIncidentById(id);
	}

	/**
	 * executes command on a given incident
	 * 
	 * @param id      an integer refrencing incident
	 * @param command is a command to execute
	 */
	public void executeCommand(int id, Command command) {
		//
	}

	/**
	 * a method to delete an incident by index number
	 * 
	 * @param id an integer that refrences incidents
	 */
	public void deleteIncidentById(int id) {
		for (int i = 0; i < currentServiceGroup.getIncidents().size(); i++) {
			if (currentServiceGroup.getIncidents().get(i).getId() == id) {
				currentServiceGroup.deleteIncidentById(id);
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
	 * @param serviceGroupName is a string representaion of a file loaction to load
	 *                         service groups
	 */
	public void loadServiceGroup(String serviceGroupName) {
		// we are adding the given service group to the current service group

		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().equals(serviceGroupName)) {
				currentServiceGroup = serviceGroups.get(i);
			}
		}
	}

	/**
	 * retrives the service group name of the current service group
	 * 
	 * @return a string value of a service group name
	 */
	public String getServiceGroupName() {
		return currentServiceGroup.getServiceGroupName();
	}

	/**
	 * Retrives a 1D array of service group list
	 * 
	 * @return a single array of service Group list
	 */
	public String[] getServiceGroupList() {
		String[] list = new String[serviceGroups.size()];
		for (int i = 0; i < serviceGroups.size(); i++) {
			list[i] = serviceGroups.get(i).getServiceGroupName();
		}
		return list;
	}

	/**
	 * a method to clear a service group
	 */
	public void clearServiceGroups() {
		serviceGroups = new ArrayList<ServiceGroup>();
	}

	/**
	 * A method to edit service group of thier name
	 * 
	 * @param updateName a string value of upadte service group name
	 */
	public void editServiceGroup(String updateName) {
		if (updateName == null || "".equals(updateName) || checkDuplicateServiceName(updateName)) {
			throw new IllegalArgumentException("Invalid service group name.");
		} else {
			currentServiceGroup.setServiceGroupName(updateName);
		}
		Collections.sort(serviceGroups, new Comparator<ServiceGroup>() {
			@Override
			public int compare(ServiceGroup sg1, ServiceGroup s2) {
				return sg1.getServiceGroupName().compareToIgnoreCase(s2.getServiceGroupName());
			}
		});

	}

	/**
	 * A method that adds service list to a list by name
	 * 
	 * @param servicegroup is a service group to add to list
	 */
	private void addServiceGroupToListByName(ServiceGroup servicegroup) {
		//
	}

	/**
	 * a method to add service groups
	 * 
	 * @param serviceGroupName a string value of the service group name
	 */
	public void addServiceGroup(String serviceGroupName) {
		ServiceGroup addService = new ServiceGroup(serviceGroupName.trim());
		serviceGroups.add(addService);
	}

	/**
	 * A method that checks for duplicate service3 groups
	 * 
	 * @param sgName is the name of the service group
	 */
	private boolean checkDuplicateServiceName(String sgName) {
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().equals(sgName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A method to delet a service group
	 */
	public void deleteServiceGroup() {
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (currentServiceGroup.getServiceGroupName().equals(serviceGroups.get(i).getServiceGroupName())) {
				serviceGroups.remove(i);
			}
		}
	}

	/**
	 * A method to reset the incident manager for testing
	 */
	protected void resetManager() {
		//
	}

}
