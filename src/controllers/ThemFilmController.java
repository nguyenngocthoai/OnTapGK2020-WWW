package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

@WebServlet("/themFilm")
public class ThemFilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryDao categoryDao = new CategoryDao();
	FilmDao filmDao = new FilmDao();

	public ThemFilmController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categories = new ArrayList<Category>();
		categories = categoryDao.getAllCategory();
		request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FilmForm.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String ten = request.getParameter("ten");
			String moTa = request.getParameter("mota");
			String thoiGianPhim = request.getParameter("thoigianphim");
			String ngay = request.getParameter("ngaykhoichieu");
			String url = request.getParameter("url");
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate ngayKhoiChieu = LocalDate.parse(ngay, df);
			String idC = request.getParameter("idCategory");

			Category c = categoryDao.getCategoryById(Long.parseLong(idC));
			Film film = new Film(ten, moTa, thoiGianPhim, ngayKhoiChieu, url);
			film.setCategory(c);
			filmDao.addFilm(film);

			List<Category> categories = new ArrayList<Category>();
			categories = categoryDao.getAllCategory();
			request.setAttribute("categories", categories);
			getServletContext().getRequestDispatcher("/ds").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

	}

}
