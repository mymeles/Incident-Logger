/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * A class that represetns servicegroup that inclides a list of incidents.
 * 
 * @author Meles
 *
 */
public class ServiceGroup {

	/**
	 * A string representaion of service group name.
	 */
	private String serviceGroupName;

	/**
	 * A List of incidents called incident.
	 */
	ArrayList<Incident> incident;

	/**
	 * A method to construct s serviceGroup with a passed name pararmnter and an
	 * arraylist of incdients
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
	 * a method to set the incident counter, if the incidnets size is zero it will
	 * set the counter by default to "1". other wise it will set the counter one
	 * higher the the last incident in the list.
	 */
	public void setIncidentCounter() {
		if (incident.size() == 0) {
			Incident.setCounter(1);
		} else {
			Incident.setCounter(incident.get(incident.size() - 1).getId() + 1);
		}
	}

	/**
	 * A helper method to look for duplicate incidents, returns true if duplicate,
	 * false otherwise
	 * 
	 * @param incidents that are processed for duplicate check
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
	 * A method to add incdient by a sorted order by thier id and after adding the
	 * incidents the counter is incremnted so the it is ready for the next id to be
	 * added.
	 * 
	 * @param incidents a representation of an incident
	 * 
	 * @throws IllegalArgumentException if passed incidents to be added are
	 *                                  duplicates by thier id's
	 */
	public void addIncident(Incident incidents) {
		if (helper(incidents))
			throw new IllegalArgumentException("Incident cannot be created.");
		if (incident.size() == 0) {
			incident.add(incidents);
			setIncidentCounter();
			return;
		}
		for (int i = 0; i < incident.size(); i++) {
			if (incidents.getId() < incident.get(i).getId()) {
				incident.add(i, incidents);
				setIncidentCounter();
				return;
			}
		}
		incident.add(incidents);
	}

	/**
	 * A method that returns incdeints as an ArrayList
	 * 
	 * @return an arraylist of incidents
	 */
	public ArrayList<Incident> getIncidents() {
		return incident;
	}

	/**
	 * a method that retrives incidents with the given index number, otherwise it
	 * would just retrun null.
	 * 
	 * @param id an integer referance of an incident
	 * @return an incident or null if the incidents can not be found.
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
	 * A methods that exceutes commands on incidents by lokking for them by thier
	 * Id's.
	 * 
	 * @param id      An id that represents the wanted incidents.
	 * @param command is a command for incident
	 * 
	 * @throws UnsupportedOperationException if the command issued is not supported
	 *                                       by the incidnets states
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
	 * A method to delete an incident by the passed parameter(incidnets id)
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

	/**
	 * The toString method is overriden so the required String format is returned
	 * when we exporte the class onto a txt file.
	 * 
	 * @return a string representation of the class ServiceGroup
	 */
	@Override
	public String toString() {
		String inci = "";
		for (int i = 0; i < incident.size(); i++) {
			inci = inci + incident.get(i).toString();
		}
		return "# " + serviceGroupName + "\n" + inci;
	}

}
