/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * @author meles
 *
 */
public class ServiceWolfManager {

	/**
	 * 
	 */
	private ServiceWolfManager() {

	}

	/**
	 * 
	 */
	private static ServiceWolfManager getinstance() {
		return null;
	}

	public static ServiceWolfManager getInstance() {
		return null;
	}

	/**
	 * 
	 * @param fileName
	 */
	public void saveToFile(String fileName) {
		// implement save to file
	}

	/**
	 * 
	 * @param fileName
	 */
	public void loadFromFile(String fileName) {
		// impements load from filke
	}

	/**
	 * 
	 * @return
	 */
	public String[][] getIncidentsAsArray() {
		return null;
	}

	public Incident getIncidentById(int id) {
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

	/**
	 * 
	 * @param string1
	 * @param string2
	 * @param string3
	 */
	public void addIncidentToServiceGroup(String string1, String string2, String string3) {
		// impelement add incident to service group
	}

	/**
	 * 
	 * @param serviceGroupName
	 */
	public void loadServiceGroup(String serviceGroupName) {
		// implement load service group
	}

	/**
	 * 
	 * @return
	 */
	public String getServiceGroupName() {
		return null;
	}

	/**
	 * 
	 * @return a single array of service Group list
	 */
	public String[] getServiceGroupList() {
		return null;
	}

	/**
	 * 
	 */
	public void clearServiceGroups() {
		// implement clear service groups
	}

	/**
	 * 
	 * @param updateName
	 */
	public void editServiceGroup(String updateName) {
		// impement edit service groups
	}

	/**
	 * 
	 * @param servicegroup
	 */
	private void addServiceGroupToListByName(ServiceGroup servicegroup) {

	}

	/**
	 * 
	 * @param serviceGroupName
	 */
	public void addServiceGroup(String serviceGroupName) {
		// impement add service group
	}

	/**
	 * 
	 * @param sgName
	 */
	private void checkDuplicateServiceName(String sgName) {
		// impement check duplicate
	}

	/**
	 * 
	 */
	public void deleteServiceGroup() {
		// implement check duplicate
	}

	/**
	 * 
	 */
	protected void resetManager() {
		// implement reset manager
	}

}
