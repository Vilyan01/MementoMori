package com.hellhound.Models;

public class Player {
	String name;
	int health;
	int stamina;
	Room currentRoom;
	
	public Player(String name) {
		this.name = name;
		health = 100;
		stamina = 100;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}
}
