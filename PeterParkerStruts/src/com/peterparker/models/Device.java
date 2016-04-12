package com.peterparker.models;

public class Device {

	private Long id;
	private String address;
	private String description;	
	
	public Device(Long id, String address, String description) {
		this.id = id;
		this.address = address;
		this.description = description;
	}
	
	public Device() {
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
