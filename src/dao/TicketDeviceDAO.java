package org.catolicasc.peterparker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.catolicasc.peterparker.model.TicketDevice;

public class TicketDeviceDAO {

	private static final String INSERT_TICKET = "INSERT INTO TICKET_DISPOSITIVOS (dispositivo_id, ticket_id, data) Values (?, ?, ?)";
	private static final String SELECT_TICKET = "SELECT * FROM TICKET_DISPOSITIVOS";
	private static final String REMOVE_TICKET = "DELETE FROM  TICKET_DISPOSITIVOS WHERE id=?";

	private Connection con = null;
	private PreparedStatement stmt = null;

	public TicketDeviceDAO() {
		this.con = new ConnectDB().getConnection();
	}

	public void add(TicketDevice ticketDevice) throws SQLException {
		try {
			this.stmt = this.con.prepareStatement(INSERT_TICKET);

			// Seta os valores
			this.stmt.setLong(1, ticketDevice.getDeviceId());
			this.stmt.setLong(2, ticketDevice.getTicketId());
			this.stmt.setDate(3, new Date(1959595));

			// Executa
			this.stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.stmt.close();
		}
	}

	public List<TicketDevice> get() throws SQLException {
		List<TicketDevice> tickets = new ArrayList<TicketDevice>();
		try {
			this.stmt = this.con.prepareStatement(SELECT_TICKET);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				TicketDevice ticket = new TicketDevice();
				ticket.setId(rs.getLong("id"));
				ticket.setDipositivoId(rs.getLong("dispositivo_id"));
				ticket.setTicketId(rs.getLong("ticket_id"));
				ticket.setDate(rs.getDate("data"));

				// adicionando o objeto à lista
				tickets.add(ticket);
			}
			rs.close();

			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.stmt.close();
		}

	}

	public void remove(TicketDevice ticket) throws SQLException {
		try {
			this.stmt = this.con.prepareStatement(REMOVE_TICKET);
			this.stmt.setLong(1, ticket.getId());
			this.stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.stmt.close();
		}
	}
}
