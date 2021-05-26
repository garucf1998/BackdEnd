package com.example.demo.controller;

import com.example.demo.enity.DonThuoc;
import com.example.demo.repository.DonThuocRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donthuoc")
public class DonThuocController {
    @Autowired
    DonThuocRepository donThuocRepository;

    @GetMapping("/getall")
    public List<DonThuoc> getAll() {
        return donThuocRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<DonThuoc> getThuocById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        DonThuoc donThuoc = donThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Don thuoc not found for this id :: " + id));
        return ResponseEntity.ok().body(donThuoc);
    }
    @PostMapping("/insert")
    public DonThuoc them(@RequestBody DonThuoc donThuoc) {
        return donThuocRepository.save(donThuoc);
    }

}
