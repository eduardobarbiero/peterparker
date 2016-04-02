package org.catolicasc.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.catolicasc.peterparker.ConnectionFactory;
import org.catolicasc.peterparker.modelo.Car;
import org.catolicasc.peterparker.modelo.Device;
import org.catolicasc.peterparker.modelo.Ticket;

public class TicketDAO {

	private static final String INSERT_TICKET = "INSERT INTO TICKET (carro_id, hora_entrada, dispositivo_entrada) Values (?,?,?)";
	private static final String GET_ID_BY_BOARD = "SELECT t.ticket_id FROM TICKET t LEFT JOIN Carro c ON (t.carro_id=c.carro_id) where c.placa = '";
	private static final String GET_CAR_BY_BOARD = "SELECT * FROM TICKET t LEFT JOIN Carro c ON (t.carro_id=c.carro_id) where c.placa = '";
	private static final String GET_LIST_TICKET = "SELECT * FROM TICKET t LEFT JOIN Carro c ON t.carro_id=c.carro_id";
	private static final String REMOVE_TICKET = "DELETE FROM  TICKETS WHERE ticket_id=?";
	private static final String UPDATE_TICKET = "UPDATE TICKET SET hora_saida=?, dispositivo_saida=? where ticket_id=?";

	private Connection con = null;
	private PreparedStatement stmt = null;

	public TicketDAO() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(Ticket ticket) {
		try {
			this.stmt = this.con.prepareStatement(INSERT_TICKET);

			this.stmt.setLong(1, ticket.getCar().getId());
			this.stmt.setTimestamp(2, new Timestamp(ticket.getHoraEntrada().getTimeInMillis()));
			this.stmt.setLong(3, ticket.getDispositivoEntrada().getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Ticket> getList() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			this.stmt = this.con.prepareStatement(GET_LIST_TICKET);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				Ticket ticket = new Ticket();
				Device device = new Device(rs.getLong("dispositivo_entrada"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("hora_entrada"));
				Car car = new Car(rs.getLong("carro_id"), rs.getString("placa"), rs.getString("cor"));
				ticket.setId(rs.getLong("ticket_id"));
				ticket.setCar(car);
				ticket.setDispositivoEntrada(device);
				ticket.setDispositivoSaida(new Device(rs.getLong("dispositivo_saida")));
				ticket.setHoraEntrada(cal);
				if (rs.getDate("hora_saida") == null) {
					ticket.setDispositivoSaida(null);
				} else {
					cal.setTime(rs.getDate("hora_saida"));
					ticket.setHoraSaida(cal);
				}

				tickets.add(ticket);
			}
			this.stmt.close();
			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Ticket ticket) throws SQLException {
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

	public Ticket getByBoard(String placa) {
		Ticket ticket = new Ticket();
		try {

			this.stmt = this.con.prepareStatement(GET_CAR_BY_BOARD + placa + "'");
			ResultSet rs = this.stmt.executeQuery();

			Car carro = new Car();
			if (rs.next()) {
				carro.setId(rs.getLong("carro_id"));
				carro.setBoard(rs.getString("placa"));
				carro.setColor(rs.getString("cor"));
			}
			ticket.setCar(carro);
			this.stmt.close();

			return ticket;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Ticket getById(String placa) {
		Ticket ticket = new Ticket();
		try {

			this.stmt = this.con.prepareStatement(GET_ID_BY_BOARD + placa + "'");
			ResultSet rs = this.stmt.executeQuery();

			if (rs.next()) {
				ticket.setId(rs.getLong("ticket_id"));
			}

			this.stmt.close();
			return ticket;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Ticket ticket) {
		try {
			this.stmt = this.con.prepareStatement(UPDATE_TICKET);
			this.stmt.setTimestamp(1, new Timestamp(ticket.getHoraSaida().getTimeInMillis()));
			this.stmt.setLong(2, ticket.getDispositivoSaida().getId());
			this.stmt.setLong(3, ticket.getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
