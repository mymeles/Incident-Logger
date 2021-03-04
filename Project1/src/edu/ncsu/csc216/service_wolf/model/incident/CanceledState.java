/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

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
		// TODO impelmet updateState
	}

	/**
	 * A method that retrives the incidents state name
	 * 
	 * @return a string value of state
	 */
	public String getStateName() {
		return null;

	}

}
