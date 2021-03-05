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
	 * A class within Command class that holds a list a possible command values
	 * the incident state.
	 *
	 * @author meles meles
	 */
	public enum CommandValue { ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL }

		/**
		 * assign value 
		 */
		public static final CommandValue ASSIGN = null; 
		/**
		 * Hold value 
		 */
		public static final  CommandValue HOLD = null; 
		
		/**
		 * investigate value 
		 */
		public static final CommandValue INVESTIGATE = null;
	
		/**
		 * Resolve value 
		 */
		public static final CommandValue RESOLVE = null;
		
		/**
		 * reopen value
		 */
		public static final CommandValue REOPEN = null; 
		
		/**
		 * cancel value 
		 */
		public static final CommandValue CANCEL =  null;


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
	CommandValue command;

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
