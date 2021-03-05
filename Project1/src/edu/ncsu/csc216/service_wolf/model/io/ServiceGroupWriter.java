package edu.ncsu.csc216.service_wolf.model.io;

import java.io.IOException;
import java.util.List;


import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 *  A class to write service group into a file 
 * @author meles
 *
 */
public class ServiceGroupWriter {

	/**
	 * Writes the given service group to the given file location
	 * 
	 * @param fileName     and string that holds the loaction of the file that the
	 *                     service group is written
	 * @param servicegroup a list of service groups that are written in the file
	 *                     that is given
	 * 
	 * @throws IOException if Servicegroup can't not be written to the file given
	 */
	public static void writeServiceGroupsToFile(String fileName, List<ServiceGroup> servicegroup) {
		// implement write service groupssTo File
	}

}
