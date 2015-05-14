package com.hellhound.Resources;

import java.util.HashMap;

public class CommandWords {
	private HashMap<String,CommandWord> validCommands;
	
	public CommandWords() {
		validCommands = new HashMap<>();
		for(CommandWord command : CommandWord.values()) {
			if(command != CommandWord.UNKNOWN) {
				validCommands.put(command.toString(),command);
			}
		}
	}
	
	public CommandWord getCommandWord(String commandWord) {
		CommandWord command = validCommands.get(commandWord);
		if(command != null) {
			return command;
		}
		else {
			return CommandWord.UNKNOWN;
		}
	}
	
	public boolean isCommand(String command) {
		return validCommands.containsKey(command);
	}
	
	public String showAll() {
		String commandWords = "";
		for(String command : validCommands.keySet()) {
			commandWords += (command + " ");
		}
		return commandWords;
	}
}
