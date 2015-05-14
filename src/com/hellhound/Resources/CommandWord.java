package com.hellhound.Resources;

public enum CommandWord {
	HELP("help"), UNKNOWN("?"), MOVE("move"),LOOK("look"),QUIT("quit");
	private String commandString;
	
	CommandWord(String commandString) {
		this.commandString = commandString;
	}
	
	public String toString() {
		return commandString;
	}
}
