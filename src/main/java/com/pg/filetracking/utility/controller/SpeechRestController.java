package com.pg.filetracking.utility.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pg.filetracking.utility.dao.SpeechContentRepository;
import com.pg.filetracking.utility.entity.SpeechContent;


@RestController
public class SpeechRestController {

	@Autowired
	SpeechContentRepository repository;
	
	
	 @GetMapping(value = "/word", 
	            produces = "application/vnd.openxmlformats-"
	                    + "officedocument.wordprocessingml.document")
	    public ResponseEntity<InputStreamResource> word(@PathParam("id") Long id) 
	            throws IOException, InvalidFormatException {
		 Optional<SpeechContent> SpeechContent =repository.findById(id);
		 
	        ByteArrayInputStream bis = generateWord(SpeechContent);
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", 
	                "inline; filename=mydoc.docx");
	        return ResponseEntity.ok().headers(headers).
	                body(new InputStreamResource(bis));
	    }
	 
	 
	 
	 
	 public static ByteArrayInputStream generateWord( Optional<SpeechContent> SpeechContent)
	            throws FileNotFoundException, IOException, 
	                        InvalidFormatException {

	        try (XWPFDocument doc = new XWPFDocument()) {

	            XWPFParagraph p1 = doc.createParagraph();
	           // p1.setAlignment(ParagraphAlignment.CENTER);
	            // Set Text to Bold and font size to 22 for first paragraph
	            XWPFRun r1 = p1.createRun();
	            r1.setBold(false);
	            r1.setItalic(false);
	            r1.setFontSize(10);
	            r1.setText(SpeechContent.get().getContent());
	            r1.setFontFamily("Arial");
	            //r1.setColor("008000");
	            r1.addBreak();

	 

	          

	            ByteArrayOutputStream b = new ByteArrayOutputStream();
	            doc.write(b);
	            return new ByteArrayInputStream(b.toByteArray());
	        }

	    }
	
	 
}
