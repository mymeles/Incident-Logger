package edu.ncsu.csc216.service_wolf.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A class to write service group into a file
 * 
 * @author meles
 *
 */
public class ServiceGroupWriter {

	/**
	 * A default constructor for ServiceGroupWriter
	 */
	public void ervieGroupWriter() {
		//
	}
	
	/**
	 * Writes the given service group to the given file location
	 * 
	 * @param fileName     and string that holds the loaction of the file that the
	 *                     service group is written
	 * @param serviceGroup a list of service groups that are written in the file
	 *                     that is given
	 * @throws IOExceptionIOException if Servicegroup can't not be written to the
	 *                                file given
	 */
	public static void writeServiceGroupsToFile(String fileName, ArrayList<ServiceGroup> serviceGroup) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(new File(fileName));
			for (int i = 0; i < serviceGroup.size(); i++) {
				fileWriter.println(serviceGroup.get(i).toString().trim());
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			 throw new IllegalArgumentException("Unable to save file.");
		}
	}

}
