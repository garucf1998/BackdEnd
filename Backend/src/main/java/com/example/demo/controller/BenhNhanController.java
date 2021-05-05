package com.example.demo.controller;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.NhanVien;
import com.example.demo.enity.PhieuKhambenh;
import com.example.demo.repository.BenhNhanRepository;
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
@RequestMapping(value = "/benhnhan")
public class BenhNhanController {

    @Autowired
    BenhNhanRepository benhnhanRepository;
    @Autowired
    PhieuKhamRepository phieuKhamRepository;

    @GetMapping("/getall")
    public List<BenhNhan> getAll() {
        return benhnhanRepository.findAll();
    }
    @GetMapping("/getbyname/{name}")
    public List<BenhNhan> getBenhNhanByName(@PathVariable(value = "name") String name) {
        return  benhnhanRepository.findByName(name);
    }

    @GetMapping("/getbytaikhoan/{taikhoan}")
    public BenhNhan getByUser(@PathVariable(value = "taikhoan") String taikhoan)
    {
        return benhnhanRepository.findByUser(taikhoan);
    }

    @GetMapping("/getbysdt/{sdt}")
    public List<BenhNhan> getBenhNhanBySDT(@PathVariable(value = "sdt") String sdt) {
        return  benhnhanRepository.findBySDT(sdt);
    }

    @GetMapping("/getbycmnd/{cmnd}")
    public List<BenhNhan> getBenhNhanBycmnd(@PathVariable(value = "cmnd") String cmnd) {
        return  benhnhanRepository.findByCMND(cmnd);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<BenhNhan> getBenhNhanById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        BenhNhan benhNhan = benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(benhNhan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BenhNhan> updateNguoiDung(@PathVariable(value = "id") Long id,
                                                    @RequestBody BenhNhan benhnhandetail) throws ResourceNotFoundException {
        BenhNhan benhNhan =benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("nguoidung not found for this id :: " + id));
        benhNhan.setGioiTinh(benhnhandetail.isGioiTinh());
        benhNhan.setTen(benhnhandetail.getTen());
        benhNhan.setCmnd(benhnhandetail.getCmnd());
        benhNhan.setDiaChi(benhnhandetail.getDiaChi());
        benhNhan.setNgaySinh(benhnhandetail.getNgaySinh());
        benhNhan.setSoDienThoai(benhnhandetail.getSoDienThoai());
        final BenhNhan updated = benhnhanRepository.save(benhNhan);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete( @PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        BenhNhan benhNhan = benhnhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nguoi dung not found for this id :: " + id));

        benhnhanRepository.delete(benhNhan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/insert")
    public BenhNhan them( @RequestBody BenhNhan benhNhan) {
        return benhnhanRepository.save(benhNhan);
    }

    @GetMapping("/getlist/{id}")
    public List<PhieuKhambenh> GetAll(@PathVariable(value = "id") Long id){
        return getBenhNhanById(id).getBody().getDsphieukhambenh();
    }
}
