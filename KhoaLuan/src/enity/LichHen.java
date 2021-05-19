package enity;

import java.util.Date;

public class LichHen {
    private Long maLichHen;
    private Date thoiGian;
    private String trieuChung;
    private String ghiChu;
    private BenhNhan benhnhan;

   private NhanVien nhanvien;

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
        return benhnhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhnhan = benhNhan;
    }

    public NhanVien getNhanVien() {
        return nhanvien;
    }

    public void setNhanVien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public LichHen() {
    }
}
