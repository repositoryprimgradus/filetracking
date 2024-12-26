package com.pg.filetracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.filetracking.entity.FileInfo;

public interface FileRepository extends JpaRepository<FileInfo, Long>{

	FileInfo findByFileDetailsId(Long fileDetailsId);
	List<FileInfo> findByFileBarcode(String barcode);
	
}
