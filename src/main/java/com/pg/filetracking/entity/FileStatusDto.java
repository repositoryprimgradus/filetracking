package com.pg.filetracking.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileStatusDto {
	
	private Long fileDetailsId;
  private String fileStatus;
  private String date;
  private String createdBy;

}
