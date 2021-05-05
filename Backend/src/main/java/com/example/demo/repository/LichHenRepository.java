package com.example.demo.repository;

import com.example.demo.enity.LichHen;
import com.example.demo.enity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LichHenRepository extends JpaRepository<LichHen,Long> {
    @Query(value = "select benhnhan_id from lich_hen  where thoi_gian like ?1%",nativeQuery = true)
    List<String> findLichHen(String date);
}
