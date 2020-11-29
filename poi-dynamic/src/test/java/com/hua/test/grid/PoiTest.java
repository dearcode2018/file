/**
* PoiTest.java
* 
* @author qye.zheng
* 	version 1.0
 */
package com.hua.test.grid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.hua.constant.GridConstant;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.POIUtil;

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
	public void testRead() {
		try {
			
			
		} catch (Exception e) {
			log.error("testRead =====> ", e);
		} finally 
		{
			try
			{
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e)
			{
				log.error("testRead2003 =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void testReadNumber() {
		try {
			filename = "numberData.xls";
			filePath+= filename;
			inputStream = new FileInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			sheet = workbook.getSheetAt(0);
			
			log.info("testReadNumber =====> " + sheet.getPhysicalNumberOfRows());
			
			row = sheet.getRow(1);
			cell = row.getCell(0);
			
			//log.info("testReadNumber =====> 数字值(格式化之前)" + cell.getNumericCellValue());
			log.info("testReadNumber =====> 数字值(格式化之前)" + cell.getStringCellValue());
			
			/**
			  格式化 - 分析
			  # 表示只保留整数
			  #.0 保留1位小数
			  #.00 保留2位小数
			  ...
			 */
			
			// 格式化所有为数字类型的单元格，将小数去除
			final DecimalFormat decimalFormat = new DecimalFormat("#");
			value = decimalFormat.format(cell.getNumericCellValue());
			log.info("testReadNumber =====> 数字值(格式化之后)" + value);
			
			
			
		} catch (Exception e) {
			log.error("testReadNumber =====> ", e);
		} finally 
		{
			try
			{
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e)
			{
				log.error("testReadNumber =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void testRead2003() {
		try {
			filename = "importData.xls";
			filePath+= filename;
			inputStream = new FileInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			sheet = workbook.getSheetAt(0);
			
			log.info("testRead2003 =====> " + sheet.getPhysicalNumberOfRows());
			
			row = sheet.getRow(1);
			cell = row.getCell(4);
			
			log.info("testRead2003 =====> 数字值(格式化之前)" + cell.getNumericCellValue());
			
			/**
			  格式化 - 分析
			  # 表示只保留整数
			  #.0 保留1位小数
			  #.00 保留2位小数
			  ...
			 */
			
			// 格式化所有为数字类型的单元格，将小数去除
			final DecimalFormat decimalFormat = new DecimalFormat("#");
			value = decimalFormat.format(cell.getNumericCellValue());
			log.info("testRead2003 =====> 数字值(格式化之后)" + value);
			
			
			
		} catch (Exception e) {
			log.error("testRead2003 =====> ", e);
		} finally 
		{
			try
			{
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e)
			{
				log.error("testRead2003 =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void testRead2007() {
		try {
			filename = "importData.xlsx";
			filePath+= filename;
			inputStream = new FileInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xlsx", inputStream);
			sheet = workbook.getSheetAt(0);
			
			log.info("testRead2007 =====> " + sheet.getPhysicalNumberOfRows());
			
			row = sheet.getRow(1);
			cell = row.getCell(4);
			
			log.info("testRead2007 =====> 数字值(格式化之前)" + cell.getNumericCellValue());
			
			/**
			  格式化 - 分析
			  # 表示只保留整数
			  #.0 保留1位小数
			  #.00 保留2位小数
			  ...
			 */
			
			// 格式化所有为数字类型的单元格，将小数去除
			final DecimalFormat decimalFormat = new DecimalFormat("#");
			value = decimalFormat.format(cell.getNumericCellValue());
			log.info("testRead2007 =====> 数字值(格式化之后)" + value);
			
		} catch (Exception e) {
			log.error("testRead2007 =====> ", e);
		} finally 
		{
			try
			{
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e)
			{
				log.error("testRead2003 =====> ", e);
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 
	 * @author qye.zheng
	 */
	@Test
	public void testWrite() {
		try {
			workbook = POIUtil.createWorkbook(GridConstant.EXCEL_XLSX);
			sheet = workbook.createSheet("新建的表格_01");
			
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("line 1");
			cell.setCellValue(1223);
			row = sheet.createRow(sheet.getPhysicalNumberOfRows());
			cell = row.createCell(0);
			cell.setCellValue("line 2");
			
			row = sheet.createRow(sheet.getPhysicalNumberOfRows());
			cell = row.createCell(0);
			cell.setCellValue("line 3");
			
			row = sheet.createRow(sheet.getPhysicalNumberOfRows());
			cell = row.createCell(0);
			cell.setCellValue("line 4");

			filename = "test.xlsx";
			filePath += filename;
			log.info("testWrite =====> " + filePath);
			outputStream = new FileOutputStream(new File(filePath));
			workbook.write(outputStream);
			
		} catch (Exception e) {
			log.error("testWrite =====> ", e);
		} 
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
}
