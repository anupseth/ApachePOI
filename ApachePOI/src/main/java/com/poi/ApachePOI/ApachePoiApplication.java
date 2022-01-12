package com.poi.ApachePOI;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApachePoiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApachePoiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		 Workbook wb = new HSSFWorkbook();  
	        try  (OutputStream fileOut = new FileOutputStream("Javatpoint.xls")) {  
	            Sheet sheet1 = wb.createSheet("First Sheet");  
	            Sheet sheet2 = wb.createSheet("Second Sheet");  
	            wb.write(fileOut);  
	        }catch(Exception e) {  
	            System.out.println(e.getMessage());  
	        }  

	}

}
