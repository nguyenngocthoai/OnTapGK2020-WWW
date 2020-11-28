package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: SinhVien
 *
 */
@Entity

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategory;
	private String ten;
	private String moTa;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")

	private List<Film> films;

	public Category() {
		super();
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
