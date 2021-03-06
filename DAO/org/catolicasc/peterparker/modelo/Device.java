package org.catolicasc.peterparker.modelo;

public class Device {

	private Long id;
	private String address;
	private String description;

	public Device(Long id) {
		this.id = id;
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
