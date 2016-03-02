package org.catolicasc.peterparker.model;

import java.sql.Date;

public class TicketDispositivos {

	private Long id;

	private Long ticketId;

	private Long deviceId;

	private Date date;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getDeviceId() {
		return this.deviceId;
	}

	public void setDipositivoId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
