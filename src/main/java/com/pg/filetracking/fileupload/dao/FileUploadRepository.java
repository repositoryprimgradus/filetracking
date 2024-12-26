package com.pg.filetracking.fileupload.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileUpload;

@Repository
public interface FileUploadRepository  extends JpaRepository<FileUpload,Long> {
	
	List<FileUpload> findAll();
	List<FileUpload> findByfileBarcode(String fileBarcode);
	List<FileUpload> findByfileSubType(String fileSubType);
	Long countByFileBarcodeAndFileSubType(String fileBarcode,String fileSubType);
}
