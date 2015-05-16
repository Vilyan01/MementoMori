package com.hellhound.Resources;

public class Command {
	private CommandWord commandWord;
	private String secondWord;
	
	public Command(CommandWord command) {
		this.commandWord = command;
	}
	
	public Command(CommandWord command, String secondWord) {
		this.commandWord = command;
		this.secondWord = secondWord;
	}
	
	public CommandWord getCommandWord() {
		return commandWord;
	}
	
	public boolean hasSecondWord() {
		return(secondWord!=null);
	}
	
	public String getSecondWord() {
		return secondWord;
	}
	
	public boolean isUnknown() {
		return (commandWord == CommandWord.UNKNOWN);
	}
}
