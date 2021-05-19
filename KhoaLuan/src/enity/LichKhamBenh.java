package enity;


import java.util.Date;
import java.util.List;

public class LichKhamBenh {
    private Long id;
    private Date ngayLap;
    private NhanVien nhanvien;
    private int doUuTien;
    private List<BenhNhan>dsbenhnhan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public List<BenhNhan> getDsbenhnhan() {
        return dsbenhnhan;
    }

    public void setDsbenhnhan(List<BenhNhan> dsbenhnhan) {
        this.dsbenhnhan = dsbenhnhan;
    }

    public int getDoUuTien() {
        return doUuTien;
    }

    public void setDoUuTien(int doUuTien) {
        this.doUuTien = doUuTien;
    }

    public LichKhamBenh() {
    }
}
