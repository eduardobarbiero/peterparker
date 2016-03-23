package com.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peterparker.models.Car;

public class CarDAO {

	private static final String INSERT_CAR = "INSERT INTO CARROS (placa, cor) Values (?, ?)";
	private static final String SELECT_CAR = "SELECT * FROM CARROS";
	private static final String REMOVE_CAR = "DELETE FROM  CARROS WHERE carro_id=?";
	private static final String UPDATE_CAR = "UPDATE CARROS SET placa=?, cor=? where carro_id=?";
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public CarDAO() {
		this.con = new ConnectDB().getConnection();
	}

	public void add(Car car) throws SQLException {
		try {
			stmt = this.con.prepareStatement(INSERT_CAR);

			// Seta os valores
			stmt.setString(1, car.getBoard());
			stmt.setString(2, car.getColor());

			// Executa
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public List<Car> get() throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		try {
			stmt = this.con.prepareStatement(SELECT_CAR);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Car car = new Car();
				car.setId(rs.getLong("id"));
				car.setBoard(rs.getString("placa"));
				car.setColor(rs.getString("cor"));

				// adicionando o objeto à lista
				cars.add(car);
			}
			rs.close();

			return cars;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void update(Car car) throws SQLException {
		try {
			stmt = this.con.prepareStatement(UPDATE_CAR);
			stmt.setString(1, car.getBoard());
			stmt.setString(2, car.getColor());
			stmt.setLong(3, car.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void remove(Car car) throws SQLException {
		try {
			stmt = this.con.prepareStatement(REMOVE_CAR);
			stmt.setLong(1, car.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
}
