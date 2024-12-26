package com.pg.filetracking.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {

	public FileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String fileName;
    private String fileType;
    private String date;
    private String description;
    private Long fileDetailsId;
    private String fileBarcode;
    private String actionType;
}
