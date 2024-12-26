package com.pg.filetracking.utility.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.FileType;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.filetypes.MarkupFileType;
import com.groupdocs.conversion.filetypes.PdfFileType;
import com.groupdocs.conversion.filetypes.PresentationFileType;
import com.groupdocs.conversion.filetypes.SpreadsheetFileType;
import com.groupdocs.conversion.filetypes.WordProcessingFileType;
import com.groupdocs.conversion.internal.c.a.cd.xmp.schemas.photoshop.PhotoshopPackage;
import com.groupdocs.conversion.options.convert.ConvertOptions;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.conversion.options.convert.MarkupConvertOptions;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;
import com.groupdocs.merger.Merger;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;
@Service
public class DocServiceImpl implements DocService {

	@Override
	public String convertFile(String inputType, String convertType, MultipartFile file) throws Exception {
		
		String fileName="";
		
		if(convertType.equalsIgnoreCase("Web")) {
			fileName=pdfToWeb(file);
		}else if(convertType.equalsIgnoreCase("Word")) {
			fileName=pdfToWord(file);
		}else if(convertType.equalsIgnoreCase("Spreadsheet")) {
			fileName=pdfToSpreedSheet(file);
		}else if(convertType.equalsIgnoreCase("Photoshop")) {
			fileName=pdfToPhotoshop(file);
		}else if(convertType.equalsIgnoreCase("Presentation")) {
			fileName=pdfToPresentation(file);
		}else if(convertType.equalsIgnoreCase("Image")) {
			fileName=pdfToImage(file);
		}else if(convertType.equalsIgnoreCase("eBook")) {
			fileName=pdfToEbook(file);
		}else if(convertType.equalsIgnoreCase("PDF")) {
			fileName=pdfTopdf(file);
		}
		
		
		
		return fileName;
		
		
		
	}
	
	
	
private String pdfTopdf(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for DOC format
				PdfConvertOptions options = new PdfConvertOptions();
				options.setFormat(PdfFileType.Pdf);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".pdf");
				
				// Convert to DOC format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	
	private String pdfToWord(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for DOC format
				WordProcessingConvertOptions options = new WordProcessingConvertOptions();
				options.setFormat(WordProcessingFileType.Doc);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".doc");
				
				// Convert to DOC format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	private String pdfToWeb(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for HTML format
				MarkupConvertOptions options = new MarkupConvertOptions();
				options.setFormat(MarkupFileType.Html);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".html");
				
				// Convert to HTML format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	
	private String pdfToSpreedSheet(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for HTML format
				SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
				options.setFormat(SpreadsheetFileType.Xls);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".xls");
				
				// Convert to HTML format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	private String pdfToPhotoshop(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for HTML format
				ConvertOptions options = new FileType().fromExtension("psd").getConvertOptions();
				//options.setFormat(PhotoshopPackage.);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".psd");
				
				// Convert to HTML format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	
	
	private String pdfToPresentation(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for HTML format
				PresentationConvertOptions options = new PresentationConvertOptions();
				options.setFormat(PresentationFileType.Ppt);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".ppt");
				
				// Convert to HTML format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}
	
	
	private String pdfToImage(MultipartFile file) throws Exception {
		
		// Load the source PDF file
				Converter converter = new Converter(file.getInputStream());
				// Set the convert options for HTML format
				ImageConvertOptions options = new ImageConvertOptions();
				options.setFormat(ImageFileType.Png);
				
				 File tempFile = File.createTempFile("tempfile" + file.getName(), ".png");
				
				// Convert to HTML format
				converter.convert(tempFile.getAbsolutePath(), options);
				
				return tempFile.getAbsolutePath();
	}	

	
	
	private String pdfToEbook(MultipartFile file) throws Exception {
		
		// Load the source PDF file
		Converter converter = new Converter(file.getInputStream());
		// Set the convert options for HTML format
		ConvertOptions options = new FileType().fromExtension("epub").getConvertOptions();
		//options.setFormat(PhotoshopPackage.);
		
		 File tempFile = File.createTempFile("tempfile" + file.getName(), ".epub");
		
		// Convert to HTML format
		converter.convert(tempFile.getAbsolutePath(), options);
		
		return tempFile.getAbsolutePath();
	}



	@Override
	public String mergeFile(MultipartFile[] file) throws Exception {
		 
	        String outputFile = File.createTempFile("tempfile_" + file[0].getName(), ".pdf").getPath();
	       
	        // Load the source PDF file
	     
	        PDFMergerUtility PDFmerger = new PDFMergerUtility();
	        PDFmerger.setDestinationFileName(outputFile);
	      //  Merger merger = new Merger(file[0].getInputStream());
	        for(int i=0;i<file.length;i++)
	        {
	        	
	        	String inputFile = File.createTempFile("tempfile" + file[i].getName(), ".pdf").getPath();	
	        	
	        	try (OutputStream os = new FileOutputStream(inputFile)) {
	        	    os.write(file[i].getBytes());
	        	}
	        
	        	PDFmerger.addSource(inputFile);
	        	
	        	
	            // Add another PDF file to merge
	         //   merger.join(file[i].getInputStream());
	            // Merge PDF files ans save result
	           
	        }
	       // merger.save(outputFile);
	        
	        PDFmerger.mergeDocuments(null);
		return outputFile;
	}
	
	
	
	
//	public void manipulatePdf(String src, String dest)
//		    throws Exception {
//		    PdfReader reader = new PdfReader(src);
//		    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
//		    List cleanUpLocations =
//		        new ArrayList();
//		    cleanUpLocations.add(new PdfCleanUpLocation(
//		        1, new Rectangle(97f, 405f, 480f, 445f), BaseColor.GRAY));
//		    PdfContentStreamProcessor cleaner =
//		        new PdfContentStreamProcessor(renderListener)
//		    cleaner.cleanUp();
//		    stamper.close();
//		    reader.close();
//		}

	
	
	
	
	
}
