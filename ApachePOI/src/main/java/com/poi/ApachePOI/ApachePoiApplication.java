package com.poi.ApachePOI;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poi.ApachePOI.pojos.Employee;

@SpringBootApplication
public class ApachePoiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApachePoiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Workbook wb = new HSSFWorkbook();
		try (OutputStream fileOut = new FileOutputStream("Javatpoint.xls")) {
			Sheet sheet1 = wb.createSheet("First Sheet");
			Sheet sheet2 = wb.createSheet("Second Sheet");
			wb.write(fileOut);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Create data
		List<Employee> empList = Arrays.asList(new Employee("Dia", "Goa India", "25", "19-05-1971"),
				new Employee("Kia", "Mumbai India", "75", "12-03-1977"),
				new Employee("Mia", "Delhi India", "95", "15-09-1976"),
				new Employee("Sia", "Assam India", "15", "22-06-1974"));

		// Create row and set cell value
		wb = new HSSFWorkbook();
		try (OutputStream os = new FileOutputStream("Employee.xls")) {
			Sheet sheet = wb.createSheet("Employee");

			int cellNUmber = 0;
			Field[] allFields = FieldUtils.getAllFields(Employee.class);

			Row row = sheet.createRow(0);

			for (Field field : allFields) {

				try {

					field.setAccessible(true);

					String fieldName = field.getName();

					Cell cell = row.createCell(cellNUmber);
					cell.setCellValue(fieldName);

					cellNUmber++;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			int rowNum = 1;
			for (Employee emp : empList) {

				int cellNumInternal = 0;

				Row rowInternal = sheet.createRow(rowNum);

				for (Field field : allFields) {

					try {
						Object obj = field.get(emp);
						Cell cell = rowInternal.createCell(cellNumInternal);
						cell.setCellValue((String) obj);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

					cellNumInternal++;
				}

				rowNum = rowNum + 1;

			}

			wb.write(os);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
