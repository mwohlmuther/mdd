package org.se.lab;

@MyOwnAnnotation
public abstract class ImplementedClass {

	private int id;
	private String myString;
	
	public ImplementedClass(int ids) {
		super();
		this.id = ids;
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
