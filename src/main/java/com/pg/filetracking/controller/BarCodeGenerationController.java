package com.pg.filetracking.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarCodeGenerationController {

	@GetMapping(path = "/api/v1/getBarcode4j", produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage getBarcode4j(@RequestParam String productname) throws Exception {

		Code39Bean barcodeGenerator = new Code39Bean();
		// EAN13Bean barcodeGenerator = new EAN13Bean();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeGenerator.generateBarcode(canvas, productname);

		File f = new File("C:\\Users\\Sangram\\Desktop\\PFTS\\MyFile.jpg");
		if (!ImageIO.write(canvas.getBufferedImage(), "JPEG", f)) {
			throw new RuntimeException("Unexpected error writing image");
		}

		System.out.println(canvas.getBufferedImage());
		return canvas.getBufferedImage();
	}

}
