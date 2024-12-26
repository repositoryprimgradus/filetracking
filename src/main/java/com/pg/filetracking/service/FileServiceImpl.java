package com.pg.filetracking.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pg.filetracking.dao.FileRepository;
import com.pg.filetracking.dao.FileStatusRepository;
import com.pg.filetracking.entity.FileDto;
import com.pg.filetracking.entity.FileInfo;
import com.pg.filetracking.entity.FileStatus;
import com.pg.filetracking.fileupload.dao.FileTypeRepository;
import com.pg.filetracking.fileupload.model.FileType;
import com.pg.filetracking.model.request.FileRequest;
import com.pg.filetracking.model.request.FileStatusRequest;
import com.pg.filetracking.model.response.FileResponse;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
    private FileRepository fileRepository;
	
	@Autowired
	private FileStatusRepository fileStatusRepository;
	
	@Autowired
	FileTypeRepository fileTypeRepository;
	
	 private SimpleDateFormat sdfDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 private  SimpleDateFormat sdfSqlDate=new SimpleDateFormat("yyyy-MM-dd");
	 private  SimpleDateFormat sdfSqlDateFormat=new SimpleDateFormat("dd-MM-yyyy");
	 
	@Override
	public Long saveFile( FileRequest fileRequest) throws ParseException {
		
		Calendar cal=Calendar.getInstance();
		int day=cal.getTime().getDay();
		int hour=cal.getTime().getHours();
		int min=cal.getTime().getMinutes();
		int sec=cal.getTime().getSeconds();
		
		String Barcode="D"+day+hour+min+sec;
		
		
		FileInfo fileInfo=new FileInfo();
		fileInfo.setFileBarcode(Barcode);
		fileInfo.setFileName(fileRequest.getFileName());
		fileInfo.setFileType(fileRequest.getFileType());
		fileInfo.setDescription(fileRequest.getDescription());
		fileInfo.setDate(new java.sql.Date(sdfSqlDate.parse(fileRequest.getDate()).getTime()));
		
		if(fileRequest.getActionType().equalsIgnoreCase("UPDATE")) {
			fileInfo.setModifiedBy(fileRequest.getUserName());
			fileInfo.setModifiedDate(sdfDateTime.format(new Date()));
			fileInfo.setLoginId((long) fileRequest.getLoginId());
          return   null;
            
     }else {
    	 fileInfo.setIsActive(1);
    	 fileInfo.setCreatedBy(fileRequest.getUserName());
    	 fileInfo.setCreatedDate(sdfDateTime.format(new Date()));
        
     }
		
		return fileRepository.save(fileInfo).getFileDetailsId();
	}

	@Override
	public FileResponse viewFileTable() {

		List<FileInfo> fileList=fileRepository.findAll();
		FileResponse fileResponse=new FileResponse();
		List<FileDto> fileDtolist=new ArrayList<FileDto>();
		if(fileList!=null) {
			for(FileInfo fileinfo:fileList) {
				FileDto fileDto=new FileDto();
				fileDto.setDate(sdfSqlDateFormat.format(fileinfo.getDate()));
				fileDto.setDescription(fileinfo.getDescription());
				fileDto.setFileDetailsId(fileinfo.getFileDetailsId());
				fileDto.setFileName(fileinfo.getFileName());
				fileDto.setFileType(fileinfo.getFileType());
				fileDto.setFileBarcode(fileinfo.getFileBarcode());
				String s = "";
				s = s + "<a target='_balnk' href='printFile?printFileId=" + fileinfo.getFileDetailsId()+"'><i class='fa fa-print' style='font-size:40px;' ></i></button>";
				fileDto.setActionType(s);
				fileDtolist.add(fileDto);
			}
			
			
		}
		/*
		 * try { pdfToWord(); }catch (Exception e) { e.printStackTrace(); }
		 */
		
		fileResponse.setFileDto(fileDtolist);
		return fileResponse;
	}
	
public File getBarcode4j(String productname)throws Exception{
	final ByteArrayOutputStream os = new ByteArrayOutputStream();
		Code39Bean barcodeGenerator=new Code39Bean();
	//EAN13Bean barcodeGenerator = new EAN13Bean();
	BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	barcodeGenerator.generateBarcode(canvas, productname);
	
	File f = new File("C:\\Users\\Sangram\\Desktop\\PFTS\\MyFile.jpg");
	
	File tempFile = File.createTempFile("prefix-", ".jpg");
	//File tempFile = File.createTempFile("MyAppName-", ".tmp");
	//tempFile.deleteOnExit();
	
	if (!ImageIO.write(canvas.getBufferedImage(), "JPEG", tempFile)) {
	  throw new RuntimeException("Unexpected error writing image");
	}

	return tempFile;
	}



