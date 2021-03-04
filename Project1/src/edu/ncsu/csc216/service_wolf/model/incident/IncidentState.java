package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * Interface for states in the Incident State Pattern. All concrete incident
 * states must implement the IncidentState interface. The IncidentState
 * interface should be a private interface of the Incident class.
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 */

public interface IncidentState {

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
