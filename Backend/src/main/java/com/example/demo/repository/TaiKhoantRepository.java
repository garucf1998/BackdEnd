package com.example.demo.repository;

import com.example.demo.enity.NhanVien;
import com.example.demo.enity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoantRepository extends JpaRepository<TaiKhoan,String> {
	 @Query(value = "select * from tai_khoan where username like ?1",nativeQuery = true)
	    TaiKhoan findByUser(String username);
}
