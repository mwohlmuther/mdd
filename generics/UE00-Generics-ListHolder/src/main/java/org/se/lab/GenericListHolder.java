package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class GenericListHolder<TYPE> {

	private int id;
	private List<TYPE> list = new ArrayList<>();

	// Konstruktor
	public GenericListHolder(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<TYPE> getList() {
		return list;
	}

	public void addElement(TYPE newElement) {
		list.add(newElement);
	}

}
