package org.se.lab;

public class PowerPlant extends Entity {
	private int id;
	private String name;
	private Double barcode;
	
	public PowerPlant(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBarcode() {
		return barcode;
	}
	public void setBarcode(Double barcode) {
		this.barcode = barcode;
	}
	public int getId() {
		return id;
	}
	
	public String getAuditInfo() {
		return "AuditInfo:" + id + barcode;
	}
	
}
