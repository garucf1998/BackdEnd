 package com.example.demo.controller;

import com.example.demo.enity.HoaDon;
import com.example.demo.enity.NhanVien;
import com.example.demo.enity.PhieuDichVu;
import com.example.demo.repository.HoaDonRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoadon")
public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @GetMapping("/getall")
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<HoaDon> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy hóa đơn có id : " + id));
        return ResponseEntity.ok().body(hoaDon);
    } 

    @PostMapping("/insert")
    public HoaDon them(@RequestBody HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @GetMapping("/getHoaDonChuaThanhToan/{id}")
    public List<HoaDon> getHoaDonChuaThanhToan(@PathVariable("id") Long id) {
        return hoaDonRepository.findListHoaDonChuaThanhToan(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HoaDon> update(@PathVariable(value = "id") Long id,
                                           @RequestBody HoaDon hoadondetail) throws ResourceNotFoundException {
        HoaDon hoaDon =hoaDonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cập nhật thất bại hóa đơn có id : " + id));
        hoaDon.setTrangThai(hoadondetail.isTrangThai());

        final HoaDon updated = hoaDonRepository.save(hoaDon);
        return ResponseEntity.ok(updated);
    }
}
