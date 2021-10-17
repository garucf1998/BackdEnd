package com.example.demo.controller;

import com.example.demo.enity.HoaDon;
import com.example.demo.enity.PhieuDichVu;
import com.example.demo.repository.PhieuDichVuRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phieudichvu")
public class PhieuDichVuController{
    @Autowired
    PhieuDichVuRepository dichVuRepository;

    @GetMapping("/getall")
    public List<PhieuDichVu> GetAll(){
        return dichVuRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<PhieuDichVu> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuDichVu phieuDichVu = dichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu dịch vụ có id : " + id));
        return ResponseEntity.ok().body(phieuDichVu);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PhieuDichVu> update(@PathVariable(value = "id") Long id,
                                                @RequestBody PhieuDichVu phieuDichVuDetail) throws ResourceNotFoundException {
        PhieuDichVu phieuDichVu =dichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cập nhật thất bại phiếu dịch vụ có id : " + id));
        phieuDichVu.setNgayTaoPhieu(phieuDichVuDetail.getNgayTaoPhieu());
        phieuDichVu.setDichVu(phieuDichVuDetail.getDichVu());
        phieuDichVu.setGhiChu(phieuDichVuDetail.getGhiChu());
        phieuDichVu.setKetLuan(phieuDichVuDetail.getKetLuan());
        phieuDichVu.setGiaTienDV(phieuDichVuDetail.getGiaTienDV());
        phieuDichVu.setPhieukhambenh(phieuDichVuDetail.getPhieukhambenh());
        final PhieuDichVu updated = dichVuRepository.save(phieuDichVu);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuDichVu phieuDichVu = dichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Xóa thất bại phiếu dịch vụ có id : " + id));

        dichVuRepository.delete(phieuDichVu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
 
    @PostMapping("/insert")
    public PhieuDichVu them( @RequestBody PhieuDichVu phieuDichVu) {
        return dichVuRepository.save(phieuDichVu);
    }

    @GetMapping("/getPhieuDichVuByPhieuKhamBenh/{id}")
    public List<PhieuDichVu> getPhieuDichVuByPhieuKhamBenh(@PathVariable("id") Long id) {
        return dichVuRepository.findListPhieuDichVuByPhieuKhamBenh(id);
    }
}
