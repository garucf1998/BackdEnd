package com.example.demo.repository;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu,Long> {

    @Query(value = "select * from dich_vu where ghi_chu like ?1",nativeQuery = true)
    DichVu findByGhiChu(String ghichu);
}
