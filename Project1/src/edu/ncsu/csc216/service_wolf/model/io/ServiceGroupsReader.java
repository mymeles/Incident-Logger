/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A Class that reads service groups and incidets from a given file location
 * 
 * @author meles
 *
 */
public class ServiceGroupsReader {

	/**
	 * A method that reads service grou[
	 * 
	 * @param fileName location of the file that is read
	 * @return an array list of service groups
	 * 
	 * @throws FileNotFoundException if the filename is is null or empty or invalid
	 *                               desitination
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) throws FileNotFoundException {

		return null;

	}

	// takes in a string of line and returns a service group
	// used to help the readServiceGroupFile method
	private static ServiceGroup processServiceGroup(String line) {
		// impement service group
		return null;
	}

	// takes in a string of line and returns an incident
	// used to help the readServiceGroupFile method
	private static Incident processIncidnet(String line) {
		// imp[lement process incident
		return null;
	}

}
