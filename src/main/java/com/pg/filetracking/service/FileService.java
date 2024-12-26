package com.pg.filetracking.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pg.filetracking.entity.FileInfo;
import com.pg.filetracking.fileupload.model.FileType;
import com.pg.filetracking.model.request.FileRequest;
import com.pg.filetracking.model.request.FileStatusRequest;
import com.pg.filetracking.model.request.PagingRequest;
import com.pg.filetracking.model.response.FileResponse;

@Service
public interface FileService {

	Long saveFile(FileRequest fileRequest)throws ParseException;

	FileResponse viewFileTable();
	
	FileInfo fileDetails(Long fileDetailsId);
	public File getBarcode4j(String productname)throws Exception;
	public  ByteArrayInputStream employeePDFReport(FileInfo fileInfo) throws Exception;

	Long saveFileStatus(FileStatusRequest fileStatusRequest, String userName);
	//public  Long pdfToWord() throws Exception;
	public List<FileType>  fileTypeList()throws Exception;
}
