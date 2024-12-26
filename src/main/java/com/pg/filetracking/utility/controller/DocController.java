package com.pg.filetracking.utility.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.filetracking.utility.service.DocService;




@Controller
public class DocController {
	
  
  
    @Autowired
	DocService docService;
    

	 @RequestMapping(value = "/docConvter", method = RequestMethod.GET)
	    public String docConvter(HttpServletRequest req,HttpSession ses,HttpServletResponse response) {
	 
	    
	        return "docConvter";
	    }

    
		@RequestMapping(value = "/file-upload-submit", method = RequestMethod.POST)
		public @ResponseBody  String uploadFile(HttpServletRequest req,HttpSession ses, RedirectAttributes redir, HttpServletResponse res
				,@RequestParam("fileAttach") MultipartFile file)throws Exception 
		{

			
			String inputType=req.getParameter("inputType");
			String outputType=req.getParameter("outputType");
			
			
			
			/*
			 * try { res.setContentType("Application/octet-stream");
			 * 
			 * File my_file = new File(); System.out.println("my_file"+my_file);
			 * res.setHeader("Content-disposition","attachment; filename="+my_file.getName()
			 * ); OutputStream out = res.getOutputStream(); if(my_file.exists()) {
			 * FileInputStream in = new FileInputStream(my_file); byte[] buffer = new
			 * byte[4096]; //E:\New Project\document\DEM-1\DEM-1_EMD.pdf int length; while
			 * ((length = in.read(buffer)) > 0){ out.write(buffer, 0, length); } in.close();
			 * out.flush(); my_file.delete(); }else {
			 * System.out.println("Sorry Your file not Exist in local System!"); }
			 * 
			 * 
			 * }catch(Exception e) {
			 * 
			 * e.printStackTrace(); }
			 */
			
			
			
			
	return docService.convertFile(inputType, outputType, file);
			
		}
		
		
		
		
		@RequestMapping(value = "download-doc",method = RequestMethod.POST)
	    public void downloadlaoAttachment(HttpServletRequest req, HttpSession ses, HttpServletResponse res) throws Exception {
			String fileName=req.getParameter("fileName");
			
			try {
				res.setContentType("Application/octet-stream");	
				
				File my_file = new File(fileName);
				System.out.println("my_file"+my_file);
				 res.setHeader("Content-disposition","attachment; filename="+my_file.getName());
			      OutputStream out = res.getOutputStream();
			      if(my_file.exists()) {
			    	  FileInputStream in = new FileInputStream(my_file);
			    	  byte[] buffer = new byte[4096];
			    
				        int length;
				        while ((length = in.read(buffer)) > 0){
				           out.write(buffer, 0, length);
				        }
				        in.close();
				        out.flush();
				        my_file.delete();
			      }else {
			    	  System.out.println("Sorry Your file not Exist in local System!");
			      }
			       
			       
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
  
		 @RequestMapping(value = "/merger", method = RequestMethod.GET)
		    public String login(Model model, String error, String logout,HttpServletRequest req,HttpSession ses,HttpServletResponse response) {
		 
			// model.addAttribute("speechContentDto", new SpeechContentDto());
		        return "merger";
		    }
		 
			@RequestMapping(value = "/merger-submit", method = RequestMethod.POST)
			public @ResponseBody  String mergeFile(HttpServletRequest req,HttpSession ses, RedirectAttributes redir, HttpServletResponse res
					,@RequestParam("fileAttach") MultipartFile [] file)throws Exception 
			{

			
				
				
				
				
		return docService.mergeFile(file);
				
			}
			
			
		    @CrossOrigin
			 @RequestMapping(value = "/pdfViewer", method = RequestMethod.GET)
			    public String pdfViewer(Model model, String error, String logout,HttpServletRequest req,HttpSession ses,HttpServletResponse response) {
			 
			    
			        return "fileAttach";
			    }	
    
}
