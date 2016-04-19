package com.peterparker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.peterparker.models.Dispositivo;

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

	public void add(Dispositivo dispositivo) {
		try {
			this.stmt = this.con.prepareStatement(INSERT_DEVICE);

			// Seta os valores
			this.stmt.setString(1, dispositivo.getLocalizacao());
			this.stmt.setString(2, dispositivo.getDescricao());

			// Executa
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Dispositivo> get() {
		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			this.stmt = this.con.prepareStatement(SELECT_DEVICE);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				Dispositivo dispositivo = new Dispositivo();
				dispositivo.setId(rs.getLong("dispositivo_id"));
				dispositivo.setLocalizacao(rs.getString("localizacao"));
				dispositivo.setDescricao(rs.getString("descricao"));

				// adicionando o objeto à lista
				dispositivos.add(dispositivo);
			}
			rs.close();

			this.stmt.close();
			return dispositivos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Dispositivo dispositivo) throws SQLException {
		try {
			this.stmt = this.con.prepareStatement(UPDATE_DEVICE);
			this.stmt.setString(1, dispositivo.getLocalizacao());
			this.stmt.setString(2, dispositivo.getDescricao());
			this.stmt.setLong(3, dispositivo.getId());
			this.stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.stmt.close();
		}

	}

	public void remove(Dispositivo dispositivo) {
		try {
			this.stmt = this.con.prepareStatement(REMOVE_DEVICE);
			this.stmt.setLong(1, dispositivo.getId());
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Dispositivo getDeviceById(String id) {
		Dispositivo dispositivo = null;
		try {
			this.stmt = this.con.prepareStatement(GET_DEVICE_BY_ID + id);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto Contato
				dispositivo = new Dispositivo();
				dispositivo.setId(rs.getLong("dispositivo_id"));
				dispositivo.setLocalizacao(rs.getString("localizacao"));
				dispositivo.setDescricao(rs.getString("descricao"));

				// adicionando o objeto à lista
			}
			this.stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dispositivo;
	}
}
