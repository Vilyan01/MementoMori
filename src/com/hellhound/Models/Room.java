package com.hellhound.Models;

public class Room {
	String description;
	String detail;
	Room north;
	Room east;
	Room south;
	Room west;
	
	public Room(String description, String detail) {
		this.description = description;
		this.detail = detail;
		north = null;
		east = null;
		south = null;
		west = null;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setNorth(Room room) {
		north = room;
	}
	
	public void setEast(Room room) {
		east = room;
	}
	
	public void setSouth(Room room) {
		south = room;
	}
	
	public void setWest(Room room) {
		west = room;
	}
	
	public Room getNorth() {
		return north;
	}
	
	public Room getEast() {
		return east;
	}
	
	public Room getSouth() {
		return south;
	}
	
	public Room getWest() {
		return west;
	}
}
