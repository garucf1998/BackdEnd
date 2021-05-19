package enity;


import java.util.Date;

public class PhieuDichVu {
	private long id;
	private DichVu dichVu;

	private PhieuKhambenh phieukhambenh;
	private String ghiChu;
	private String ketLuan;
	private Date ngayTaoPhieu;
	private Float giaTienDV;

	public PhieuKhambenh getPhieukhambenh() {
		return phieukhambenh;
	}

	public void setPhieukhambenh(PhieuKhambenh phieukhambenh) {
		this.phieukhambenh = phieukhambenh;
	}

	public Date getNgayTaoPhieu() {
		return ngayTaoPhieu;
	}

	public void setNgayTaoPhieu(Date ngayTaoPhieu) {
		this.ngayTaoPhieu = ngayTaoPhieu;
	}

	

	

	public Float getGiaTienDV() {
		return giaTienDV;
	}

	public void setGiaTienDV(Float giaTienDV) {
		this.giaTienDV = giaTienDV;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public String getKetLuan() {
		return ketLuan;
	}
	public void setKetLuan(String ketLuan) {
		this.ketLuan = ketLuan;
	}
	public PhieuDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
