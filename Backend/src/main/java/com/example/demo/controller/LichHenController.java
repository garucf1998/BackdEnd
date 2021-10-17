package com.example.demo.controller;

import com.example.demo.enity.LichHen;
import com.example.demo.repository.LichHenRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lichhen")
public class LichHenController {
    @Autowired
    private LichHenRepository lichHenRepository;
    @PostMapping("/insert")
    public LichHen them(@RequestBody LichHen lichHen) {
        return lichHenRepository.save(lichHen);
    }

    @GetMapping("/getlichhen/{date}/{id}")
    public List<String> getLichHen(@PathVariable(value = "date") String dates,@PathVariable(value = "id") Long id)  {

        return  lichHenRepository.findListBN(dates,id);
    }

    @GetMapping("/getlichhenbybn/{id}")
    public List<LichHen> getLichHenByBN(@PathVariable(value = "id") Long id)  {

        return  lichHenRepository.findLichHenByBN(id);
    }

    @GetMapping("/getlichhenbydate/{date}")
    public List<LichHen> getLichHenByDate(@PathVariable(value = "date") String date)  {

        return  lichHenRepository.findLichHenByDate(date);
    }

    @GetMapping("/getall")
    public List<LichHen> GetAll(){
        return lichHenRepository.findAll();
    }

    @GetMapping("/ktralichhennv/{date}/{id}")
    public List<LichHen> ktralichhenNV(@PathVariable("date") String date,@PathVariable("id")Long id){
        return lichHenRepository.findLichHenByDateAndIDNV(date,id);
    }

    @GetMapping("/ktralichhenbn/{date}/{id}")
    public LichHen ktralichhenBN(@PathVariable("date") String date,@PathVariable("id")Long id){
        return lichHenRepository.findLichHenByDateAndIDBN(date,id);
    }


    @GetMapping("/getone/{id}")
    public ResponseEntity<LichHen> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        LichHen lichHen = lichHenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch hẹn có id : " + id));
        return ResponseEntity.ok().body(lichHen);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        LichHen lichHen = lichHenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Xóa thất bại lịch hẹn có id : " + id));

        lichHenRepository.delete(lichHen);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LichHen> update(@PathVariable(value = "id") Long id,
                                           @RequestBody LichHen lichhendetail) throws ResourceNotFoundException {
        LichHen lichHen =lichHenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cập nhật thất bại lịch hẹn có id : " + id));
        lichHen.setTrangThai(lichhendetail.getTrangThai());

        final LichHen updated = lichHenRepository.save(lichHen);
        return ResponseEntity.ok(updated);
    }
}
