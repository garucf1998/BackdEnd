package com.example.demo.controller;

import com.example.demo.enity.ChiTietDonThuoc;
import com.example.demo.enity.DonThuoc;
import com.example.demo.repository.ChiTietDonThuocRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chitietdonthuoc")
public class ChiTietDonThuocController {
    @Autowired
    ChiTietDonThuocRepository chiTietDonThuocRepository;

    @GetMapping("/getall")
    public List<ChiTietDonThuoc> getAll() {
        return chiTietDonThuocRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<ChiTietDonThuoc> getThuocById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ChiTietDonThuoc chiTietDonThuoc = chiTietDonThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy chi tiết đơn thuốc có id : " + id));
        return ResponseEntity.ok().body(chiTietDonThuoc);
    }
    @PostMapping("/insert")
    public ChiTietDonThuoc them(@RequestBody ChiTietDonThuoc chiTietDonThuoc) {
        return chiTietDonThuocRepository.save(chiTietDonThuoc);
    }
    @GetMapping("/getallbydonthuoc/{id}")
    public List<ChiTietDonThuoc> getallbydonthuoc(@PathVariable("id")Long id){
        return chiTietDonThuocRepository.findByIDDonThuoc(id);
    }
    @GetMapping("/getallbybenhnhan/{id}")
    public List<ChiTietDonThuoc> getallbybenhnhan(@PathVariable("id")Long id){
        return chiTietDonThuocRepository.findByIDBenhNhan(id);
    }
}
