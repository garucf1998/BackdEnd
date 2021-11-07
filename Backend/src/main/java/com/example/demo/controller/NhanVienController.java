package com.example.demo.controller;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @GetMapping("/getall")
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @GetMapping("/getbyname/{name}")
    public List<NhanVien> getNhanVienByName(@PathVariable(value = "name") String name) {
        return  nhanVienRepository.findByName(name);
    }

    @GetMapping("/getbysdt/{sdt}")
    public List<NhanVien> getNhanVienBySDT(@PathVariable(value = "sdt") String sdt) {
        return  nhanVienRepository.findBySDT(sdt);
    }

    @GetMapping("/getlichhen/{date}")
    public List<NhanVien> getLichHen(@PathVariable(value = "date") Date date) {
        return  nhanVienRepository.findLichHen(date);
    }

    @GetMapping("/getbycmnd/{cmnd}")
    public List<NhanVien> getNhanVienBycmnd(@PathVariable(value = "cmnd") String cmnd) {
        return  nhanVienRepository.findByCMND(cmnd);
    }

    @GetMapping("/getbyRole/{id}")
    public List<NhanVien> getNhanVienByRole(@PathVariable(value = "id") Long id) {
        return  nhanVienRepository.findBacSy(id);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<NhanVien> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên có id : " + id));
        return ResponseEntity.ok().body(nhanVien);
    }
    @GetMapping("/getbytaikhoan/{taikhoan}")
    public NhanVien getByUser(@PathVariable(value = "taikhoan") String taikhoan)
            {
       return nhanVienRepository.findByUser(taikhoan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NhanVien> update(@PathVariable(value = "id") Long id,
                                                    @RequestBody NhanVien nhanviendetail) throws ResourceNotFoundException {
        NhanVien nhanVien =nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cập nhật thất bại nhân viên có id : " + id));
        nhanVien.setGioiTinh(nhanviendetail.isGioiTinh());
        nhanVien.setTen(nhanviendetail.getTen());
        nhanVien.setCmnd(nhanviendetail.getCmnd());
        nhanVien.setDiaChi(nhanviendetail.getDiaChi());
        nhanVien.setNgaySinh(nhanviendetail.getNgaySinh());
        nhanVien.setSoDienThoai(nhanviendetail.getSoDienThoai());
        final NhanVien updated = nhanVienRepository.save(nhanVien);
        return ResponseEntity.ok(updated);
    }  

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete( @PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Xóa thất bại nhân viên có id : " + id));

        nhanVienRepository.delete(nhanVien);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/insert")
    public NhanVien them( @RequestBody NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

}
