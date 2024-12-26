package com.pg.filetracking.model.response;

import java.util.List;

import com.pg.filetracking.entity.FileDto;

import lombok.Data;


@Data
public class FileResponse extends BaseResponse{
	
	private List<FileDto> FileDto;
	 
	 private Object data;

}
