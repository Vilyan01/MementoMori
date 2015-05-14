package com.hellhound.Controllers;

import com.hellhound.Models.*;

public class GameController {
	public Player p;

	public GameController() {
		init();
	}
	
	private void init() {
		p = new Player("Ballsak");
		
		Room atrium = new Room("Atrium", "You see a fuck ton of birds in this shit");
		Room plaza = new Room("Plaza", "God damn this place is fucking cold, get back inside.");
		
		atrium.setSouth(plaza);
		plaza.setNorth(atrium);
		

		
		// Start in the atrium
		p.setCurrentRoom(atrium);
	}
	
	public void start() {
		boolean finished = false;
		while(!finished) {
			System.out.println(p.getCurrentRoom().getDescription());
			System.out.println(p.getCurrentRoom().getDetail());
			System.out.println("Exits: " + p.getCurrentRoom().exits());
			
			finished = true;
		}
	}
}
