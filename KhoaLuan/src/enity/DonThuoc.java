package enity;

import java.util.Date;
import java.util.List;

public class DonThuoc {
	private long id;
	
	private List<ChiTietDonThuoc> dsChiTietDonThuoc;

	private PhieuKhambenh phieukhambenh;
	private Date ngayLapDon;
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
