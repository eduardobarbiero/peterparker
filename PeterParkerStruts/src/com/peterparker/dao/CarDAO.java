package com.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peterparker.models.Carro;

public class CarDAO {

	private static final String INSERT_CAR = "INSERT INTO CARRO (placa, cor) Values (?, ?)";
	private static final String SELECT_CAR = "SELECT * FROM CARRO";
	private static final String REMOVE_CAR = "DELETE FROM  CARRO WHERE carro_id=?";
	private static final String GET_CAR_BY_BOARD = "SELECT * FROM Carro WHERE placa = '";
	private static final String GET_CAR_BY_ID = "SELECT * FROM Carro WHERE id = '";

	private Connection con = null;
	private PreparedStatement stmt = null;

	public CarDAO() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(Carro car) {
		try {
			this.stmt = this.con.prepareStatement(INSERT_CAR);

			// Seta os valores
			this.stmt.setString(1, car.getPlaca());
			this.stmt.setString(2, car.getCor());

			// Executa
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Carro> get() {
		List<Carro> cars = new ArrayList<Carro>();
		try {
			this.stmt = this.con.prepareStatement(SELECT_CAR);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Carro car = new Carro();
				car.setId(rs.getLong("carro_id"));
				car.setPlaca(rs.getString("placa"));
				car.setCor(rs.getString("cor"));

				// adicionando o objeto à lista
				cars.add(car);
			}
			rs.close();
			this.stmt.close();

			return cars;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Carro getIdByBoard(String placa) {
		Carro car = new Carro();
		try {
			this.stmt = this.con.prepareStatement(GET_CAR_BY_BOARD + placa + "'");
			ResultSet rs = this.stmt.executeQuery();

			if (rs.next()) {
				car.setId(rs.getLong("carro_id"));
				car.setPlaca(rs.getString("placa"));
				car.setCor(rs.getString("cor"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}

	public Carro getIdById(String id) {
		Carro car = new Carro();
		try {
			this.stmt = this.con.prepareStatement(GET_CAR_BY_ID + id + "'");
			ResultSet rs = this.stmt.executeQuery();

			if (rs.next()) {
				car.setId(rs.getLong("carro_id"));
				car.setPlaca(rs.getString("placa"));
				car.setCor(rs.getString("cor"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}

	public void remove(Carro car) {
		try {
			this.stmt = this.con.prepareStatement(REMOVE_CAR);
			this.stmt.setLong(1, car.getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
