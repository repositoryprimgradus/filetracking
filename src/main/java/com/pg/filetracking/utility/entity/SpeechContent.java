package com.pg.filetracking.utility.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "speech_content")
@Where(clause = "isActive =1")
@Data
public class SpeechContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speechContentId;
    private String content;
    private Long createdBy;
    private String createdDate;
    private Long modifiedBy;
    private String modifiedDate;
    private int isActive;

}
