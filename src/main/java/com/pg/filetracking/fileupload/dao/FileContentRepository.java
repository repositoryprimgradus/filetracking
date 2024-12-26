package com.pg.filetracking.fileupload.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pg.filetracking.fileupload.model.FileContent;


@Repository
public interface FileContentRepository  extends PagingAndSortingRepository<FileContent,Long> {
	
	List<FileContent> findAll();
	@Query("Select c from FileContent c where c.fileContent like %:content%")
	List<FileContent> findByContaining(String content);

}
