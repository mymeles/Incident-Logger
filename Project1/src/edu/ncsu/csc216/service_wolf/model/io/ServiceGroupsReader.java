/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Reads the contents of the file to create a sortedList of service groups. Additionally,
 * the class uses markers to delineate the Incidents that are listed under each service
 * group in the specified file.
 * 
 * @author darrengonsalves
 *
 */
public class ServiceGroupsReader {

	/**
	 * Constructs the reader that processes a file into an ArrayList of service groups
	 */
	public ServiceGroupsReader() {
		
	}
	
	/**
	 * Reads the file containing service groups and incidents and creates an ArrayList
	 * of service groups
	 * 
	 * @param fileName of the file to read from
	 * @return an ArrayList of service groups located in the file
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(fileName));
		ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
	    String nextLine = "";
		while (fileReader.hasNextLine()) {
	         nextLine = nextLine.concat(fileReader.nextLine() + "\n");
		}
		Scanner scan = new Scanner(nextLine);
		scan.useDelimiter("\\r?\\n?[#]");
		while(scan.hasNextLine()) {
        	try {
        		String serviceGroupName = scan.nextLine();
        		System.out.print(serviceGroupName);
        		Scanner service = new Scanner(scan.next());
        		scan.useDelimiter("\\r?\\n?[*]");
        		ServiceGroup a1 =processServiceGroup(serviceGroupName);
        		while (service.hasNextLine()) {
        			String incidentName = service.next();
        			System.out.println(incidentName);
        			Incident a = processIncident(incidentName);
        			a1.addIncident(a);
        		}
        		serviceGroups.add(a1);
        	} catch(InputMismatchException e) {
        		fileReader.close();
        		throw new IllegalArgumentException("");
        	} catch(NoSuchElementException e) {
        	throw new IllegalArgumentException("");
        	}
		}
		scan.close();
		return serviceGroups;
	}
	/**
	 * Private method for processing the service groups found in the file
	 * @param serviceGroupName of each service group found in the file
	 * @return the ServiceGroup object based on file contents
	 */
	private static ServiceGroup processServiceGroup(String serviceGroupName) {
		ServiceGroup a = new ServiceGroup(serviceGroupName);
		return a;
	}
	
	/**
	 * Private method for processing the contents of the file within the found 
	 * service group. Each group should have one or more incidents assigned to
	 * them.
	 * 
	 * @param incidentName of the incident being read from the file
	 * @return the Incident object that is owned by the service group
	 */
	private static Incident processIncident(String incidentToken) {
		Scanner scan = new Scanner(incidentToken);

    	scan.useDelimiter(",");
    	try {
    		//scan.hasNext();
    			int incidentId = scan.nextInt();
    			String state = scan.next();
    			String title = scan.next();
    			String caller = scan.next();
    			int reopen = scan.nextInt();
    			String owner = scan.next();
    			String statusDetails = scan.next();
    			ArrayList<String> incidentLog = new ArrayList<String>();
    			scan.useDelimiter("\\r?\\n?[-]");
    			while(scan.hasNext()) {
    				String incidentline = scan.nextLine();
    				System.out.println(incidentline);
    				incidentLog.add(incidentline);
    			}
    			scan.close();
    			return new Incident(incidentId, state, title, caller, reopen, owner,
    								statusDetails, incidentLog);
    	} catch(InputMismatchException e) {
    		scan.close();
    		throw new IllegalArgumentException("");
    	} catch(NoSuchElementException e) {
    	throw new IllegalArgumentException("");
    	}
	}
}