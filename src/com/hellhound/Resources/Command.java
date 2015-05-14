package com.hellhound.Resources;

public class Command {
	private String secondWord;
	
	public Command(String secondWord) {
		this.secondWord = secondWord;
	}
	
	public boolean hasSecondWord() {
		return(secondWord!=null);
	}
	
	public String getSecondWord() {
		return secondWord;
	}
}
