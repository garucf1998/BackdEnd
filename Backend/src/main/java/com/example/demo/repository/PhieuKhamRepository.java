package com.example.demo.repository;

import com.example.demo.enity.NhanVien;
import com.example.demo.enity.PhieuKhambenh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhieuKhamRepository extends JpaRepository<PhieuKhambenh,Long> {
    @Query(value = "select * from phieu_khambenh inner join benh_nhan on benh_nhan.id =phieu_khambenh.benhnhan_id where benh_nhan.id like ?1",nativeQuery = true)
    List<PhieuKhambenh> findPhieuKhamByIdBenhNhan(Long id);
}
