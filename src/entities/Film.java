package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: LopHoc
 *
 */
@Entity

public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFilm;
	private String ten;
	private String moTa;
	private String thoiGianPhim;
	private LocalDate ngayKhoiChieu;
	private String url;
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	public Film() {
		super();
	}

	public Film(String ten, String moTa, String thoiGianPhim, LocalDate ngayKhoiChieu, String url) {
		super();
		this.ten = ten;
		this.moTa = moTa;
		this.thoiGianPhim = thoiGianPhim;
		this.ngayKhoiChieu = ngayKhoiChieu;
		this.url = url;
	}

	public long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(long idFilm) {
		this.idFilm = idFilm;
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

	public String getThoiGianPhim() {
		return thoiGianPhim;
	}

	public void setThoiGianPhim(String thoiGianPhim) {
		this.thoiGianPhim = thoiGianPhim;
	}

	public LocalDate getNgayKhoiChieu() {
		return ngayKhoiChieu;
	}

	public void setNgayKhoiChieu(LocalDate ngayKhoiChieu) {
		this.ngayKhoiChieu = ngayKhoiChieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
