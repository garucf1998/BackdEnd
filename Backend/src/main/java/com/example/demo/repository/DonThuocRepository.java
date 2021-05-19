package com.example.demo.repository;

import com.example.demo.enity.DonThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonThuocRepository extends JpaRepository<DonThuoc,Long> {
}
