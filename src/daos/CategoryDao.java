package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Category;
import entities.Film;

public class CategoryDao {
	private EntityManager em;

	public CategoryDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public List<Category> getAllCategory() {
		return em.createQuery("from Category", Category.class).getResultList();
	}

	public Category getCategoryById(long id) {
		return em.find(Category.class, id);
	}

	public boolean addCategory(Category category) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(category);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(category);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(category);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
