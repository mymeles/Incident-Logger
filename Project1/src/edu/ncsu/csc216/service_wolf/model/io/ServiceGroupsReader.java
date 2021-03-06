/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * A class to read service groups
 * 
 * @author meles
 *
 */
public class ServiceGroupsReader {

	/**
	 * A method that is used to read service groups from a file along with thier
	 * incidents. if any of the files are corrupt or invalid other than empty it
	 * will return an empty ArrayList
	 * 
	 * @param fileName a string represenaton of the file that is reade
	 * @return returns an arraylist os service groups
	 * 
	 * @throws IllegalArgumentException if the file is not read
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) {
		ArrayList<ServiceGroup> serviceg = new ArrayList<ServiceGroup>();

		String str = "";
		try {
			Scanner fileReader = new Scanner(new FileInputStream(fileName));

			while (fileReader.hasNext()) {

				str += fileReader.nextLine() + "\n";
			}

			if (str.trim().charAt(0) != '#') {
				return serviceg;
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}

		Scanner scan = new Scanner(str);
		scan.useDelimiter("\\r?\\n?[#]");

		while (scan.hasNext()) {
			try {
				//
				String service = scan.next();
				ServiceGroup sg1 = processServiceGroup(service);

				serviceg.add(sg1);
			} catch (IllegalArgumentException e) {
				continue;
			}

		}
		scan.close();

		return serviceg;

	}

	/**
	 * Private method for processing the service groups found in the file. if isn't
	 * able to processed then null is returned.
	 * 
	 * @param service of each service group found in the file
	 * @return the ServiceGroup object based on file contents
	 * 
	 * @throws IllegalArgumentException if the constructed serviceGroup is invalid.
	 */
	private static ServiceGroup processServiceGroup(String service) {
		try {
			ServiceGroup sg = null;
			Scanner scan = new Scanner(service);
			scan.useDelimiter("\\r?\\n?[*]");
			String sn = scan.nextLine();
			sg = new ServiceGroup(sn.trim());

			while (scan.hasNext()) {
				try {
					//
					String stringIncident = scan.next();
					Incident in1 = processIncident(stringIncident);
					sg.addIncident(in1);
				} catch (IllegalArgumentException e) {
					//
				}

			}
			scan.close();
			if (sg.getIncidents().size() == 0)
				throw new IllegalArgumentException("Unable to load file.");

			return sg;

		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid service group");
		}

	}

	/**
	 * Private method for processing the contents of the file within the found
	 * service group. Each group should have one or more incidents assigned to them.
	 * 
	 * @param incidentL of the incident being read from the file
	 * @return the Incident object that is owned by the service group
	 * 
	 * @throws IllegalArgumentException if the incident isn't created 
	 */
	private static Incident processIncident(String incidentL) {

		try {
			Scanner scan = new Scanner(incidentL);
			scan.useDelimiter("\\r?\\n?[-]");
			String inci = scan.next();

			Scanner s = new Scanner(inci.trim());
			s.useDelimiter(",");
			int id = s.nextInt();

			String state = s.next();
			String title = s.next();
			String caller = s.next();
			int reopen = s.nextInt();
			String owner = s.next();
			String status = s.next();

			ArrayList<String> message = new ArrayList<String>();
			while (scan.hasNext()) {

				String line = scan.next().trim();
				String messageS = line.substring(0);
				message.add(messageS);
			}
			scan.close();

			Incident i = new Incident(id, state, title, caller, reopen, owner, status, message);
			return i;
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid incident.");
		}
	}
}