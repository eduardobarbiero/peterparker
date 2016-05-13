package org.catolicasc.peterparker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.catolicasc.peterparker.JPAUtil;
import org.catolicasc.peterparker.modelo.Car;

public class CarDAO {
	protected EntityManager entityManager;

	public CarDAO() {
		this.entityManager = new JPAUtil().getEntityManager();
	}

	public Car getById(final Long long1) {
		return this.entityManager.find(Car.class, long1);
	}

	@SuppressWarnings("unchecked")
	public List<Car> findAll() {
		return this.entityManager.createQuery("FROM " + Car.class.getName()).getResultList();
	}

	public void persist(Car car) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(car);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void merge(Car car) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(car);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void remove(Car car) {
		try {
			this.entityManager.getTransaction().begin();
			car = this.entityManager.find(Car.class, car.getId());
			this.entityManager.remove(car);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final long id) {
		try {
			Car car = this.getById(id);
			this.remove(car);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
