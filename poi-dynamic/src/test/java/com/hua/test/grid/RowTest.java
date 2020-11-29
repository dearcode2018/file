/**
 * 描述: 
 * RowTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.grid;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.POIUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * RowTest
 */
public final class RowTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRow() {
		try {
			filePath = "/conf/grid/test/excel-test.xls";
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			outputStream = new FileOutputStream(ClassPathUtil.getClassPath(filePath));
			
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(1);
			cell = row.getCell(0);
			cell.setCellStyle(POIUtil.createRedStyle(workbook));
			//cell.setCellComment(POIUtil.createCellComment("xls", sheet, "注释啊"));
			
			Row temp = row;
			
			row = sheet.createRow(10);
			cell = row.createCell(0);
			
			cell.setCellStyle(temp.getCell(0).getCellStyle());
			cell.setCellComment(temp.getCell(0).getCellComment());
			cell.setCellValue(temp.getCell(0).getNumericCellValue());
			
			 workbook.write(outputStream);
			
		} catch (Exception e) {
			log.error("testRow =====> ", e);
		} finally {
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
			} catch (Exception e2)
			{

			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRowShift() {
		try {
			filePath = "/conf/grid/test/excel-test.xls";
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			outputPath = ProjectUtil.getAbsolutePath("/doc/excel-row.xls", true);
			log.info("testRowShift =====> outputPath = " + outputPath);
			outputStream = new FileOutputStream(outputPath);
			
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(1);
			cell = row.getCell(0);
			cell.setCellStyle(POIUtil.createRedStyle(workbook));
			
			//sheet.removeRow(row);
			
			//log.info("testRowShift =====> " + row.getCell(0).getNumericCellValue());
			
			log.info("testRowShift =====> " + sheet.getLastRowNum());
			
			// 方向 向上(负数)/向下(正数)
			int direction = -1;
			// 移动的幅度，多少行 （将之上、之下多少行掩盖掉-覆盖掉）
			int range = 1;
			
			// 行下标从0开始
			int beginIndex = 2;
			int endIndex = sheet.getLastRowNum();
			/*
			 行下标从1开始，将第beginIndex行到第endIndex行向上(负数)/向下(正数)移动多少行
			 
			 */
			sheet.shiftRows(beginIndex, endIndex, direction * range);
			
			 workbook.write(outputStream);
			 outputStream.flush();
			 
			 /**
			  
			  注意: 第0行只能向下移动，不能再往上移动
			  [0..65535] 最后一行也不能再往下移动，只能往上移动.
			  
			  1) 删除单行
			  删除掉第n行的实现: 
			  若第n行是最后一行，则无需上移 否则，将 n+1 行到最后一行，全部上移一行，
			  这样就可以实现将第n行删除掉.
			  
			  2) 删除多行
			  range可以设置为大于1，最后一个被删除的行的下标+1作为移动的beginIndex
			  
			  */
			 
			 
			 
		} catch (Exception e) {
			log.error("testRowShift =====> ", e);
		} finally {
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e2)
			{

			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPoiUtilDeleteRow() {
		try {
			filePath = "/conf/grid/test/excel-test.xls";
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			outputPath = ProjectUtil.getAbsolutePath("/doc/excel-row.xls", true);
			log.info("testPoiUtilDeleteRow =====> outputPath = " + outputPath);
			outputStream = new FileOutputStream(outputPath);
			
			sheet = workbook.getSheetAt(0);
			
			int rowIndex = 1;
			
			POIUtil.deleteRow(sheet, rowIndex);
			
			row = sheet.getRow(rowIndex);
			cell = row.getCell(0);
			log.info("testPoiUtilDeleteRow =====> " + cell.getNumericCellValue());
			
			
		
			
			
			 workbook.write(outputStream);
			 outputStream.flush();
			 
			 /**
			  
			  注意: 第0行只能向下移动，不能再往上移动
			  [0..65535] 最后一行也不能再往下移动，只能往上移动.
			  
			  1) 删除单行
			  删除掉第n行的实现: 
			  若第n行是最后一行，则无需上移 否则，将 n+1 行到最后一行，全部上移一行，
			  这样就可以实现将第n行删除掉.
			  
			  2) 删除多行
			  range可以设置为大于1，最后一个被删除的行的下标+1作为移动的beginIndex
			  
			  */
			
		} catch (Exception e) {
			log.error("testPoiUtilDeleteRow =====> ", e);
		} finally {
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (Exception e2)
			{

			}
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
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
