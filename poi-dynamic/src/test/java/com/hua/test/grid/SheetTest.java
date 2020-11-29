/**
 * 描述: 
 * SheetTest.java
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

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;
import com.hua.util.POIUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SheetTest
 */
public final class SheetTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSheet() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSheet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testActualRecord() {
		try {
			filePath = "/conf/grid/test/excel-test.xlsx";
			suffix = FileUtil.getSuffix(filePath);
			log.info("testActualRecord =====> suffix = " + suffix);
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook(suffix, inputStream);
			sheet = workbook.getSheetAt(0);
			log.info("testActualRecord =====> sheetName = " + sheet.getSheetName());
			log.info("有格式 - PhysicalNumberOfRows = " + sheet.getPhysicalNumberOfRows());
			log.info("FirstRowNum = " + sheet.getFirstRowNum());
			log.info("TopRow = " + sheet.getTopRow());
			/*
			 以第0列不为空为参照标准，决定该行是否为空 (除去标题行)
			 要求第0行是标题行，中间不能有空行隔开
			 这样可以在有格式的情况下，统计出正确的记录总数
			 */
			int columnIndex = 0;
			int actualRecord = 0;
			final int startIndex = sheet.getFirstRowNum() + 1;
			final int physicialNumber = sheet.getPhysicalNumberOfRows();
			for (int i =  startIndex; i < physicialNumber; i++)
			{
				row = sheet.getRow(i);
				cell = row.getCell(columnIndex);
				if (POIUtil.isNull(cell))
				{
					System.out.println("为空的单元格");
					continue;
				} else
				{
					actualRecord++;
				}
				// 6种数据类型
				//System.out.println(cell.getCellType());
				if (Cell.CELL_TYPE_NUMERIC == cell.getCellType())
				{
					// 数字类型
					System.out.println("数字类型: " + cell.getNumericCellValue());
				}  else if (Cell.CELL_TYPE_STRING == cell.getCellType())
				{
					//	字符串
					System.out.println("字符串类型: " + cell.getStringCellValue());
				}  else if (Cell.CELL_TYPE_FORMULA == cell.getCellType())
				{
					// 数学公式
					System.out.println("数学公式类型: " + cell.getCellFormula());
				}  else if (Cell.CELL_TYPE_BLANK == cell.getCellType())
				{
					// 空白单元格
					System.out.println("空白单元格类型");
				} else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType())
				{
					// 布尔类型
					System.out.println("布尔类型: " + cell.getBooleanCellValue());
				}else if (Cell.CELL_TYPE_ERROR == cell.getCellType())
				{
					// 错误类型
					System.out.println("错误类型: " + cell.getErrorCellValue());
				}
			}
			System.out.println(actualRecord);
			
		} catch (Exception e) {
			log.error("testActualRecord =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPoiUtilActualRecord() {
		try {
			int columnIndex = 0;
			filePath = "/conf/grid/test/excel-test.xlsx";
			suffix = FileUtil.getSuffix(filePath);
			log.info("testPoiUtilActualRecord =====> suffix = " + suffix);
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook(suffix, inputStream);
			sheet = workbook.getSheetAt(1);
			
			log.info("testPoiUtilActualRecord =====> " + POIUtil.countActualRecord(sheet, columnIndex));
			
		} catch (Exception e) {
			log.error("testPoiUtilActualRecord =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveColumn() {
		try {
			int columnIndex = 0;
			filePath = "/doc/excel-test.xlsx";
			suffix = FileUtil.getSuffix(filePath);
			outputStream = new FileOutputStream(ProjectUtil.getAbsolutePath("/doc/excel-test-result.xlsx", true));
			log.info("testPoiUtilActualRecord =====> suffix = " + suffix);
			inputStream = new FileInputStream(ProjectUtil.getAbsolutePath(filePath, true));
			workbook = POIUtil.buildWorkbook(suffix, inputStream);
			sheet = workbook.getSheetAt(1);
			
			//sheet.removeColumnBreak(1);
			
			row = sheet.getRow(0);
			System.out.println(row.getPhysicalNumberOfCells());
			cell = row.createCell(row.getPhysicalNumberOfCells());
			//cell = row.createCell(0);
			cell.setCellValue("new add column");
			System.out.println(row.getPhysicalNumberOfCells());
			Cell temp = null;
			// 将最后一列搬到第一列
			for (int i = 0; i < row.getPhysicalNumberOfCells(); i++)
			{
				
			}
	
			
			workbook.write(outputStream);
		} catch (Exception e) {
			log.error("testRemoveColumn =====> ", e);
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
