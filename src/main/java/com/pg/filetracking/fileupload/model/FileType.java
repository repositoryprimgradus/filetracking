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
@Table(name = "file_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FileTypeId;
	private String FileCode;
	private String FileType;
}
