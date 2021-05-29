package com.example.demo.repository;

import com.example.demo.enity.ChiTietDonThuoc;
import com.example.demo.enity.Thuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietDonThuocRepository extends JpaRepository<ChiTietDonThuoc,Long> {

    @Query(value = "select * from chi_tiet_don_thuoc where donthuoc_id like ?1",nativeQuery = true)
    List<ChiTietDonThuoc> findByIDDonThuoc(Long id);

    @Query(value = "select * from chi_tiet_don_thuoc join don_thuoc on don_thuoc.id = chi_tiet_don_thuoc.donthuoc_id join phieu_khambenh on phieu_khambenh.donthuoc_id=don_thuoc.id where phieu_khambenh.benhnhan_id like ?1",nativeQuery = true)
    List<ChiTietDonThuoc> findByIDBN(Long id);
}
