package com.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peterparker.models.Ticket;

public class TicketDAO {

	private static final String INSERT_TICKET = "INSERT INTO TICKETS (carro_id) Values (?)";
	private static final String SELECT_TICKET = "SELECT * FROM TICKETS";
	private static final String REMOVE_TICKET = "DELETE FROM  TICKETS WHERE ticket_id=?";
	private static final String UPDATE_TICKET = "UPDATE TICKETS SET carro_id=? where ticket_id=?";
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public TicketDAO() {
		this.con = new ConnectDB().getConnection();
	}

	public void add(Ticket ticket) throws SQLException {
		try {
			stmt = this.con.prepareStatement(INSERT_TICKET);

			// Seta os valores
			stmt.setLong(1, ticket.getCarroId());

			// Executa
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public List<Ticket> get() throws SQLException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			stmt = this.con.prepareStatement(SELECT_TICKET);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Ticket ticket = new Ticket();
				ticket.setId(rs.getLong("ticket_id"));
				ticket.setCarId(rs.getLong("carro_id"));

				// adicionando o objeto à lista
				tickets.add(ticket);
			}
			rs.close();

			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void update(Ticket ticket) throws SQLException {
		try {
			stmt = this.con.prepareStatement(UPDATE_TICKET);
			stmt.setLong(1, ticket.getId());
			stmt.setLong(2, ticket.getCarroId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void remove(Ticket ticket) throws SQLException {
		try {
			stmt = this.con.prepareStatement(REMOVE_TICKET);
			stmt.setLong(1, ticket.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
}
