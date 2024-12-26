package com.pg.filetracking.fileupload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.filetracking.dao.FileRepository;
import com.pg.filetracking.entity.FileInfo;
import com.pg.filetracking.fileupload.dao.FileContentRepository;
import com.pg.filetracking.fileupload.dao.FileSubTypeRepository;
import com.pg.filetracking.fileupload.dao.FileTypeRepository;
import com.pg.filetracking.fileupload.dao.FileUploadRepository;
import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileSubType;
import com.pg.filetracking.fileupload.model.FileType;
import com.pg.filetracking.fileupload.model.FileUpload;
import com.pg.filetracking.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {


	
	@Autowired
	FileTypeRepository  fileTypeRepository;
	
	@Autowired
	FileSubTypeRepository  fileSubTypeRepository;
	
	@Autowired
	FileUploadRepository  fileUploadRepository;
	
	@Autowired
	FileRepository  fileRepository;
	
	@Autowired
	FileUploadService  fileUploadService;


	@Value("${file_upload_path}")
	String uploadpath;
	

	
	@Autowired
	FileContentRepository fileContentRepository;
    @RequestMapping(value = "/fileUploadView", method = RequestMethod.GET)
    public String fileUpload(HttpServletRequest req,HttpSession ses) throws Exception {
   
    	
     
     return "fileupload/fileUpload";
    }
    
    @RequestMapping(value = "/getSearchFileNumber", method = RequestMethod.GET)
	public @ResponseBody List<FileInfo> getSeachProduct(HttpSession ses,HttpServletRequest req) throws Exception {
		
    	String fileInput=req.getParameter("fileInput");

    	List<FileInfo> fileInfo=fileRepository.findByFileBarcode(fileInput);

			return fileInfo;	
	}
    
    
	@RequestMapping(value = "/uploadFileList", method = RequestMethod.GET)
	public @ResponseBody List<FileUpload> uploadFileList(HttpSession ses, HttpServletRequest req) throws Exception {

		String fileBarcode = req.getParameter("fileBarcode");
	
		List<FileUpload> uploadFileList = fileUploadRepository.findByfileBarcode(fileBarcode);
		
		return uploadFileList;
	}

    
    
    @RequestMapping(value = "/fileTypeList", method = RequestMethod.GET)
    public @ResponseBody List<FileType>  fileTypeList(HttpServletRequest req,HttpSession ses) throws Exception {
   
    	List<FileType> fileTypeList=fileTypeRepository.findAll();
     
     return fileTypeList;
    }
    
    
    @RequestMapping(value = "/fileSubTypeList", method = RequestMethod.GET)
    public @ResponseBody List<FileSubType>  fileSubTypeList(HttpServletRequest req,HttpSession ses) throws Exception {
   
    	List<FileSubType> fileSubTypeList=fileSubTypeRepository.findAll();
     
     return fileSubTypeList;
    }
    

	@RequestMapping(value = "/fileupload-submit", method = RequestMethod.POST)
	public @ResponseBody  String uploadFile(HttpServletRequest req,HttpSession ses, RedirectAttributes redir
			,@RequestParam("filecode") MultipartFile file)throws Exception 
	{

	
		
		String fileName=req.getParameter("fileName");
		String fileBarcode=req.getParameter("fileBarcode");
		String uploadFileDetailsId=req.getParameter("uploadFileDetailsId");
		String uploadFileSubType=req.getParameter("file_sub_type");
	
		return fileUploadService.uploadFile(fileName,uploadFileDetailsId, fileBarcode,uploadFileSubType, file);
		
	}
	
	
	@RequestMapping(value = "/getFileUploadCount", method = RequestMethod.GET)
	public @ResponseBody Long getFileUploadCount(HttpSession ses,HttpServletRequest req) throws Exception {
		
    	String fileBarcode=req.getParameter("fileBarcode");
    	String fileSubType=req.getParameter("fileSubType");

    	Long count=fileUploadRepository.countByFileBarcodeAndFileSubType(fileBarcode, fileSubType);

			return count;	
	}
	
	
	   @RequestMapping(value = "/getFileUploadDetails", method = RequestMethod.GET)
		public @ResponseBody List<FileContent> getFileUploadDetails(HttpSession ses,HttpServletRequest req) throws Exception {
			
	    	//String demandNo=req.getParameter("demandNo");

	    //	List<FileContent> demand= repository.findByDemandNoAllFile(demandNo);
	    	List<FileContent> file=fileContentRepository.findAll();
	    	System.out.println("demand"+file);
				return file;	
		}
	   
	   @RequestMapping(value = "/demandDataFileUpload", method = RequestMethod.GET)
		public @ResponseBody List<FileUpload> demandDatas(HttpSession ses,HttpServletRequest req) throws Exception {
			
	    	String demandId=req.getParameter("demandId");
	 
	    	List<FileUpload> demand=null;
	
				return demand;	
		}
	   
	   
	   @RequestMapping(value = "download-attachment",method = RequestMethod.GET)
	    public void downloadlaoAttachment(HttpServletRequest req, HttpSession ses, HttpServletResponse res) throws Exception {
			String fileName=req.getParameter("fileName");
			System.out.println("fileName"+fileName);
			String fileBarcode=req.getParameter("fileBarcode");
		//	uploadpath=uploadpath+"/"+demandNo;
			System.out.println("uploadpath"+uploadpath);
			try {
				res.setContentType("Application/octet-stream");	
				
				File my_file = new File(uploadpath+"/"+fileBarcode+File.separator+fileName);
				System.out.println("my_file"+my_file);
				 res.setHeader("Content-disposition","attachment; filename="+fileName);
			      OutputStream out = res.getOutputStream();
			      if(my_file.exists()) {
			    	  FileInputStream in = new FileInputStream(my_file);
			    	  byte[] buffer = new byte[4096];
			    	  //E:\New Project\document\DEM-1\DEM-1_EMD.pdf
				        int length;
				        while ((length = in.read(buffer)) > 0){
				           out.write(buffer, 0, length);
				        }
				        in.close();
				        out.flush();
			      }else {
			    	  System.out.println("Sorry Your file not Exist in local System!");
			      }
			       
			       
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	   
	   
	   
	
	   
	   
	    @RequestMapping(value = "/fileSearch.htm", method = RequestMethod.GET)
	    public String fileSearch(HttpServletRequest req,HttpSession ses) throws Exception {
	   
	    	
	     
	     return "static/FileSearch";
	    }
		
	    
	    @RequestMapping(value = "/fileSearch", method = RequestMethod.POST)
		public String FileSearch(HttpServletRequest req,HttpSession ses, RedirectAttributes redir)throws Exception 
		{
			
		
			

			String FileContent=req.getParameter("FileContent");
			List<FileContent> fileList=fileContentRepository.findByContaining(FileContent);
			  
			 req.setAttribute("fileList", fileList);
			return "static/FileSearch";
			
		}	
}
