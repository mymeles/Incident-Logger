/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

/**
 * A class that represents an incident that is Mannaged
 * 
 * @author meles
 *
 */
public class Incident {
	/**
	 * An integer representing unique Incident Id
	 */
	private int incidentid;
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
	 * An Incident State that keeps track of the incidents statet
	 */
	private IncidentState currentState;

	/**
	 * An incident state represenating cancneled state
	 */
	private final IncidentState canceledState = new CanceledState();

	/**
	 * An inscident state representing onhold state
	 */
	private final IncidentState onHoldState = new OnHoldState();

	/**
	 * An incident state representing resolved state
	 */
	private final IncidentState resolvedState = new ResolvedState();

	/**
	 * An incidnet state representing new state
	 */
	private final IncidentState newState = new NewState();

	/**
	 * An incident state representing inprogress state
	 */
	private final IncidentState inProgressState = new InProgressState();

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
	 * Constructs a Incident from the provided title, caller, and message.The
	 * incident id field is set to the value stored in the incident counter. The
	 * counter is then incremented using the inceidnt increment counter. A new
	 * incident starts in a NEW state and the owner is set to UNOWNED and the status
	 * dewtails are set to no status and lstl;y the message is added in the incident
	 * log. *
	 * 
	 * @param title   The title of the incident
	 * @param caller  the name of the incident caller
	 * @param message the message of the incident
	 * 
	 * @throws IAE If any of the given parameters are null or empty string.
	 */
	public Incident(String title, String caller, String message) {

		setId(Incident.counter);
		Incident.incrementCounter();
		setTitle(title);
		setCaller(caller);
		setOwner(UNOWNED);
		setStatusDetails(NO_STATUS);
		setState(NEW_NAME);
		addMessageToIncidentLog(message);

	}

	/**
	 * Constructs a Incident from the provided title, caller, and message.The
	 * incident id field is set to the value stored in the incident counter. The
	 * counter is then incremented using the inceidnt increment counter. A new
	 * incident starts in a NEW state and the owner is set to UNOWNED and the status
	 * dewtails are set to no status and lstl;y the message is added in the incident
	 * log.
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
	 * 
	 * 
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount, String owner,
			String statusDetails, ArrayList<String> incidentLog) {

		setId(id);
		setTitle(title);
		setCaller(caller);
		setReopenCount(reopenCount);
		setOwner(owner);
		setStatusDetails(statusDetails);
		this.incidentLog = incidentLog;
		setState(state);
	}

	/**
	 * Retrives the unique vallue of incident id
	 * 
	 * @return an integer of Id
	 */
	public int getId() {
		return incidentid;

	}

	/**
	 * sets the id from the passed parameter if the id is greater than the counter
	 * then it sets the counter to one greater than the ID.
	 *
	 * 
	 * @param id the incident id to set
	 */
	private void setId(int id) {

		if (id < 0) {
			throw new IllegalArgumentException("Incident cannot br created.");
		}
		this.incidentid = id;

		if (id > counter) {
			setCounter(id + 1);
		}

	}

	/**
	 * returns the incident state
	 * 
	 * @return a string value of state
	 */
	public String getState() {
		return currentState.getStateName();
	}

