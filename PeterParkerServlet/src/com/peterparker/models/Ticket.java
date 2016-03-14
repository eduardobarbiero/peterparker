package com.peterparker.models;

import java.util.Set;

public class Ticket {

	private Long id;

	private Long carId;

	private Set<Device> devices;

	public Long getCarroId() {
		return this.carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Set<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
