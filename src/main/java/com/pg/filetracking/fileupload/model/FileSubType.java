package com.pg.filetracking.fileupload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_sub_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileSubType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileSubTypeId;
	private String fileSubTypeCode;
	private String fileSubTypeDesc;
}
