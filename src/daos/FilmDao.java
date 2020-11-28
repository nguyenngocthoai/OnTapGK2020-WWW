package daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Film;

public class FilmDao {
	private EntityManager em;

	public FilmDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	public List<Film> getAllFilm() {
		return em.createQuery("from Film", Film.class).getResultList();
	}

	public Film getFilmById(long id) {
		return em.find(Film.class, id);
	}

	public boolean addFilm(Film film) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(film);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteFilm(Film film) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(film);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateFilm(Film film) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(film);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<Film> getFilmByMaCategory(int id) {
		List<Film> listTT = this.getAllFilm();
		List<Film> resultList = new ArrayList<Film>();
		for (Film tinTuc : listTT) {
			if (tinTuc.getCategory().getIdCategory() == id) {
				resultList.add(tinTuc);
			}
		}
		return resultList;
	}

}
