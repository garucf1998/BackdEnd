package com.example.demo.repository;

import com.example.demo.enity.HoaDon;
import com.example.demo.enity.PhieuDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDichVuRepository extends JpaRepository<PhieuDichVu,Long> {
    @Query(value = "select * from phieu_dich_vu join phieu_khambenh on phieu_dich_vu.phieukhambenh_id=phieu_khambenh.id where phieu_khambenh.id like ?1",nativeQuery = true)
    List<PhieuDichVu> findListPhieuDichVuByPhieuKhamBenh(Long idpk);

    @Query(value = "select * from phieu_dich_vu join phieu_khambenh on phieu_dich_vu.phieukhambenh_id=phieu_khambenh.id where phieu_khambenh.benhnhan_id like ?1",nativeQuery = true)
    List<PhieuDichVu> findListPhieuDichVuByBenhNhanID(Long id);
}
