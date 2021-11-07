package com.example.demo.controller;

import com.example.demo.enity.PhieuKhambenh;
import com.example.demo.repository.PhieuKhamRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phieukham")
public class PhieuKhamController {

    @Autowired
    PhieuKhamRepository phieuKhamRepository;

    @GetMapping("/getall")
    public List<PhieuKhambenh> GetAll(){
        return phieuKhamRepository.findAll();
    }

    @GetMapping("/getphieukhambybenhnhanid/{id}")
    public List<PhieuKhambenh> GetAllPhieuKhamByBenhNhanId(@PathVariable(value = "id") Long id){
        return phieuKhamRepository.findPhieuKhamByIdBenhNhan(id);
    }


    @GetMapping("/getone/{id}")
    public ResponseEntity<PhieuKhambenh> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh = phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu khám bệnh có id : " + id));
        return ResponseEntity.ok().body(phieuKhambenh);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PhieuKhambenh> update(@PathVariable(value = "id") Long id,
                                                    @RequestBody PhieuKhambenh phieukhambenhdetail) throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh =phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cập nhật thất bại phiếu khám bệnh có id :" + id));
        phieuKhambenh.setNgayLapPhieu(phieuKhambenh.getNgayLapPhieu());
        phieuKhambenh.setChanDoan(phieukhambenhdetail.getChanDoan());
        phieuKhambenh.setNhanvien(phieukhambenhdetail.getNhanvien());
        phieuKhambenh.setBenhnhan(phieukhambenhdetail.getBenhnhan());
        phieuKhambenh.setDonthuoc(phieukhambenhdetail.getDonthuoc());
        phieuKhambenh.setTienKham(phieukhambenhdetail.getTienKham());
        phieuKhambenh.setTrieuChung(phieukhambenhdetail.getTrieuChung());
        phieuKhambenh.setTrangThai(phieukhambenhdetail.isTrangThai());
        phieuKhambenh.setDsphieudichvu(phieukhambenhdetail.getDsphieudichvu());
        final PhieuKhambenh updated = phieuKhamRepository.save(phieuKhambenh);
        return ResponseEntity.ok(updated);
    }
  
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh = phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Xóa thất bại phiếu khám bệnh có id : " + id));

        phieuKhamRepository.delete(phieuKhambenh);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
    public PhieuKhambenh them(@RequestBody PhieuKhambenh phieuKhambenh) {
        return phieuKhamRepository.save(phieuKhambenh);
    }

}
