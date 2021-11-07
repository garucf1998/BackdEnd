package com.example.demo.repository;

import com.example.demo.enity.LichHen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LichHenRepository extends JpaRepository<LichHen,Long> {
    @Query(value = "select benh_nhan_id from lich_hen  where thoi_gian like ?1% and nhan_vien_id like ?2 and trang_thai !='2'",nativeQuery = true)
    List<String> findListBN(String date , Long id);

    @Query(value = "select * from lich_hen  where thoi_gian like ?1% and nhan_vien_id like ?2",nativeQuery = true)
    List<LichHen> findLichHenByDateAndIDNV(String date, Long id);

    @Query(value = "select * from lich_hen  where thoi_gian like ?1% and benh_nhan_id like ?2",nativeQuery = true)
    LichHen findLichHenByDateAndIDBN(String date, Long id);

    @Query(value = "select * from lich_hen  where benh_nhan_id like ?1",nativeQuery = true)
    List<LichHen> findLichHenByBN( Long id);

    @Query(value = "select * from lich_hen  where thoi_gian like ?1% ",nativeQuery = true)
    List<LichHen> findLichHenByDate(String date);
}
