package com.example.demo.controller;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.DichVu;
import com.example.demo.repository.DichVuRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dichvu")
public class DichVuController {
    @Autowired
    DichVuRepository dichVuRepository;

    @GetMapping("/getall")
    public List<DichVu> getAll() {
        return dichVuRepository.findAll();
    }

    @GetMapping("/getbyghichu/{ghichu}")
    public DichVu getbyghichu(@PathVariable(value ="ghichu") String ghichu) {
        return dichVuRepository.findByGhiChu(ghichu);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<DichVu> getBenhNhanById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        DichVu dichVu = dichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy dịch vụ có id : " + id));
        return ResponseEntity.ok().body(dichVu);
    }
}
