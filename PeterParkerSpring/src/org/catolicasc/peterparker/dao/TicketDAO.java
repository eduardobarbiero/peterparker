package org.catolicasc.peterparker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.catolicasc.peterparker.JPAUtil;
import org.catolicasc.peterparker.modelo.Ticket;

public class TicketDAO {
	protected EntityManager entityManager;

	public TicketDAO() {
		this.entityManager = new JPAUtil().getEntityManager();
	}

	public Ticket getById(final Long long1) {
		return this.entityManager.find(Ticket.class, long1);
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> findAll() {
		Query query = this.entityManager
				.createQuery("SELECT t FROM Ticket t LEFT JOIN Car c ON t.carro.id = c.id WHERE t.dispositivoSaida.id IS NULL");

		return query.getResultList();
	}

	public void persist(Ticket ticket) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(ticket);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void merge(Ticket ticket) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(ticket);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void remove(Ticket ticket) {
		try {
			this.entityManager.getTransaction().begin();
			ticket = this.entityManager.find(Ticket.class, ticket.getId());
			this.entityManager.remove(ticket);
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final long id) {
		try {
			Ticket ticket = this.getById(id);
			this.remove(ticket);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
