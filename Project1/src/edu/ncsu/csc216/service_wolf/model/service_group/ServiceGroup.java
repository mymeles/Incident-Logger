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
	ArrayList<Incident> incident;

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
		if (serviceGroupName == null) {
			return null;
		}
		return serviceGroupName;
	}

	/**
	 * a method that sets the service group name from the givin parameter.
	 * 
	 * @param serviceGroupName the serviceGroupName to set -setServiceGroupName
	 */
	public void setServiceGroupName(String serviceGroupName) {
		if (serviceGroupName == null || "".equals(serviceGroupName)) {
			throw new IllegalArgumentException("Invalid service group name.");
		}
		this.serviceGroupName = serviceGroupName;
	}

	/**
	 * a method to set the incident counter
	 */
	public void setIncidentCounter() {
		if (incident.size() == 0) {
			Incident.setCounter(1);
		} else {
			Incident.setCounter(incident.get(incident.size() - 1).getId() + 1);
		}
	}

	/**
	 * 
	 * @param incidents is
	 * @return a boolean
	 */
	private boolean helper(Incident incidents) {
		for (int i = 0; i < incident.size(); i++) {
			if (incident.get(i).getId() == incidents.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * a method to add incdient
	 * 
	 * @param incidents a representation of an incident
	 */
	public void addIncident(Incident incidents) {
		if (incident.size() < 0 || helper(incidents))
			throw new IllegalArgumentException("Incident cannot be created.");
		// add it at thge correct place
		incident.add(incidents); // sort it
		setIncidentCounter(); 

//		// compring true and false staments to determine adding incidnet
//		switch ((incident.size() > 0) + "-" + helper(incidents)) { 
//		case "false-true":
//		case "false-false":
//			incident.add(incidents);
//			setIncidentCounter();
//			break;
//		case "true-false":
//			incident.add(incidents);
//			setIncidentCounter();
//			break; 
//		default:
//			throw new IllegalArgumentException("Incident cannot be created.");
//		}
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
	 * @return an arraylist of incidents
	 */
	public ArrayList<Incident> getIncidents() {
		return incident;
	}

	/**
	 * a method that retrives incidents with the given index nmber
	 * 
	 * @param id an integer referance of an incident
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
		try {
			for (int i = 0; i < incident.size(); i++) {
				if (incident.get(i).getId() == id) {
					incident.get(i).update(command);
				}
			}
		} catch (UnsupportedOperationException e) {
			throw new UnsupportedOperationException();

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

	@Override
	public String toString() {
		String inci = "";
		for (int i = 0; i < incident.size(); i++) {
			inci = inci + incident.get(i).toString();
		}
		return "# " + serviceGroupName + "\n" + inci;
	}

}
