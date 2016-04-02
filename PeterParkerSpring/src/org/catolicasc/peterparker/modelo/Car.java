package org.catolicasc.peterparker.modelo;

public class Car {

	private Long id;

	private String board;

	private String color;

	public Car(Long id, String board, String color) {
		this.id = id;
		this.board = board;
		this.color = color;
	}

	public Car() {
	}

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

	public void setColor(String color) {
		this.color = color;
	}
}
