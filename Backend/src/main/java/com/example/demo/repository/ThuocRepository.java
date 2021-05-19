package com.example.demo.repository;

import com.example.demo.enity.DichVu;
import com.example.demo.enity.Thuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuocRepository extends JpaRepository<Thuoc,Long> {
    @Query(value = "select * from thuoc where ten_thuoc like %?1%",nativeQuery = true)
    Thuoc findByTenThuoc(String tenthuoc);

}
