/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

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
		// TODO implement inprogress state
	}

	/**
	 * A method that updates the Incident state by passing through command
	 * 
	 * @param command is a Command 
	 */
	public void updateState(Command command) {
		// TODO imp-lement updateState
	}

	/**
	 * A method that retrives the incidents state name
	 * 
	 * @return a string value of the incidents state name
	 */
	public String getStateName() {
		return null;

	}

}
