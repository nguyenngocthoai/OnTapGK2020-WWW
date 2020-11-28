package entities;

import daos.FilmDao;

public class MainTest {
	public static void main(String[] args) {
		try {

			FilmDao filmDao = new FilmDao();
		} catch (Exception e) {

			e.printStackTrace();// TODO: handle exception
		}
	}

}
