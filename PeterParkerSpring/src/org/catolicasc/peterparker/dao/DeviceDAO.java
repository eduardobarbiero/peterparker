package org.catolicasc.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.catolicasc.peterparker.ConnectionFactory;
import org.catolicasc.peterparker.modelo.Device;

public class DeviceDAO {

	private static final String INSERT_DEVICE = "INSERT INTO DISPOSITIVO (localizacao, descricao) Values (?, ?)";
	private static final String SELECT_DEVICE = "SELECT * FROM DISPOSITIVO";
	private static final String REMOVE_DEVICE = "DELETE FROM  DISPOSITIVO WHERE dispositivo_id=?";
	private static final String UPDATE_DEVICE = "UPDATE DISPOSITIVO SET localizacao=?, descricao=? where dispositivo_id=?";
	private static final String GET_DEVICE_BY_ID = "SELECT * FROM DISPOSITIVO where dispositivo_id = ";

	private Connection con = null;
	private PreparedStatement stmt = null;

	public DeviceDAO() {
		try {
			this.con = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(Device device) {
		try {
			this.stmt = this.con.prepareStatement(INSERT_DEVICE);

			// Seta os valores
			this.stmt.setString(1, device.getLocalizacao());
			this.stmt.setString(2, device.getDescricao());

			// Executa
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Device> get() {
		ArrayList<Device> devices = new ArrayList<Device>();
		try {
			this.stmt = this.con.prepareStatement(SELECT_DEVICE);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Device device = new Device();
				device.setId(rs.getLong("dispositivo_id"));
				device.setLocalizacao(rs.getString("localizacao"));
				device.setDescricao(rs.getString("descricao"));

				// adicionando o objeto � lista
				devices.add(device);
			}
			rs.close();

			this.stmt.close();
			return devices;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Device device) throws SQLException {
		try {
			this.stmt = this.con.prepareStatement(UPDATE_DEVICE);
			this.stmt.setString(1, device.getLocalizacao());
			this.stmt.setString(2, device.getDescricao());
			this.stmt.setLong(3, device.getId());
			this.stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.stmt.close();
		}

	}

	public void remove(Device device) {
		try {
			this.stmt = this.con.prepareStatement(REMOVE_DEVICE);
			this.stmt.setLong(1, device.getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Device getDeviceById(Long id) {
		try {
			Device device = null;
			this.stmt = this.con.prepareStatement(GET_DEVICE_BY_ID + id);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				device = new Device();
				device.setId(rs.getLong("dispositivo_id"));
				device.setLocalizacao(rs.getString("localizacao"));
				device.setDescricao(rs.getString("descricao"));

				// adicionando o objeto � lista
			}
			this.stmt.close();

			return device;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
