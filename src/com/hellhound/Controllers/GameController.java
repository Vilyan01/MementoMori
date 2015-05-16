package com.hellhound.Controllers;

import com.hellhound.Models.*;
import com.hellhound.Resources.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameController {
	public Player p;

	private CommandWords commands;
	private Scanner reader;
	private Scanner tokenizer;
	private BufferedReader br;

	private boolean finished;
	private boolean next;

	public GameController() {
		commands = new CommandWords();
		br = new BufferedReader(new InputStreamReader(System.in));
		finished = false;
		init();
	}

	private void init() {
		p = new Player("Ballsak");

		Room atrium = new Room("Atrium",
				"You see a fuck ton of birds in this shit");
		Room plaza = new Room("Plaza",
				"God damn this place is fucking cold, get back inside.");

		atrium.setSouth(plaza);
		plaza.setNorth(atrium);

		// Start in the atrium
		p.setCurrentRoom(atrium);
	}

	public void start() {
		while (!finished) {
			next = false;
			System.out.println(p.getCurrentRoom().getDescription());
			System.out.println("Exits: " + p.getCurrentRoom().exits());
			System.out.println("Type 'help' to see commands");
			while (!next) {
				System.out.print("> ");
				try {
					String command = br.readLine();
					Command comm = getCommand(command);
					String out = processCommand(comm);
					System.out.println(out);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String showCommands() {
		return commands.showAll();
	}

	private Command getCommand(String commandString) {
		reader = new Scanner(commandString);
		String inputString = null;
		String word1 = null;
		String word2 = null;

		inputString = reader.nextLine();
		tokenizer = new Scanner(inputString);
		if (tokenizer.hasNext()) {
			word1 = tokenizer.next();
			if (tokenizer.hasNext()) {
				word2 = tokenizer.next();
			}
		}
		return new Command(commands.getCommandWord(word1), word2);
	}

	private String processCommand(Command command) {
		String output = "";
		CommandWord commandWord = command.getCommandWord();
		switch (commandWord) {
		case UNKNOWN:
			output = "Unknown command!";
			break;
		case QUIT:
			finished = true;
			break;
		case MOVE:
			if (command.hasSecondWord()) {
				movePlayer(command.getSecondWord());
			} else {
				output = "Usage: move <direction>";
			}
			break;
		case LOOK:
			output = p.getCurrentRoom().getDetail();
			break;
		case HELP:
			output = "Listing Commands: " + showCommands();
			break;
		}
		return output;
	}

	private void movePlayer(String direction) {
		if (direction.toUpperCase().equals("NORTH")) {
			if (p.getCurrentRoom().getNorth() != null) {
				p.setCurrentRoom(p.getCurrentRoom().getNorth());
				next = true;
			} else {
				System.out.println("There's nothing to the north...");
			}
		} else if (direction.toUpperCase().equals("EAST")) {
			if (p.getCurrentRoom().getEast() != null) {
				p.setCurrentRoom(p.getCurrentRoom().getEast());
				next = true;
			} else {
				System.out.println("There's nothing to the east...");
			}
		} else if (direction.toUpperCase().equals("SOUTH")) {
			if (p.getCurrentRoom().getSouth() != null) {
				p.setCurrentRoom(p.getCurrentRoom().getSouth());
				next = true;
			} else {
				System.out.println("There's nothing to the south...");
			}
		} else if (direction.toUpperCase().equals("WEST")) {
			if (p.getCurrentRoom().getWest() != null) {
				p.setCurrentRoom(p.getCurrentRoom().getWest());
				next = true;
			} else {
				System.out.println("There's nothing to the west...");
			}
		}
		else {
			System.out.println("Unknown direction");
		}
	}
}
