package com.pg.filetracking.fileupload.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_upload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpload {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileuploadId;
	private String fileBarcode;
	private String fileSubType;
	private Long fileContentId;
	private String fileCode;
	private String fileName;
	private String createdDate;
	private Long createdBy;
	private Long modifiedBy;
	private Date modifiedDate;
	private Integer isActive;
}
