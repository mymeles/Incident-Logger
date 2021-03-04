/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * A class that represents a Resolved incident of the service wolf and implemented in the Interface Incident State
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
	 */
	public void updateState(Command command) {
		// impement update state
	}

	/**
	 * A method that retrives the incidents state name
	 */
	public String getStateName() {
		return null;

	}

}
