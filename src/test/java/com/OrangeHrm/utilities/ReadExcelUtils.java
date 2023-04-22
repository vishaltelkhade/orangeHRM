package com.OrangeHrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow rowData;
	public XSSFCell cellData;
	public XSSFCellStyle style;
	String path;
	
	
	public ReadExcelUtils(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws FileNotFoundException
	{
		int rowcount =0;
		fi = new FileInputStream(path);
		try {
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rowcount = sheet.getLastRowNum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws FileNotFoundException
	{
		int cellcount =0;
		fi = new FileInputStream(path);
		try {
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
	        rowData = sheet.getRow(rownum);
	        cellcount = rowData.getLastCellNum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum, int cellnum) throws FileNotFoundException
	{
		String data="";
		fi = new FileInputStream(path);
		try {
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rowData = sheet.getRow(rownum);
			cellData = rowData.getCell(cellnum);
			DataFormatter formatter = new DataFormatter();
			try {
				data= formatter.formatCellValue(cellData);
			} catch (Exception e) {
				data="";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}