	// helper method for determinign the incident state
	private void createState(boolean condition, IncidentState state) {
		if (condition) {
			this.currentState = state;
		} else {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
	}

	/**
	 * sets the incidets state from the passesd parameter
	 * 
	 * @param state the incident state to set
	 */
	private void setState(String state) {
		switch(state) {
		case NEW_NAME:
			createState(owner.equals(UNOWNED) && statusDetails.equals(NO_STATUS), newState);
			break;
		case IN_PROGRESS_NAME:
			createState(!owner.equals(UNOWNED) && statusDetails.equals(NO_STATUS), inProgressState);
			break;
		case ON_HOLD_NAME:
			createState(!(owner).equals(UNOWNED)
					&& (((statusDetails).equals(HOLD_AWAITING_CALLER)) || ((statusDetails).equals(HOLD_AWAITING_CHANGE))
							|| ((statusDetails).equals(HOLD_AWAITING_VENDOR))),
					inProgressState);
			break;
		case RESOLVED_NAME:
			createState(!(owner).equals(UNOWNED) && (((statusDetails).equals(RESOLUTION_PERMANENTLY_SOLVED))
					|| ((statusDetails).equals(RESOLUTION_WORKAROUND))
					|| ((statusDetails).equals(RESOLUTION_CALLER_CLOSED))), resolvedState);
			break;
		case CANCELED_NAME:
			createState((owner).equals(UNOWNED) && ((statusDetails).equals(CANCELLATION_DUPLICATE))
					|| ((statusDetails).equals(CANCELLATION_UNNECESSARY))
					|| ((statusDetails).equals(CANCELLATION_NOT_AN_INCIDENT)), canceledState);
			break;
		default:
			throw new IllegalArgumentException("Incident cannot be created.");
		}

	}

	/**
	 * returns a string value of the incidents title
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * sets the incidets titke from the passesd parameter
	 * 
	 * @param title the title to set
	 * 
	 * @throws if title is empty or
	 */
	private void setTitle(String title) {
		if (title == null || ("").equals(title)) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
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
	 * sets the incidets caller from the passesd paramter
	 * 
	 * @param caller the caller to set
	 */
	private void setCaller(String caller) {
		if (caller == null || ("").equals(caller)) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
		this.caller = caller;
	}

	/**
	 * retrives the Reopen count of the incident
	 * 
	 * @return the reopenCount
	 */
	public int getReopenCount() {
		return reopenCount;
	}

	/**
	 * sets the incidets reopen count from the passesd paramter
	 * 
	 * @param reopenCount the reopenCount to set
	 */
	private void setReopenCount(int reopenCount) {
		if (reopenCount < 0) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
		this.reopenCount = reopenCount;
	}

	/**
	 * returns the Owner of the incident resolver
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * sets the incidets relover owner from the passed parameter
	 * 
	 * @param owner the owner to set
	 * 
	 * @throws IAE stating "Incident cannot be created" if the title is empty or
	 *             null
	 */
	private void setOwner(String owner) {
		if (owner == null || ("").equals(owner)) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
		this.owner = owner;
	}

	/**
	 * retrvies the status detail of the incident
	 * 
	 * @return the statusDetails
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * sets the status detatila from the passsed parameter
	 * 
	 * @param statusDetails the statusDetails to set
	 * 
	 * @throws IAE stating "Incident cannot be created" if the status detail is
	 *             empty or null
	 */
	private void setStatusDetails(String statusDetails) {
		if (statusDetails == null || ("").equals(statusDetails)) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
		this.statusDetails = statusDetails;
	}

	/**
	 * This method add messages to the inciodent log
	 * 
	 * @param message to set the message in the incident log
	 * @return an integer reference of the log
	 */
	private int addMessageToIncidentLog(String message) {
		if (message == null || ("").equals(message)) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}
		incidentLog.add(message);

		return incidentLog.size();
	}

	/**
	 * a method to incremet when an incident is added
	 */
	public static void incrementCounter() {
		counter++;
	}

	/**
	 * sets the incidet counter from the passesd paramter
	 * 
	 * @param id the counter to set
	 */
	public static void setCounter(int id) {
		counter = id;
	}

	/**
	 * retrives the incident log message
	 * 
	 * @return the incidentLog
	 */
	public String getIncidentLogMessages() {

		String logMessages = "";

		for (int i = 0; i < incidentLog.size(); i++) {
			logMessages = logMessages + "- " + incidentLog.get(i) + "\n";
		}
		return logMessages;
	}

	// int id, String state, String title, String caller, int reopenCount, String
	// owner,
	// String statusDetails, ArrayList<String> incidentLog) {
	@Override
	public String toString() {
		return "* " + incidentid + "," + currentState.getStateName() + "," + title + "," + caller + "," + reopenCount
				+ "," + owner + "," + statusDetails + "\n" + getIncidentLogMessages();

	}

	/**
	 * a method delegating to the current state’s updateState(Command) method.
	 * 
	 * @param command a Command
	 * 
	 * @throws UnsupportedOperationException if an invalid command is passed
	 */
	public void update(Command command) {
		currentState.updateState(command);
		addMessageToIncidentLog(command.getCommandMessage());
	}

	/**
	 * Interface for states in the Incident State Pattern. All concrete incident
	 * states must implement the IncidentState interface. The IncidentState
	 * interface should be a private interface of the Incident class.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
	 */

	private interface IncidentState {

		/**
		 * Update the Incident based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the Incident's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		void updateState(Command command);

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		String getStateName();

	}

	/**
	 * A class that represents a New incident of the service wolf and implemented in
	 * the Interface Incident State
	 * 
	 * @author meles
	 *
	 */
	public class NewState implements IncidentState {

		/**
		 * Constructs New State so it is implemneted in Incident interface
		 */
		private NewState() {

		}

		/**
		 * A method that updates the Incident state by passing through command
		 *
		 * @param command is a Command
		 */
		public void updateState(Command command) {

			switch (command.getCommand()) {
			case ASSIGN:
				setStatusDetails(command.getCommandInformation());
				setOwner(command.getCommandInformation()); 
				currentState = inProgressState;
				break;
			case CANCEL: 
				setStatusDetails(command.getCommandInformation());
				setOwner(UNOWNED);
				currentState = canceledState;
				break; 
			default:
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * A method that retrives the incidents state name
		 * 
		 * @return a string value of state name
		 */
		public String getStateName() {
			return NEW_NAME;

		}

	}

	/**
	 * A class that represents a InProgress incident of the service wolf and
	 * implemented in the Interface Incident State
	 * 
	 * @author meles
	 *
	 */
	public class InProgressState implements IncidentState {

		/**
		 * Constructs InProgress State so it is implemneted in Incident interface
		 */
		private InProgressState() {

		}

		/**
		 * A method that updates the Incident state by passing through command
		 * 
		 * @param command is a Command
		 */
		public void updateState(Command command) {
			switch (command.getCommand()) {
			case ASSIGN:
				setStatusDetails(command.getCommandInformation());
				currentState = inProgressState;
				break;
			case HOLD:
				setStatusDetails(command.getCommandInformation());
				currentState = onHoldState;
				break;
			case RESOLVE:
				setStatusDetails(command.getCommandInformation());
				currentState = resolvedState;
				break;
			case CANCEL:
				setStatusDetails(command.getCommandInformation());
				setCaller(UNOWNED);
				currentState = canceledState;
				break;
			default:
				throw new UnsupportedOperationException();
			}

		}

		/**
		 * A method that retrives the incidents state name
		 * 
		 * @return a string value of the incidents state name
		 */
		public String getStateName() {
			return IN_PROGRESS_NAME;

		}
	}

	/**
	 * A class that represents a OnHold incident of the service wolf and implemented
	 * in the Interface Incident State
	 * 
	 * @author meles
	 *
	 */
	public class OnHoldState implements IncidentState {

		/**
		 * Constructs OnHold State so it is implemneted in Incident interface
		 */
		private OnHoldState() {

		}

		/**
		 * A method that updates the Incident state by passing through command
		 * 
		 * @param command is a Command
		 */
		public void updateState(Command command) {
			switch (command.getCommand()) {
			case INVESTIGATE:
				setStatusDetails(NO_STATUS);
				currentState = inProgressState;
			default: 
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * A method that retrives the incidents state name
		 * 
		 * @return a string value of the incidents state name
		 */
		public String getStateName() {
			return ON_HOLD_NAME;

		}

	}

	/**
	 * A class that represents a Resolved incident of the service wolf and
	 * implemented in the Interface Incident State
	 * 
	 * @author meles
	 *
	 */
	public class ResolvedState implements IncidentState {
		/**
		 * Constructs Resolved State so it is implemneted in Incident interface
		 */
		private ResolvedState() {

		}

		/**
		 * A method that updates the Incident state by passing through command
		 * 
		 * @param command is a Command
		 */
		public void updateState(Command command) {
			switch (command.getCommand()) {
			case REOPEN: 
				setStatusDetails(NO_STATUS);
				reopenCount++;
				currentState = inProgressState;
			case CANCEL:
				setStatusDetails(command.getCommandInformation());
				setOwner(UNOWNED);
				currentState = canceledState;
			default:
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * A method that retrives the incidents state name
		 * 
		 * @return a string value of the incidents state name
		 */
		public String getStateName() {
			// TODO Auto-generated method stub
			return RESOLVED_NAME;
		}

	}

	/**
	 * A class that represents a cancled incident of the service wolf and
	 * implemented in the Interface Incident State
	 * 
	 * @author meles
	 *
	 */
	public class CanceledState implements IncidentState {

		/**
		 * Constructs cancled state so it is implemneted in Incident interface
		 */
		private CanceledState() {

		}

		/**
		 * A method that updates the Incident state by passing through command
		 * 
		 * @param command a command that updates the state
		 *
		 */
		public void updateState(Command command) {

		}

		/**
		 * A method that retrives the incidents state name
		 * 
		 * @return a string value of the incidents state name
		 */
		public String getStateName() {
			return CANCELED_NAME;

		}
	}

}
