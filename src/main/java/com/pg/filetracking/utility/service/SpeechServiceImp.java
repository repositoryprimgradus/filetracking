package com.pg.filetracking.utility.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.filetracking.utility.dao.SpeechContentRepository;
import com.pg.filetracking.utility.entity.SpeechContent;



@Service
public class SpeechServiceImp implements SpeechService {

	
 @Autowired
SpeechContentRepository speechContentRepository;

 private SimpleDateFormat sdfDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
 
@Override
public Long saveSpeechContent(String speechContent, Long loginId) throws Exception {
	
	SpeechContent speech = new SpeechContent();
	
	speech.setContent(speechContent);
	
	
	speech.setCreatedBy(loginId);
	speech.setCreatedDate(sdfDateTime.format(new Date()));
	speech.setIsActive(1);
	speech=speechContentRepository.save(speech);
	
	
	
	return speech.getSpeechContentId();
}


@Override
public List<SpeechContent> getSpeechContent() throws Exception {
	
	return speechContentRepository.findAll();
}


 
 
 
 
}
