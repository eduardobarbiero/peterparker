package org.catolicasc.peterparker.model;

import java.util.Set;

public class Car {

	private Long id;

	private String board;

	private String color;

	private Set<Ticket> tickets;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoard() {
		return this.board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getColor() {
		return this.color;
	}

	public void setCor(String color) {
		this.color = color;
	}

	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
}
