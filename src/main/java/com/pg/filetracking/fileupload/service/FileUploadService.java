package com.pg.filetracking.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public String uploadFile(String fileName, String uploadFileDetailsId, String fileBarcode, String uploadFileSubType, MultipartFile file)throws Exception;
	
	
}
