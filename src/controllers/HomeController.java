package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoryDao;
import daos.FilmDao;
import entities.Category;
import entities.Film;

@WebServlet("/ds")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Film> films = new ArrayList<Film>();
		List<Category> categories = new ArrayList<Category>();
		
		FilmDao dao = new FilmDao();
		films = dao.getAllFilm();
		
		CategoryDao categoryDao=new CategoryDao();
		categories=categoryDao.getAllCategory();
		
		request.setAttribute("categories", categories);
//		request.setAttribute("films", films);
		request.getRequestDispatcher("DanhSachFilmByCategory.jsp").forward(request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachFilmByCategory.jsp");
//		dispatcher.forward(request, response);
//		response.sendRedirect("/DanhSachFilmByCategory.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
