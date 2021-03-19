package edu.ncsu.csc216.service_wolf.model.manager;

import java.util.ArrayList;

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
 * @author Meles Meles
 *
 */
public class ServiceWolfManager {

	/**
	 * Creates an instance of servicewolf manager
	 */
	private static ServiceWolfManager instance;

	/**
	 * An ArrayList represerntation of service groups
	 */
	private ArrayList<ServiceGroup> serviceGroups = null;
	/**
	 * A serviceGroup called currentServiceGroup
	 */
	private ServiceGroup currentServiceGroup;

	/**
	 * A string representaing ServiceGroup name
	 */
	String name;

	/**
	 * A constructor for Service wolf manager that constructs an ArrayList of
	 * serviceGroup
	 */
	private ServiceWolfManager() {
		serviceGroups = new ArrayList<ServiceGroup>();

	}

	/**
	 * A method that return the instance of selfWolfService Manager
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
	 * A method to save service groups to a file using the service writer class
	 * class directly. then loads the file that it saved back again.
	 * 
	 * @param fileName a location where the file is saved
	 * 
	 * @throws IAE if the current service group is empty or the incidents in it are
	 *             empty.
	 */
	public void saveToFile(String fileName) {
		if (currentServiceGroup == null || currentServiceGroup.getIncidents().size() == 0) {
			throw new IllegalArgumentException("“Unable to save file.”");
		}
		ServiceGroupWriter.writeServiceGroupsToFile(fileName, serviceGroups);
		loadFromFile(fileName);
	}

