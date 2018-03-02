package org.se.lab.entities;

import org.se.lab.Cat;

@Cat
public class Perser extends Animal {

	private int id;
	private String myString;
	
	public Perser() {
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}
	
	public int calculateSum(int number1, int number2, int number3) {
		return number1+number2+number3;
	}

	public int getIds() {
		return id;
	}
	
	
	

}
