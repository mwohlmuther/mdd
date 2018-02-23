package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class StringListHolder {

	private int id;
	private List<String> stringList = new ArrayList<>();

	// Konstruktor
	public StringListHolder(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public void addElement(String newElement) {
		stringList.add(newElement);
	}

}