public  ByteArrayInputStream employeePDFReport(FileInfo fileInfo) throws Exception {
                   Document document = new Document();
                ByteArrayOutputStream out = new ByteArrayOutputStream();

try {
	
	Code39Bean barcodeGenerator=new Code39Bean();
	//EAN13Bean barcodeGenerator = new EAN13Bean();
	BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	barcodeGenerator.generateBarcode(canvas, fileInfo.getFileBarcode());
	
	File f = new File("C:\\Users\\Sangram\\Desktop\\PFTS\\MyFile.jpg");
	
	File tempFile = File.createTempFile("prefix-", ".jpg");
	//File tempFile = File.createTempFile("MyAppName-", ".tmp");
	
	
	if (!ImageIO.write(canvas.getBufferedImage(), "JPEG", tempFile)) {
	  throw new RuntimeException("Unexpected error writing image");
	}
	

     PdfWriter.getInstance(document, out);
    document.open();
         Image image= Image.getInstance(tempFile.getAbsolutePath());
          document.add(image);
// Add Text to PDF file ->
             Font font = FontFactory
              .getFont(FontFactory.COURIER, 14,BaseColor.BLACK);
             
           document.add(Chunk.NEWLINE);

           PdfPTable table = new PdfPTable(3);
           table.setPaddingTop(100);
// Add PDF Table Header ->
            Stream.of("FileName", "FileType", "Description")
            .forEach(headerTitle -> 
            {
          PdfPCell header = new PdfPCell();
       Font headFont = FontFactory.
    getFont(FontFactory.HELVETICA_BOLD);
         header.setBackgroundColor(BaseColor.LIGHT_GRAY);
     header.setHorizontalAlignment(Element.ALIGN_CENTER);
      header.setBorderWidth(2);
         header.setPhrase(new Phrase(headerTitle, headFont));
           table.addCell(header);
           
           
                });

  
            PdfPCell idCell = new PdfPCell(new Phrase(fileInfo.getFileName().toString()));
             idCell.setPaddingLeft(4);
            idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              table.addCell(idCell);

             PdfPCell firstNameCell = new PdfPCell(new Phrase
        (fileInfo.getFileType()));
            firstNameCell.setPaddingLeft(4);
             firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
           table.addCell(firstNameCell);

          PdfPCell lastNameCell = new PdfPCell(new Phrase
 (String.valueOf(fileInfo.getDescription())));
       lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
       lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         lastNameCell.setPaddingRight(4);
            table.addCell(lastNameCell);

//document.add(table);
  
            
            
          document.close();
          tempFile.deleteOnExit();
              } catch (DocumentException e) {

 }

return new ByteArrayInputStream(out.toByteArray());
}


@Override
public FileInfo fileDetails(Long fileDetailsId) {

	return fileRepository.findByFileDetailsId(fileDetailsId);
}

@Override
public Long saveFileStatus(FileStatusRequest fileStatusRequest,String userName) {
	FileStatus fileStatus=new FileStatus();
	fileStatus.setDate(sdfDateTime.format(new Date()));
	fileStatus.setCreatedBy(userName);
	//fileStatus.setComment(fileStatusRequest.getComment());
	System.out.println(fileStatusRequest.getFileDetailsId());
	
	fileStatus.setFileDetailsId(Long.valueOf(fileStatusRequest.getFileDetailsId()));
	fileStatus.setFileStatus(fileStatusRequest.getStatus());
	
	
	return fileStatusRepository.save(fileStatus).getFileStatusId();
}
	
/*
 * public void pdfToWord()throws Exception{
 * 
 * // Load the source PDF file Converter converter = new
 * Converter("C:\\Users\\Sangram\\Desktop\\PFTS\\DEM-2_BG.pdf"); // Set the
 * convert options for DOC format WordProcessingConvertOptions options = new
 * WordProcessingConvertOptions();
 * options.setFormat(WordProcessingFileType.Doc); // Convert to DOC format
 * converter.convert("C:\\Users\\Sangram\\Desktop\\PFTS\\converted1.doc",
 * options);
 * 
 * 
 * }
 */
@Override
public List<FileType> fileTypeList() throws Exception {
	
	return fileTypeRepository.findAll();
}

}
