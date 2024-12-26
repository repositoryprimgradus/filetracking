package com.pg.filetracking.utility.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocService {
	
	public String convertFile(String inputType,String convertType,MultipartFile file)throws Exception;
	public String mergeFile(MultipartFile[] file)throws Exception;
}
