package com.pg.filetracking.model.request;

import lombok.Data;

@Data
public class FileRequest extends BaseRequest {
	
	 
	 private String fileName;
	 private String date;
	 private String fileType;
	 private String description;
	 private int isActive;
	 private String actionType;

}
