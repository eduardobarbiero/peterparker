package com.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peterparker.models.Device;

public class DeviceDAO {

	private static final String INSERT_DEVICE = "INSERT INTO DISPOSITIVOS (localizacao, descricao) Values (?, ?)";
	private static final String SELECT_DEVICE = "SELECT * FROM DISPOSITIVOS";
	private static final String REMOVE_DEVICE = "DELETE FROM  DISPOSITIVOS WHERE dispositivo_id=?";
	private static final String UPDATE_DEVICE = "UPDATE DISPOSITIVOS SET localizacao=?, descricao=? where dispositivo_id=?";
	
	private Connection con = null;
	private PreparedStatement stmt = null;
	
	public DeviceDAO() {
		this.con = new ConnectDB().getConnection();
	}

	public void add(Device device) throws SQLException {
		try {
			stmt = this.con.prepareStatement(INSERT_DEVICE);

			// Seta os valores
			stmt.setString(1, device.getAddress());
			stmt.setString(2, device.getDescription());

			// Executa
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}

	public List<Device> get() throws SQLException {
		List<Device> devices = new ArrayList<Device>();
		try {
			stmt = this.con.prepareStatement(SELECT_DEVICE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Device device = new Device();
				device.setId(rs.getLong("id"));
				device.setAddress(rs.getString("localizacao"));
				device.setDescription(rs.getString("descricao"));

				// adicionando o objeto à lista
				devices.add(device);
			}
			rs.close();

			return devices;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void update(Device device) throws SQLException {
		try {
			stmt = this.con.prepareStatement(UPDATE_DEVICE);
			stmt.setString(1, device.getAddress());
			stmt.setString(2, device.getDescription());
			stmt.setLong(3, device.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}

	}

	public void remove(Device device) throws SQLException {
		try {
			stmt = this.con.prepareStatement(REMOVE_DEVICE);
			stmt.setLong(1, device.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
		}
	}
}
