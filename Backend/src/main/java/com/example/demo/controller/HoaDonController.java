package com.example.demo.controller;

import com.example.demo.enity.HoaDon;
import com.example.demo.enity.PhieuDichVu;
import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/insert")
    public HoaDon them(@RequestBody HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    @GetMapping("/getHoaDonChuaThanhToan/{id}")
    public List<HoaDon> getHoaDonChuaThanhToan(@PathVariable("id") Long id) {
        return hoaDonRepository.findListHoaDonChuaThanhToan(id);
    }
}
