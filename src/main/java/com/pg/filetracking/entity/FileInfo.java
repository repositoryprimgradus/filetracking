package com.pg.filetracking.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;



import lombok.Data;

@Entity
@Table(name = "file_details")
@Where(clause = "isActive =1")
@Data
public class FileInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileDetailsId;
    private Long loginId;
    private String fileName;
    private String fileType;
    private Date date;
    private String description;
    private int IsActive;
    private String fileBarcode;
    private String CreatedBy;
    private String CreatedDate;
    private String ModifiedBy;
    private String ModifiedDate;

}
