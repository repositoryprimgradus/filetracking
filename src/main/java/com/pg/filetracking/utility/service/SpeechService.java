package com.pg.filetracking.utility.service;

import java.util.List;

import com.pg.filetracking.utility.entity.SpeechContent;



public interface SpeechService {

	public Long saveSpeechContent(String speechContent, Long loginId) throws Exception;
	public List<SpeechContent> getSpeechContent() throws Exception;
	
}
