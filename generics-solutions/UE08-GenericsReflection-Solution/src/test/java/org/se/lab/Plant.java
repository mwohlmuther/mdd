package org.se.lab;

public class Plant extends Entity {
	private String name;
	private Double barcode;
	
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
	
	@Auditinformation
	public String getAuditInfo() {
		return "AuditInfo:" + "id" + barcode;
	}
	
}
