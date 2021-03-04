/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * A class that represents a OnHold incident of the service wolf and implemented in the Interface Incident State
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
	 * @param command 
	 */
	public void updateState(Command command) {
		//implement updateState 
	}

	/**
	 * A method that retrives the incidents state name
	 */
	public String getStateName() {
		return null;

	}

}
