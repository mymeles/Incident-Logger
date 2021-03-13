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
 * @author meles
 *
 */
public class ServiceGroupsReader {

	/**
	 * A method that is used to read service groups from a file along with thier incidents 
	 * 
	 * @param fileName a string represenaton of the file that is reade
	 * @return returns an arraylist os service groups 
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) {
		ArrayList<ServiceGroup> serviceg = new ArrayList<ServiceGroup>();
				
		try {
			Scanner fileReader = new Scanner(new FileInputStream(fileName)); // Create
			String str = "";
			
			while(fileReader.hasNext()) {
				str += fileReader.nextLine() + "\n";
			}
			
			Scanner scan = new Scanner(str);
			scan.useDelimiter("\\r?\\n?[#]");
//		    System.out.println("testig  : " + scan.nextLine());
//		    System.out.println("testig -----------------");
//		    System.out.println("testig  : " + scan.nextLine());
//		    System.out.println("testig -----------------");
			while (scan.hasNext()) {
				String service = scan.next();
				//System.out.println("testing name--------- :" + service); 
				ServiceGroup sg1 = processServiceGroup(service);
				serviceg.add(sg1);
				
			} scan.close();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 
			
		return serviceg;

	}

	/**
	 * Private method for processing the service groups found in the file
	 * 
	 * @param serviceGroupName of each service group found in the file
	 * @return the ServiceGroup object based on file contents
	 */
	private static ServiceGroup processServiceGroup(String service) {
		
		Scanner scan = new Scanner(service);
		scan.useDelimiter("\\r?\\n?[*]");
		
		String sn = scan.next();
		//System.out.println("testing group name: " + sn);
			
		ServiceGroup sg = new ServiceGroup(sn.trim()); 
		
		// throw an error if the file is mis formated  
		while(scan.hasNext()) {
			
			String stringIncident = scan.next();
			//System.out.println("testing incidet: " + stringIncident);
			Incident in1 = processIncident(stringIncident);
			sg.addIncident(in1);
		} scan.close();
			
		return sg;

	}

	/** 
	 * Private method for processing the contents of the file within the found
	 * service group. Each group should have one or more incidents assigned to them.
	 * 
	 * @param incidentL of the incident being read from the file
	 * @return the Incident object that is owned by the service group
	 */
	private static Incident processIncident(String incidentL) {
		
		//System.out.println("Testing incident at process  " + incidentL);
		///System.out.println("Testing incident at process: " + incidentL);
		Scanner scan = new Scanner(incidentL);
		scan.useDelimiter("\\r?\\n?[-]");
		String inci = scan.next();
		//System.out.println("Testing incident at process line: " + inci);

		Scanner s = new Scanner(inci.trim()); 
	    s.useDelimiter(","); 
	    // add accrdingly
		int id = s.nextInt(); 
		
		String state = s.next();
		//System.out.println("lllll " + state); 
		String title = s.next();
		String caller = s.next(); 
		int reopen = s.nextInt(); 
		String owner = s.next();
		String status = s.next();
			
		ArrayList<String> message = new ArrayList<String>();
		while(scan.hasNext()) {
			String line = scan.next();
			String messageS = line.substring(2);
		//System.out.println("testing message lines: " + line);
			message.add(messageS);
		} scan.close();
			

		Incident i = new Incident(id, state, title, caller, reopen, owner, status, message);
		
		return i;
	}
}