package com.pg.filetracking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.filetracking.dao.FileRepository;
import com.pg.filetracking.dao.FileStatusRepository;
import com.pg.filetracking.entity.FileInfo;
import com.pg.filetracking.entity.FileStatus;
import com.pg.filetracking.entity.FileStatusDto;
import com.pg.filetracking.fileupload.dao.FileContentRepository;
import com.pg.filetracking.fileupload.dao.FileUploadRepository;
import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileUpload;
import com.pg.filetracking.model.request.FileRequest;
import com.pg.filetracking.model.request.FileStatusRequest;
import com.pg.filetracking.model.response.FileResponse;
import com.pg.filetracking.service.FileService;

@Controller
public class FileController {

	@Autowired
	FileService fileService;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FileStatusRepository fileStatusRepository;
	
	@Autowired
	FileUploadRepository  fileUploadRepository;
	
	@Autowired
	FileContentRepository  fileContentRepository;
	

	SimpleDateFormat userFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfSqlDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	private SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@GetMapping({ "/createFile" })
	public String createFile(Model model, HttpServletRequest req, HttpSession ses) {
		try {

			model.addAttribute("createFile", new FileRequest());
			model.addAttribute("fileTypeList", fileService.fileTypeList());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "createFile";
	}

	@PostMapping("/saveFile")
	public String saveUpdateFile(FileRequest fileRequest, HttpSession ses, BindingResult re, Model model,
			RedirectAttributes redir) {
		@SuppressWarnings("unused")
		FileResponse fileResponse = new FileResponse();
		fileRequest.setActionType("INSERT");
		fileRequest.setUserName(null);
		Long result = null;
		try {
			result = fileService.saveFile(fileRequest);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (result != null)
			redir.addFlashAttribute("result", "File Info saved");
		return "redirect:/welcome";
	}

	@PostMapping(value = { "viewFileInTable" })
	public @ResponseBody FileResponse viewFileInTable(HttpSession ses) {

		FileResponse fileResponse = new FileResponse();
		try {
			fileResponse = fileService.viewFileTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		fileResponse.setData(fileResponse.getFileDto());

		return fileResponse;
	}

	@GetMapping({ "/searchFile" })
	public String searchFile(Model model, HttpServletRequest req, HttpSession ses) {
		try {

			model.addAttribute("createFile", new FileRequest());
			model.addAttribute("fileStatus", new FileStatusRequest());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "searchFile";
	}

	@RequestMapping(value = "/fileData", method = RequestMethod.GET)
	public @ResponseBody FileInfo fileData(HttpSession ses, HttpServletRequest req) throws Exception {

		String demandid = req.getParameter("demandId");

		FileInfo fileInfo = fileRepository.findByFileBarcode(demandid).get(0);
		return fileInfo;
	}

	@GetMapping({ "/printFile" })
	public ResponseEntity<Resource> printFile(Model model, HttpServletRequest req, HttpSession ses) throws Exception {

		String fileDetailsId = req.getParameter("printFileId");

		FileInfo fileInfo = fileService.fileDetails(Long.valueOf(fileDetailsId));
		// model.addAttribute("fileDetailes",fileInfo );
		// model.addAttribute("barcode",
		// fileService.employeePDFReport(fileInfo.getFileBarcode()));

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileInfo.getFileBarcode() + ".pdf");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		// Path path = Paths.get(file.getAbsolutePath());
		InputStreamResource resource = new InputStreamResource(fileService.employeePDFReport(fileInfo));

		return ResponseEntity.ok().headers(header)
				// .contentLength(fileService.employeePDFReport(fileInfo.getFileBarcode()).length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);

	}

	@PostMapping("/saveFileStatus")
	public @ResponseBody Long saveFileStatus(@RequestBody FileStatusRequest fileStatusRequest, HttpSession ses,
			BindingResult re, Model model, RedirectAttributes redir) {

		Long result = null;
		try {
			result = fileService.saveFileStatus(fileStatusRequest, (String) ses.getAttribute("Username"));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("null")
	@GetMapping("/fetchFileStatus")
	public @ResponseBody List<FileStatusDto> fetchFileStatus(HttpSession ses, HttpServletRequest req) {

		List<FileStatus> result = null;
		List<FileStatusDto> fileStatusDto = new ArrayList<>();

		try {
			System.out.println("Demand Id" + req.getParameter("demandId"));
			result = fileStatusRepository.findByFileBarcode(req.getParameter("demandId"));
		

			for (FileStatus fileSt : result) {
				FileStatusDto fileStatus = new FileStatusDto();
				fileStatus.setFileDetailsId(fileSt.getFileDetailsId());
				fileStatus.setFileStatus(fileSt.getFileStatus());
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				Date sqldate = new java.sql.Date(sdfDateTime.parse(fileSt.getDate()).getTime());

				fileStatus.setDate(sdf1.format(sqldate));
				fileStatus.setCreatedBy(fileSt.getCreatedBy());

				fileStatusDto.add(fileStatus);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fileStatusDto;
	}

	@GetMapping({ "/listShow" })
	public String showFile(Model model, HttpServletRequest req, HttpSession ses) {

		return "listShow";
	}
	
	
	 @RequestMapping(value = "/fileTypeSearch.htm", method = RequestMethod.GET)
	 public String fileTypeSearch(HttpServletRequest req,HttpSession ses) throws Exception {
	   
			
	     return "FileTypeSearch";
	    }
	 
	 
	 @RequestMapping(value = "/fileSubTypeSearch.htm", method = RequestMethod.GET)
	 public @ResponseBody List<FileUpload> fileSubTypeSearch(HttpServletRequest req,HttpSession ses) throws Exception {
	   
			String searchType = req.getParameter("searchType");
			String searchData = req.getParameter("searchData");
			List<FileUpload> fileUploadList=new ArrayList<FileUpload>();
		 if(searchType.equalsIgnoreCase("FILE-BARCODE")) {
			 fileUploadList=fileUploadRepository.findByfileBarcode(searchData); 
		 }
		 else if(searchType.equalsIgnoreCase("FILE-TYPE")) {
			 
		 }else if(searchType.equalsIgnoreCase("FILE-SUB-TYPE")) {
			 fileUploadList=fileUploadRepository.findByfileSubType(searchData);
			 
		 }else {
			 List<FileContent> fileContentList= fileContentRepository.findByContaining(searchData);
			 
			 fileUploadList=fileContentList.stream().map(c -> {FileUpload fileUpload=new FileUpload();
			 fileUpload.setFileName(c.getFileName());
			 fileUpload.setFileBarcode(c.getFileBarcode());
			 fileUpload.setFileSubType(c.getFileSubType());
			 return fileUpload;
			 }).collect(Collectors.toList());
		 }
		 
	     
	     return fileUploadList;
	    }
	 
	 
	 @RequestMapping(value = "/fileDashboard.htm", method = RequestMethod.GET)
	 public String fileDashboard(HttpServletRequest req,HttpSession ses) throws Exception {
	   
			
	     return "Dashboard";
	    }
	 
}
