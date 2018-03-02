package org.se.lab.entities;

import org.se.lab.Dog;

@Dog
public class Dogge extends Animal {

	private int id;
	private String myString;
	
	public Dogge() {
	}
	
	public Dogge(int id) {
		this.id = id;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public int getIds() {
		return id;
	}
	
	
	

}
