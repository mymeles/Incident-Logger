/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * 
 * @author meles
 *
 */
public class Incident {
	/**
	 * An integer representing unique Incident Id
	 */

	private int incidentId;
	/**
	 * A string representation of incident title
	 */
	private String title;

	/**
	 * A String representation of an incident caller
	 */
	private String caller;

	/**
	 * An integer representing the ntimes incdients are reopened
	 */
	private int reopenCount;

	/**
	 * A string representation of the user who owns and is responsible for the
	 * incident
	 */
	private String owner;

	/**
	 * A string representation of incident status details
	 */
	private String statusDetails;

	/**
	 * An ArrayList representation of incident logs in String form
	 */
	ArrayList<String> incidentLog = new ArrayList<String>();

	/**
	 * A constant string for the new state’s name with the value “New”
	 */
	public final static String NEW_NAME = "New";

	/**
	 * A constant string for the in progress state’s name with the value “In
	 * Progress”.
	 */
	public final static String IN_PROGRESS_NAME = "In Progress";

	/**
	 * A constant string for the on hold state’s name with the value “On Hold”.
	 */
	public final static String ON_HOLD_NAME = "On Hold";

	/**
	 * A constant string for the resolved state’s name with the value “Resolved”.
	 */
	public final static String RESOLVED_NAME = "Resolved";

	/**
	 * A constant string for the canceled state’s name with the value “Canceled”.
	 */
	public final static String CANCELED_NAME = "Canceled";

	/**
	 * A constant string for the priority of “Awaiting Caller”.
	 */
	public final static String HOLD_AWAITING_CALLER = "Awaiting Caller";

	/**
	 * A constant string for the priority of “Awaiting Change”
	 */
	public final static String HOLD_AWAITING_CHANGE = "Awaiting Change";

	/**
	 * A constant string for the priority of “Awaiting Vendor”.
	 */
	public final static String HOLD_AWAITING_VENDOR = "Awaiting Vendor";

	/**
	 * A constant string for the resolution reason of “Permanently Solved”.
	 */
	public final static String RESOLUTION_PERMANENTLY_SOLVED = "Permanently Solved";

	/**
	 * A constant string for the resolution reason of “Workaround
	 */
	public final static String RESOLUTION_WORKAROUND = "Workaround";

	/**
	 * A constant string for the resolution reason of “Caller Closed”.
	 */
	public final static String RESOLUTION_CALLER_CLOSED = "Caller Closed";

	/**
	 * A constant string for the cancellation reason of “Duplicate”.
	 */
	public final static String CANCELLATION_DUPLICATE = "Duplicate";

	/**
	 * A constant string for the cancellation reason of “Unnecessary”.
	 */
	public final static String CANCELLATION_UNNECESSARY = "Unnecessary";

	/**
	 * A constant string for the cancellation reason of “Not an Incident”.
	 */
	public final static String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";

	/**
	 * A constant string for the cancellation reason of “Caller Cancelled”.
	 */
	public final static String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";

	/**
	 * A constant string that represents an unowned incident.
	 */
	public final static String UNOWNED = "Unowned";

	/**
	 * A constant string that represents an incident with no status reasons.
	 */
	public final static String NO_STATUS = "No Status";

	/**
	 * Counter for incident
	 */
	private static int counter = 0;

	/**
	 * Constructs a Incident from the provided title, caller, and message.
	 * 
	 * @param title   The title of the incident
	 * @param caller  the name of the incident caller
	 * @param message the message of the incident
	 * 
	 * @throws IAE If any of the given parameters are null or empty string.
	 */
	public Incident(String title, String caller, String message) {
		// implement incident constructor 
	}

	/**
	 * 
	 * @param id            incidents unique id
	 * @param state         incidents state(inprogress, cancled, onhold, new,
	 *                      cancled)
	 * @param title         The title of the incident
	 * @param caller        caller the name of the incident caller
	 * @param reopenCount   the nummber of times the incident is opened
	 * @param owner         the owner and responsible for resolving the incident
	 * @param statusDetails incidents status details
	 * @param incidentLog   of incident
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount, String owner,
			String statusDetails, ArrayList<String> incidentLog) {
		// impement inciedent constructor
	}

	/**
	 * Retrives the unique vallue of incident id
	 * 
	 * @return an integer of Id
	 */
	public int getId() {
		return incidentId;

	}

	/**
	 * 
	 * @param id the incident id to set
	 */
	private void setId(int id) {
		this.incidentId = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getState() {
		return null;
	}

	/**
	 * 
	 * @param state the incident state to set
	 */
	private void setState(String state) {

	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		this.title = title;
	}

	/**
	 * retrives the caller name
	 * 
	 * @return the caller
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * @param caller the caller to set
	 */
	private void setCaller(String caller) {
		this.caller = caller;
	}

	/**
	 * @return the reopenCount
	 */
	public int getReopenCount() {
		return reopenCount;
	}

	/**
	 * @param reopenCount the reopenCount to set
	 */
	private void setReopenCount(int reopenCount) {
		this.reopenCount = reopenCount;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the statusDetails
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * @param statusDetails the statusDetails to set
	 */
	private void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}

	/**
	 * 
	 * @param message to set the message in the incident log
	 * @return an integer reference of the log
	 */
	private int addMessageToIncidentLog(String message) {
		return 0;
	}

	/**
	 * 
	 */
	public static void incrementCounter() {
		// implement Incerment counter
	}

	/**
	 * 
	 * @param counter the counter to set
	 */
	public static void setCounter(int counter) {
		// implement setCounter
	}

	/**
	 * @return the incidentLog
	 */
	public String getIncidentLogMessages() {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}
	
	/**
	 * 
	 * @param command
	 */
	public void update(Command command) {
		// implement update
	}
	
	

}
