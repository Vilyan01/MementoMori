package com.hellhound.Models;

public class Player {
	String name;
	int health;
	int stamina;
	
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
}
