package com.peterparker.models;

public class Device {
	private Long id;
	private String address;
	private String description;
	private boolean isActive;
	
	public Device(Long id, String address, String description) {
		this.id = id;
		this.address = address;
		this.description = description;
	}
	
	public Device() {
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
