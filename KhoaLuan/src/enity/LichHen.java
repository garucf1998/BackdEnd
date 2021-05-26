package enity;

import java.util.Date;

public class LichHen {
    private Long maLichHen;
    private Date thoiGian;
    private String trieuChung;
    private String ghiChu;
    private String trangThai;
    private boolean hinhThuc;
    private BenhNhan benhNhan;

   private NhanVien nhanvien;

    public String getTrangThai() {
	return trangThai;
}

public void setTrangThai(String trangThai) {
	this.trangThai = trangThai;
}

public boolean isHinhThuc() {
	return hinhThuc;
}

public void setHinhThuc(boolean hinhThuc) {
	this.hinhThuc = hinhThuc;
}


public Long getMaLichHen() {
        return maLichHen;
    }

    public void setMaLichHen(Long maLichHen) {
        this.maLichHen = maLichHen;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    public BenhNhan getBenhNhan() {
		return benhNhan;
	}

	public void setBenhNhan(BenhNhan benhNhan) {
		this.benhNhan = benhNhan;
	}

	

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public LichHen() {
    }
}
