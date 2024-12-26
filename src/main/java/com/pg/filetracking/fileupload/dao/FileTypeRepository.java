package com.pg.filetracking.fileupload.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.pg.filetracking.fileupload.model.FileType;

@Repository
public interface FileTypeRepository  extends PagingAndSortingRepository<FileType,Long> {
	
	List<FileType> findAll();
	
	
}