	/**
	 * A method to read service groups from a file using the calls service reader
	 * class. if the service group is empty it directly reads
	 * 
	 * @param fileName location of a service file\
	 * 
	 * @throws IAE if the file can not be read
	 */
	public void loadFromFile(String fileName) {
		ArrayList<ServiceGroup> temp = new ArrayList<ServiceGroup>();
		try {
			if (currentServiceGroup == null) {
				temp = ServiceGroupsReader.readServiceGroupsFile(fileName);
				currentServiceGroup = temp.get(0);
				currentServiceGroup.setIncidentCounter();
				for (int i = temp.size() - 1; i >= 0; i--) {
					sort(temp.get(i));
				}
				return;
			}
			temp = ServiceGroupsReader.readServiceGroupsFile(fileName);
			currentServiceGroup = temp.get(0);
			currentServiceGroup.setIncidentCounter();
			sort(currentServiceGroup);

			for (int i = temp.size() - 1; i >= 0; i--) {
				sort(temp.get(i));
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

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
				list[i][1] = currentServiceGroup.getIncidents().get(i).getState();
				list[i][2] = currentServiceGroup.getIncidents().get(i).getTitle();
				list[i][3] = currentServiceGroup.getIncidents().get(i).getStatusDetails();
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

		if (currentServiceGroup == null) {
			return null;
		}
		return currentServiceGroup.getIncidentById(id);
	}

	/**
	 * executes command on the current incident by refrencinf to its incident
	 * 
	 * @param id      an integer refrencing incident
	 * @param command is a command to execute
	 */
	public void executeCommand(int id, Command command) {
		if (currentServiceGroup == null) {
			return;
		}
		currentServiceGroup.executeCommand(id, command);
	}

	/**
	 * a method to delete an incident by index number
	 * 
	 * @param id an integer that refrences incidents
	 */
	public void deleteIncidentById(int id) {

		if (currentServiceGroup == null) {
			return;
		}
		currentServiceGroup.deleteIncidentById(id);

	}

	/**
	 * A method that adds incidents to service groups.
	 * 
	 * @param title   title of the incident
	 * @param caller  caller of the incident
	 * @param message message of the incident
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		if (currentServiceGroup == null) {
			return;
		}
		try {
			Incident i = new Incident(title, caller, message);
			currentServiceGroup.addIncident(i);
			currentServiceGroup.setIncidentCounter();
		} catch (IllegalArgumentException e) {
			//
		}

	}

	/**
	 * A method to load and read service groups from a given file name
	 * 
	 * @param serviceGroupName is a string representaion of a file loaction to load
	 *                         service groups
	 */
	public void loadServiceGroup(String serviceGroupName) {
		// we are adding the given service group to the current service group
		if (serviceGroups.size() > 0) {
			for (int i = 0; i < serviceGroups.size(); i++) {
				if (serviceGroups.get(i).getServiceGroupName().equals(serviceGroupName)) {
					currentServiceGroup = serviceGroups.get(i);
					currentServiceGroup.setIncidentCounter();
					return;
				}
			}
		}
		throw new IllegalArgumentException("");

	}

	/**
	 * retrives the service group name of the current service group
	 * 
	 * @return a string value of a service group name
	 */
	public String getServiceGroupName() {
		if (currentServiceGroup == null) {
			return null;
		} else {
			return currentServiceGroup.getServiceGroupName();
		}
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
		currentServiceGroup = null;
	}

	/**
	 * This method updates the serviceGroupName of the currentServicewGroupName and
	 * loads the updates serviceGroup to be the current service group by calling the
	 * method load service group.
	 * 
	 * @param updateName a string value of the new name of the update service group
	 *                   name
	 * 
	 * @throws IAE if the name of the serviceGroup is null or empty or duplicate in
	 *             the service sroup list - If the current service group is null
	 *             throws an IAE.
	 */
	public void editServiceGroup(String updateName) {
		if (updateName == null || "".equals(updateName) || checkDuplicateServiceName(updateName)) {
			throw new IllegalArgumentException("Invalid service group name.");
		}

		if (currentServiceGroup == null)
			throw new IllegalArgumentException("No service group selected.");

		ServiceGroup temp = currentServiceGroup;
		deleteServiceGroup();
		temp.setServiceGroupName(updateName.trim());
		sort(temp);

		loadServiceGroup(updateName);

	}

	/**
	 * A method that takes in a String value for serviceName and creates a new
	 * serviceGroup in the serviceGroup list and loads the new serviceGroup as the
	 * CurrentServiceGroup by calling loadServiceGroup();
	 * 
	 * @param serviceGroupName a string value of the service group name
	 * 
	 * @throws IAE if the serviceGroupName is null or empty - if the
	 *             serviceGroupName is duplicate and lareaday exist in the
	 *             serviceGoups then an IAE is thrown.
	 */
	public void addServiceGroup(String serviceGroupName) {
		if (serviceGroupName == null || "".equals(serviceGroupName) || checkDuplicateServiceName(serviceGroupName)) {
			throw new IllegalArgumentException("Invalid service group name.");
		}
		ServiceGroup addService = new ServiceGroup(serviceGroupName);
		sort(addService);
		loadServiceGroup(serviceGroupName);
	}

	/**
	 * A method that checks for duplicate service groups in the service froup list
	 * returns true if the name is duplicate and false if the name is not duplicate
	 * 
	 * @param sgName is the name of the service group
	 * @return a value of boolean
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
	 * A method to delete current serviceGroups from the serviceGroups. after
	 * deleting the method sets the currentServiceGroup to the serviceGroups list of
	 * index of zero. if the size of the list is empty the the current serviceGrroup
	 * is set to null.
	 * 
	 * @throws IllegalArgumentException If the currentServiceGroup is null.
	 */
	public void deleteServiceGroup() {
		if (currentServiceGroup == null) {
			throw new IllegalArgumentException("No service group selected.");
		}

		else if (serviceGroups.size() == 1) {
			serviceGroups.remove(0);
			currentServiceGroup = null;
		}

		if (serviceGroups.size() > 0) {
			for (int i = 0; i < serviceGroups.size(); i++) {
				if (currentServiceGroup.getServiceGroupName().equals(serviceGroups.get(i).getServiceGroupName())) {
					serviceGroups.remove(i);
					currentServiceGroup = serviceGroups.get(0);
					return;
				}
			}
		}

	}

	/**
	 * A helping method to sort service groups as thier are added into the list.
	 * asorting by insertion.
	 * 
	 * @param sg serviceGroup passed to be added in serviceGroups list.
	 */
	private void sort(ServiceGroup sg) {

		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().equals(sg.getServiceGroupName())) {
				return;
			} else if (serviceGroups.get(i).getServiceGroupName().compareTo(sg.getServiceGroupName()) > 0) {
				serviceGroups.add(i, sg);
				return;
			}
		}
		serviceGroups.add(sg);
	}

	/**
	 * A method to reset the incident manager for testing
	 */
	protected void resetManager() {
		instance = null;
	}

}