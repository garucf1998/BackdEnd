package com.example.demo.controller;

import com.example.demo.enity.DichVu;
import com.example.demo.enity.Thuoc;
import com.example.demo.repository.ThuocRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thuoc")
public class ThuocController {
    @Autowired
    ThuocRepository thuocRepository;

    @GetMapping("/getall")
    public List<Thuoc> getAll() {
        return thuocRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Thuoc> getThuocById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Thuoc thuoc = thuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Thuoc not found for this id :: " + id));
        return ResponseEntity.ok().body(thuoc);
    }
    @GetMapping("/getbytenthuoc/{tenthuoc}")
    public Thuoc getbytenthuoc(@PathVariable(value ="tenthuoc") String tenthuoc) {
        return thuocRepository.findByTenThuoc(tenthuoc);
    }
}
