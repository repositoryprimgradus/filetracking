package com.pg.filetracking.utility.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pg.filetracking.utility.entity.SpeechContent;



@Repository
public interface SpeechContentRepository  extends PagingAndSortingRepository<SpeechContent,Long> {
	
	List<SpeechContent> findAll();

}
