package com.pg.filetracking.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "file_status")
@Data
public class FileStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileStatusId;
	  private Long fileDetailsId;
	private String comment;

    private String fileStatus;
    private String date;
    private String createdBy;
    
    
}
