package com.example.demo.enity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class LichHen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLichHen;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoiGian;
    @Column(name = "TrieuChung")
    private String trieuChung;
    @Column(name = "GhiChu")
    private String ghiChu;

    private String trangThai;
    @NotNull
    private boolean hinhThuc;

    @ManyToOne
    @JoinColumn
    private BenhNhan benhnhan;

    @ManyToOne
    @JoinColumn
    private NhanVien nhanvien;

    public boolean isHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(boolean hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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
        return benhnhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhnhan = benhNhan;
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
