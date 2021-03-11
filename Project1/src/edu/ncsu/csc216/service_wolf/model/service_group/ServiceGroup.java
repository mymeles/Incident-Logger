/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * A class that represents ServiceGroups
 * 
 * @author meles
 *
 */
public class ServiceGroup {

	/**
	 * a string representaion of service group name
	 */
	private String serviceGroupName;

	/**
	 * A List of incidents called incident
	 */
	ArrayList<Incident> incident = new ArrayList<Incident>();

	/**
	 * a constructor for ServiceGroup
	 * 
	 * @param serviceGroupName is a string value of the service group name
	 */
	public ServiceGroup(String serviceGroupName) {

		setServiceGroupName(serviceGroupName);
		incident = new ArrayList<Incident>();
	}

	/**
	 * a method that returns the servicegroup name
	 * 
	 * @return the serviceGroupName
	 */
	public String getServiceGroupName() {
		return serviceGroupName;
	}

	/**
	 * a method that sets the service group name from the givin parameter.
	 * 
	 * @param serviceGroupName the serviceGroupName to set -setServiceGroupName
	 */
	public void setServiceGroupName(String serviceGroupName) {
		if (serviceGroupName == null || ("").equals(serviceGroupName)) {
			throw new IllegalArgumentException("Invalid service group name.");
		}
		this.serviceGroupName = serviceGroupName;
	}

	/**
	 * a method to set the incident counter
	 */
	public void setIncidentCounter() {
		int lastIncidnet = incident.size() - 1;
		int id = incident.get(lastIncidnet).getId();
		Incident.setCounter(id);
	}

	/**
	 * a method to add incdient
	 * 
	 * @param incidents a representation of an incident
	 */
	public void addIncident(Incident incidents) {
		for (int i = 0; i < incident.size(); i++) {
			if (incident.get(i).getId() == incidents.getId()) {
				throw new IllegalArgumentException("Incident cannot be created.");
			} // sort
		}
		incident.add(incidents);

		Collections.sort(incident, new Comparator<Incident>() {
			@Override
			public int compare(Incident i1, Incident i2) {
				return i1.getId() - i2.getId();
			}
		});
	}

	/**
	 * a method that returns incdeints
	 * 
	 * @return a list of incidents
	 */
	public ArrayList<Incident> getIncidents() {
		return incident;
	}

	/**
	 * a method that retrives incidents with the given index nmber
	 * 
	 * @param idx an integer referance of an incident
	 * @return an incident
	 */
	public Incident getIncidentById(int id) {
		if (id > 0) {
			for (int i = 0; i < incident.size(); i++) {
				if (id == incident.get(i).getId()) {
					return incident.get(i);
				}

			}
		}
		return null;
	}

	/**
	 * a method that excetues commands
	 * 
	 * @param id      a unique id if incident
	 * @param command is a command for incident
	 */
	public void executeCommand(int id, Command command) {
		for (int i = 0; i < incident.size(); i++) {
			if (incident.get(i).getId() == id) {
				incident.get(i).update(command);
			}
		}

	}

	/**
	 * A method to delete an incident by the passed parameter
	 * 
	 * @param id is an integer reference of incident
	 */
	public void deleteIncidentById(int id) {
		for (int i = 0; i < incident.size(); i++) {
			if (id == incident.get(i).getId()) {
				incident.remove(i);
			}

		}

	}

}
