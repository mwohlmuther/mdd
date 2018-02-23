package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class GenericListHolder<T> {

	private int id;
	private List<T> list = new ArrayList<>();

	// Konstruktor
	public GenericListHolder(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<T> getList() {
		return list;
	}

	public void addElement(T newElement) {
		list.add(newElement);
	}

}
