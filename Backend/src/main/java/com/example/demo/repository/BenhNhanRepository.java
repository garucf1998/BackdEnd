package com.example.demo.repository;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface BenhNhanRepository extends JpaRepository<BenhNhan,Long> {
	@Query(value = "select * from benh_nhan where ten like %?1%",nativeQuery = true)
	List<BenhNhan> findByName(String ten);

	@Query(value = "select * from benh_nhan where so_dien_thoai like %?1%",nativeQuery = true)
	List<BenhNhan> findBySDT(String sdt);

	@Query(value = "select * from benh_nhan where cmnd like %?1%",nativeQuery = true)
	List<BenhNhan> findByCMND(String cmnd);

	@Query(value = "select * from benh_nhan where tai_khoan_username like ?1",nativeQuery = true)
	BenhNhan findByUser(String username);
}

