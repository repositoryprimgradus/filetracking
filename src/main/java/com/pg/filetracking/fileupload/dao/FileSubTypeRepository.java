package com.pg.filetracking.fileupload.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pg.filetracking.fileupload.model.FileSubType;

@Repository
public interface FileSubTypeRepository  extends PagingAndSortingRepository<FileSubType,Long> {
	
	List<FileSubType> findAll();
	
	
}
