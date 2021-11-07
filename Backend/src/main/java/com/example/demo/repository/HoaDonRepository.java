package com.example.demo.repository;

import com.example.demo.enity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Long> {
    @Query(value = "select * from hoadon join phieu_khambenh on hoadon.phieukhambenh_id=phieu_khambenh.id join benh_nhan on benh_nhan.id=phieu_khambenh.benh_nhan_id where  phieu_khambenh.benh_nhan_id like ?1",nativeQuery = true)
    List<HoaDon> findListHoaDonChuaThanhToan(Long idbn);
}
