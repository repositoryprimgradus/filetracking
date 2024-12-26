package com.pg.filetracking.fileupload.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.pg.filetracking.fileupload.dao.FileContentRepository;
import com.pg.filetracking.fileupload.dao.FileTypeRepository;
import com.pg.filetracking.fileupload.dao.FileUploadDao;
import com.pg.filetracking.fileupload.dao.FileUploadRepository;
import com.pg.filetracking.fileupload.model.FileContent;
import com.pg.filetracking.fileupload.model.FileType;
import com.pg.filetracking.fileupload.model.FileUpload;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Value("${file_upload_path}")
	String uploadpath;
	
	@Value("${file_tessa}")
	String file_tessa;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	FileContentRepository fileContentRepository;
	
	@Autowired
	FileUploadRepository  fileUploadRepository;
	
	@Autowired 
	FileUploadDao fileUploadDao;
	



	@Override
	public String uploadFile(String fileName, String uploadFileDetailsId, String fileBarcode,String uploadFileSubType, MultipartFile file)throws Exception {

		
		String Attach=fileBarcode+"_"+uploadFileSubType+"_"+fileName+".pdf";
		String content="";

		try (InputStream inputStream = file.getInputStream()) {

			String path = uploadpath;
			path=uploadpath+"/"+fileBarcode;
		
			File newFile = new File(path + File.separator + Attach);

			Path uploadPath = Paths.get(path);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			Path filePath = uploadPath.resolve(Attach);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
			content = extarct(filePath.toString(),file_tessa);
			inputStream.close();
		} catch (IOException ioe) {
			
			throw new IOException("Could not save image file: " + Attach, ioe);
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
		FileContent fileContent = new FileContent();
		fileContent.setFileBarcode(fileBarcode);
		fileContent.setFileContent(content);
		fileContent.setFileName(Attach);
		fileContent.setFileSubType(uploadFileSubType);
	
		
		 FileUpload fileUpload=new FileUpload();
		 fileUpload.setFileBarcode(fileBarcode);
		 fileUpload.setFileSubType(uploadFileSubType);
		 fileUpload.setFileName(Attach);
		 fileUpload.setIsActive(1);
	
		 Long countFileBarcodeAndFileSubType=fileUploadRepository.countByFileBarcodeAndFileSubType(fileBarcode, uploadFileSubType);
		 
		 if(countFileBarcodeAndFileSubType==0) {
		 
		fileUpload = fileUploadRepository.save(fileUpload);
		fileContent = fileContentRepository.save(fileContent);
		 }else {
			 Long updateFileuploadCount= fileUploadDao.updateFileupload(fileUpload,fileContent);
			 
			 if(updateFileuploadCount>0)
				 return "Success";
		 }
		

	
		if(fileUpload.getFileuploadId()>0 ||fileContent.getFileContentId()>0) {
			return "Success";
		}
		return "";
	}
public  String extarct(String file,String absolutePath) throws Exception {
		

	
	
	PDDocument document = PDDocument.load(new File(file));
		
		
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		StringBuilder out = new StringBuilder();

		ITesseract _tesseract = new Tesseract();
		//_tesseract.setDatapath("C:/Users/Sangram/Documents/workspace-sts-3.9.12.RELEASE/pfts-v2.0/tessdata");

		
		
		_tesseract.setDatapath(absolutePath);
		_tesseract.setLanguage("eng");
	
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
	
		List<CompletableFuture> list = new ArrayList<>();
		 


		IntStream.range(0,document.getNumberOfPages()).forEach(i -> {
			    list.add(CompletableFuture.supplyAsync(() -> {
					try {
						return extarctTessa(pdfRenderer, i, absolutePath);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "";
				},executor))
			       ;

			});
		  
	String result="";	  
	
	
		  for(CompletableFuture<Integer> future : list){
			
			  result=result+future.get();
			  
		
		  }
	       executor.shutdown();
           executor.awaitTermination(5, TimeUnit.HOURS);
		  
		  
		 
//		 IntStream.of(document.getNumberOfPages()).forEach(item -> {
//			executor.submit(() -> {
//			try {
//				extarctTessa(pdfRenderer, item, absolutePath);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    });
//	});
		 
		
		  document.close();
		
		 //  document.close();
		//return out.toString();
		return result;
	}

public  String extarctTessa(PDFRenderer pdfRenderer,int page, String absolutePath) throws Exception {
	
	
	  BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

		ITesseract _tesseract = new Tesseract();
		_tesseract.setDatapath(absolutePath);
		_tesseract.setLanguage("eng");

	  
	    // Create a temp image file
	    File tempFile = File.createTempFile("tempfile_" + page, ".png");
	    ImageIO.write(bufferedImage, "png", tempFile);

	    String result = _tesseract.doOCR(tempFile);
	   

	    // Delete temp file
	    tempFile.delete();
	    return result;
}


}
