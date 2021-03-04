/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.command;

/**
 * @author meles
 *
 */
public class Command {
	public enum CommandValue {
		ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL;

	}

	/**
	 * 
	 */
	private String commandInformation;

	/**
	 * 
	 */
	private String commandMessage;

	/**
	 * 
	 */
	CommandValue command;

	/**
	 * 
	 * @param command
	 * @param commandInformation
	 * @param commandMessage
	 */
	public Command(CommandValue command, String commandInformation, String commandMessage) {

	}

	public CommandValue getCommand() {
		return command;
	}

	/**
	 * @return the commandInformation
	 */
	public String getCommandInformation() {
		return commandInformation;
	}

	/**
	 * @return the commandMessage
	 */
	public String getCommandMessage() {
		return commandMessage;
	}

}
