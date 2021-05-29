package com.example.demo.enity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class DonThuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayLapDon;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "donthuoc")
	@JsonIgnore
	private List<ChiTietDonThuoc> dsChiTietDonThuoc;


	@OneToOne(fetch = FetchType.LAZY, mappedBy = "donthuoc", cascade = CascadeType.ALL)
	@JsonIgnore
	private PhieuKhambenh phieukhambenh;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public List<ChiTietDonThuoc> getDsChiTietDonThuoc() {
		return dsChiTietDonThuoc;
	}

	public void setDsChiTietDonThuoc(List<ChiTietDonThuoc> dsChiTietDonThuoc) {
		this.dsChiTietDonThuoc = dsChiTietDonThuoc;
	}

	public PhieuKhambenh getPhieukhambenh() {
		return phieukhambenh;
	}

	public void setPhieukhambenh(PhieuKhambenh phieukhambenh) {
		this.phieukhambenh = phieukhambenh;
	}

	public Date getNgayLapDon() {
		return ngayLapDon;
	}

	public void setNgayLapDon(Date ngayLapDon) {
		this.ngayLapDon = ngayLapDon;
	}

	public DonThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
