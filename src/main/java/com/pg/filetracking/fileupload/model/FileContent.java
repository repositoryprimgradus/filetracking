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
@Table(name = "file_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileContentId;
	private String fileName;
    private String fileContent;
    private String fileBarcode;
    private String fileSubType;

}
