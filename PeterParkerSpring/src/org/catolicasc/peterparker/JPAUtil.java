package org.catolicasc.peterparker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entity = Persistence.createEntityManagerFactory("PeterParker");

	public EntityManager getEntityManager() {
		return entity.createEntityManager();
	}
}
