/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.List;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * @author meles
 *
 */
public class ServiceGroup {

	/**
	 * a string representaion of service group name
	 */
	private String serviceGroupName;

	/**
	 * 
	 * @param serviceGroupName
	 */
	public ServiceGroup(String serviceGroupName) {
		// impement service group constructor
	}

	/**
	 * @return the serviceGroupName
	 */
	private String getServiceGroupName() {
		return serviceGroupName;
	}

	/**
	 * @param serviceGroupName the serviceGroupName to set
	 */
	private void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}

	/**
	 * 
	 */
	public void setIncidentcounter() {
		// impement set incident counter
	}

	/**
	 * 
	 * @param incident
	 */
	public void addIncident(Incident incident) {
		// implement add incident
	}

	/**
	 * 
	 * @return
	 */
	public List<Incident> getIncident() {
		return null;
	}

	/**
	 * 
	 * @param idx
	 * @return
	 */
	public Incident getIncidentById(int idx) {
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param command
	 */
	public void executeCommand(int id, Command command) {
		// implement execute ommand
	}

	/**
	 * 
	 * @param idx
	 */
	public void deleteIncidentById(int idx) {
		// implement delete incidenet by id
	}

}
