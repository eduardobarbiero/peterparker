package org.catolicasc.peterparker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.catolicasc.peterparker.JPAUtil;
import org.catolicasc.peterparker.modelo.Device;

public class DeviceDAO {
	protected EntityManager entityManager;

	public DeviceDAO() {
		this.entityManager = new JPAUtil().getEntityManager();
	}

	public Device getById(final Long long1) {
		return this.entityManager.find(Device.class, long1);
	}

	@SuppressWarnings("unchecked")
	public List<Device> findAll() {
		return this.entityManager.createQuery("FROM " + Device.class.getName()).getResultList();
	}

	public void persist(Device device) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(device);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void merge(Device device) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(device);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void remove(Device device) {
		try {
			this.entityManager.getTransaction().begin();
			device = this.entityManager.find(Device.class, device.getId());
			this.entityManager.remove(device);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final long id) {
		try {
			Device device = this.getById(id);
			this.remove(device);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
