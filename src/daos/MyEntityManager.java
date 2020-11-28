package daos;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private EntityManager em;
	public static MyEntityManager instance;

	public MyEntityManager() {
		em = Persistence.createEntityManagerFactory("OnTapGK2020").createEntityManager();
	}

	public static MyEntityManager getInstance() {
		if (instance == null)
			instance = new MyEntityManager();
		return instance;
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
