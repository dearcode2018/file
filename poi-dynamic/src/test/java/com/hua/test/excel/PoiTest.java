/**
* PoiTest.java
* 
* @author qye.zheng
* 	version 1.0
 */
package com.hua.test.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;

/**
 * 描述: 
 * @author qye.zheng
 * PoiTest
 */
public final class PoiTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void testWrite() {
		Workbook book = null;
		book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("新建的表格_01");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("line 1");
		row = sheet.createRow(sheet.getPhysicalNumberOfRows());
		cell = row.createCell(0);
		cell.setCellValue("line 2");
		
		row = sheet.createRow(sheet.getPhysicalNumberOfRows());
		cell = row.createCell(0);
		cell.setCellValue("line 3");
		
		row = sheet.createRow(sheet.getPhysicalNumberOfRows());
		cell = row.createCell(0);
		cell.setCellValue("line 4");
		
		try {
			String filePath = ClassPathUtil.getClassPath("file") + "/test.xlsx";
			log.info("testWrite =====> " + filePath);
			book.write(new FileOutputStream(new File(filePath)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void test() {
		
	}
	
}
