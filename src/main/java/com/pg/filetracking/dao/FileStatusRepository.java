package com.pg.filetracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pg.filetracking.entity.FileStatus;

public interface FileStatusRepository extends JpaRepository<FileStatus, Long>{

	@Query("Select s from FileStatus s , FileInfo f where s.fileDetailsId=f.fileDetailsId and f.fileBarcode=:barcode")
	List<FileStatus> findByFileBarcode(String barcode);

}
