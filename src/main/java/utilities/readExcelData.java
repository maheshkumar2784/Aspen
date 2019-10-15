package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import testBase.TestBase;
import testBase.commonObjects;

public class readExcelData extends commonObjects{

	//	@Test
	public void readExceldata() throws IOException {
		TestBase.initializelog4j();
		log = Logger.getLogger("read excels");
		String TestDataFileLoc="./TestData/TestData1.xlsx";
		String sheetName="userCredentials";
		Object[][] data=readExcelSheet(TestDataFileLoc, sheetName);
		for (int i=0;i<data.length;i++) {
			log.info("Browser data: "+data[i][0]);
			log.info("username data: "+data[i][2]);
		}
	}

	public void readExcelSheet_old(String TestDataFileLoc, String sheetName) throws IOException {
		FileInputStream ipFile=new FileInputStream(TestDataFileLoc); 
		HSSFWorkbook workbook=new HSSFWorkbook(ipFile);   // xlsx files
		//HSSFWorkbook wb=new HSSFWorkbook(ipFile);  //xlx files
		HSSFSheet sheet1=workbook.getSheet(sheetName);  //sheet name
		HSSFSheet sheet2=workbook.getSheetAt(1);  //sheet index

		log.info("Last Row Index "+sheet1.getLastRowNum());		  //to read last row number
		//		log.info(sheet2.getLastRowNum());
		log.info("Last Column Index: "+sheet1.getRow(0).getLastCellNum());
		for(int i=0;i<=sheet1.getLastRowNum();i++) {
			if(sheet1.getRow(i)!=null) {
				log.info(sheet1.getRow(i).getCell(0));
				log.info(sheet1.getRow(i).getCell(1));
				log.info(sheet1.getRow(i).getCell(2));
				log.info(sheet1.getRow(i).getCell(3));	
			}
			else {
				log.info("Null Value");
			}
		}
	}

	public static Object[][] readExcelSheet(String TestDataFileLoc, String sheetName) throws IOException {
		FileInputStream ipFile=new FileInputStream(TestDataFileLoc); 
		HSSFWorkbook workbook=new HSSFWorkbook(ipFile);   // xlsx files	
		HSSFSheet sheet=workbook.getSheet(sheetName);  //sheet name

		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int r=0;r<sheet.getLastRowNum();r++) {
			for(int c=0;c<sheet.getRow(0).getLastCellNum();c++) {
				data[r][c]=sheet.getRow(r+1).getCell(c);
//								log.info(""+r+c+data[r][c]);
				System.out.println(data[r][c]);
			}
		}
		return data;
	}


	public void writeDataExcelSheet_old(String TestDataFileLoc, String sheetName) throws IOException {
		FileInputStream ipFile=new FileInputStream(TestDataFileLoc); 
		XSSFWorkbook workbook=new XSSFWorkbook(ipFile);   // xlsx files
		//HSSFWorkbook wb=new HSSFWorkbook(ipFile);  //xlx files
		//		workbook.createSheet();
		XSSFSheet sheet=workbook.getSheet(sheetName);  //sheet name
		int lastRowNum=sheet.getLastRowNum();
		Row row=sheet.createRow(lastRowNum+1);
		Cell cell1=row.createCell(0);
		cell1.setCellValue("testing writedata");
		
		row.createCell(1).setCellValue("testing writedata");;
	
		FileOutputStream opFile=new FileOutputStream(TestDataFileLoc); 
		workbook.write(opFile);
		opFile.close();
	}

	@Test
	public void writeExceldata() throws IOException {
		TestBase.initializelog4j();
		log = Logger.getLogger("Write excels");
		String TestDataFileLoc="./TestData/TestData1.xlsx";
		String sheetName="writeData";
		writeDataExcelSheet_old(TestDataFileLoc, sheetName);

	}

	@Test
	public void readwriteExceldata() throws IOException {
		TestBase.initializelog4j();
		log = Logger.getLogger("Write excels");
		String TestDataFileLoc="./TestData/TestData1.xlsx";
		String sheetName="userCredentials";
		Object[][] data=readExcelSheet(TestDataFileLoc, sheetName);
		writeDataExcelSheet(TestDataFileLoc, "writeDatafromExistingInfo1", data);
	}

	private void writeDataExcelSheet(String testDataFileLoc, String sheetName, Object[][] data) throws IOException {
		FileInputStream ipFile=new FileInputStream(testDataFileLoc); 
		XSSFWorkbook workbook=new XSSFWorkbook(ipFile);   // xlsx files		
		XSSFSheet sheet=workbook.createSheet(sheetName); 
		
		for (int i=0;i<data.length;i++) {
			Row row1=sheet.createRow(i);
			row1.createCell(0).setCellValue(data[i][0].toString());
			row1.createCell(1).setCellValue(data[i][1].toString());
			row1.createCell(2).setCellValue(data[i][2].toString());
			row1.createCell(3).setCellValue(data[i][3].toString());	
			}
					
		FileOutputStream opFile=new FileOutputStream(testDataFileLoc); 
		workbook.write(opFile);
		opFile.close();		
	}
	
	
}
