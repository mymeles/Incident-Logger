/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.List;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * A class that represents ServiceGroups 
 * @author meles
 *
 */
public class ServiceGroup {

	/**
	 * a string representaion of service group name
	 */
	private String serviceGroupName;

	/**
	 * a constructor for ServiceGroup
	 * @param serviceGroupName is a string value of the service group name
	 */
	public ServiceGroup(String serviceGroupName) {
		// impement service group constructor
	}

	/**
	 * a method that returns the servicegroup name 
	 * @return the serviceGroupName
	 */
	public String getServiceGroupName() {
		return serviceGroupName;
	}

	/**
	 * a method that sets the service group name from the givin parameter.
	 * @param serviceGroupName the serviceGroupName to set -setServiceGroupName
	 */
	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}

	/**
	 * a method to set the incident counter 
	 */
	public void setIncidentCounter() {
		// impement set incident counter
	}

	/**
	 * a method to add incdient 
	 * @param incident a representation of an incident 
	 */
	public void addIncident(Incident incident) {
		// implement add incident
	}

	/**
	 * a method that returns incdeints 
	 * @return a list of incidents 
	 */
	public List<Incident> getIncidents() {
		return null;
	}

	/**
	 * a method that retrives incidents with the given index nmber 
	 * @param idx an integer referance of an incident 
	 * @return an incident 
	 */
	public Incident getIncidentById(int idx) {
		return null;
	}

	/**
	 * a method that excetues commands 
	 * @param id a unique id if incident 
	 * @param command is a command for incident 
	 */
	public void executeCommand(int id, Command command) {
		// implement execute ommand
	}

	/**
	 * A method to delete an incident by the passed parameter 
	 * @param idx is an integer reference of incident 
	 */
	public void deleteIncidentById(int idx) {
		// implement delete incidenet by id
	}

}
