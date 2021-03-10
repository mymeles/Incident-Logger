/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.command;

/**
 * A class that causes the State of incident to update.
 * 
 * @author meles meles
 *
 */
public class Command {

	/**
	 * A class within Command class that holds a list a possible command values the
	 * incident state.
	 *
	 * @author meles meles
	 */
	public enum CommandValue { ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL } 

	/**
	 * A String representaion of command inforamtion
	 */
	private String commandInformation;

	/** 
	 * A string represetnation of command message
	 */
	private String commandMessage;

	/**
	 * a Commandvalue called command
	 */
	private CommandValue command;

	/**
	 * A consturctor for command class that is constructors with Command, command
	 * information, and command message. except for command value the rest can be
	 * passed as null.
	 * 
	 * @param command            the command that is passed through
	 * @param commandInformation inforamtion about command
	 * @param commandMessage     a message about the command
	 * 
	 * @throws IAE saying " A Command MUST have a CommandValue." if commandValue is
	 *             null .
	 * @throws IAE saying " A Command MUST have a commandMessage." if commandmessage
	 *             is null or empty.
	 * @throws IAE saying " These commands require an additional piece of
	 *             information." if commandvalue has values but commandinformation
	 *             is null or empty string
	 * @throws IAE saying " These commands do NOT require an additional piece of
	 *             information." if the command value is "INVESTIGATE" and "REOPEN"
	 *             and a non-null commandinforamtion is passed.
	 * 
	 */
	public Command(CommandValue command, String commandInformation, String commandMessage) {

		if (command == null) {
			throw new IllegalArgumentException("A Command MUST have a CommandValue"); 
		} else if (commandMessage == null || ("").equals(commandMessage)) {
			throw new IllegalArgumentException("A Command MUST have a commandMessage");

		} else if (((CommandValue.ASSIGN).equals(command) || (CommandValue.HOLD).equals(command) || (CommandValue.RESOLVE).equals(command) || 
				(CommandValue.CANCEL).equals(command)) && (commandInformation == null || ("").equals(commandMessage))) {
			throw new IllegalArgumentException("These commands require an additional piece of information");
		}

		else if (((CommandValue.INVESTIGATE).equals(command) || (CommandValue.REOPEN).equals(command))
				&& commandInformation != null) {
			throw new IllegalArgumentException("These commands do NOT require an additional piece of information");
		} else {
			this.command = command; 
			this.commandInformation = commandInformation;
			this.commandMessage = commandMessage; 
		} 

	}

	/**
	 * Retrvies comandvalue information
	 * 
	 * @return a commandValue
	 */
	public CommandValue getCommand() {
		return command;
	}

	/**
	 * Retrives command information
	 * 
	 * @return the commandInformation
	 * 
	 */
	public String getCommandInformation() {
		return commandInformation;
	}

	/**
	 * Retrives the command message
	 * 
	 * @return the commandMessage
	 */
	public String getCommandMessage() {
		return commandMessage;
	}

}
