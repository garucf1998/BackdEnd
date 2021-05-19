package enity;

import java.util.Date;
import java.util.List;

public class PhieuKhambenh {
    private long id;
    private Date ngayLapPhieu;
    private String trieuChung;
    private String chanDoan;
    private boolean trangThai;

    private NhanVien nhanvien;

    private BenhNhan benhnhan;

    private DonThuoc donthuoc;

    private List<PhieuDichVu> dsphieudichvu;

    private Float tienKham;

    private HoaDon hoadon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public BenhNhan getBenhnhan() {
        return benhnhan;
    }

    public void setBenhnhan(BenhNhan benhnhan) {
        this.benhnhan = benhnhan;
    }

    public DonThuoc getDonthuoc() {
        return donthuoc;
    }

    public void setDonthuoc(DonThuoc donthuoc) {
        this.donthuoc = donthuoc;
    }

    public List<PhieuDichVu> getDsphieudichvu() {
        return dsphieudichvu;
    }

    public void setDsphieudichvu(List<PhieuDichVu> dsphieudichvu) {
        this.dsphieudichvu = dsphieudichvu;
    }

    
    public Float getTienKham() {
		return tienKham;
	}

	public void setTienKham(Float tienKham) {
		this.tienKham = tienKham;
	}

	public HoaDon getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }

    public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getTrieuChung() {
		return trieuChung;
	}

	public void setTrieuChung(String trieuChung) {
		this.trieuChung = trieuChung;
	}

	public PhieuKhambenh() {
    }
}
