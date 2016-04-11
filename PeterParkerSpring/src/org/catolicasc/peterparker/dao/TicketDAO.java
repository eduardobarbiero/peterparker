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

	private static final String INSERT_TICKET = "INSERT INTO ticket (carro_id, hora_entrada, dispositivo_entrada) Values (?,?,?)";
	private static final String GET_ID_BY_BOARD = "SELECT t.ticket_id FROM ticket t LEFT JOIN Carro c ON (t.carro_id=c.carro_id) where c.carro_id = ";
	private static final String GET_CAR_BY_BOARD = "SELECT * FROM ticket t LEFT JOIN Carro c ON (t.carro_id=c.carro_id) where c.placa = '";
	private static final String GET_LIST_TICKET = "SELECT * FROM ticket t LEFT JOIN Carro c ON t.carro_id=c.carro_id WHERE t.hora_saida IS NULL";
	private static final String GET_LIST_TICKET_OUT = "SELECT * FROM ticket t LEFT JOIN Carro c ON t.carro_id=c.carro_id WHERE t.hora_saida IS NOT NULL";
	private static final String REMOVE_TICKET = "DELETE FROM  ticket WHERE ticket_id=?";
	private static final String UPDATE_TICKET = "UPDATE ticket SET hora_saida=?, dispositivo_saida=? where ticket_id=?";

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

			this.stmt.setLong(1, ticket.getCarro().getId());
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
				Car car = new Car(rs.getLong("carro_id"), rs.getString("placa"), rs.getString("cor"));

				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getTimestamp("hora_entrada"));

				ticket.setId(rs.getLong("ticket_id"));
				ticket.setCarro(car);
				ticket.setDispositivoEntrada(new Device(rs.getLong("dispositivo_entrada")));
				ticket.setHoraEntrada(cal);

				tickets.add(ticket);
			}
			this.stmt.close();
			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Ticket> getListOut() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			this.stmt = this.con.prepareStatement(GET_LIST_TICKET_OUT);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				Ticket ticket = new Ticket();
				Car car = new Car(rs.getLong("carro_id"), rs.getString("placa"), rs.getString("cor"));

				Calendar horaEntrada = Calendar.getInstance();
				horaEntrada.setTime(rs.getTimestamp("hora_entrada"));

				ticket.setId(rs.getLong("ticket_id"));
				ticket.setCarro(car);
				ticket.setDispositivoEntrada(new Device(rs.getLong("dispositivo_entrada")));
				ticket.setDispositivoSaida(new Device(rs.getLong("dispositivo_saida")));
				ticket.setHoraEntrada(horaEntrada);

				Calendar horaSaida = Calendar.getInstance();
				horaSaida.setTime(rs.getTimestamp("hora_saida"));

				ticket.setHoraSaida(horaSaida);

				tickets.add(ticket);
			}
			this.stmt.close();
			return tickets;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Ticket ticket) {
		try {
			this.stmt = this.con.prepareStatement(REMOVE_TICKET);
			this.stmt.setLong(1, ticket.getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
				carro.setPlaca(rs.getString("placa"));
				carro.setCor(rs.getString("cor"));
			}
			ticket.setCarro(carro);
			this.stmt.close();

			return ticket;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Ticket getById(Long id) {
		Ticket ticket = new Ticket();
		try {

			this.stmt = this.con.prepareStatement(GET_ID_BY_BOARD + id);
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
