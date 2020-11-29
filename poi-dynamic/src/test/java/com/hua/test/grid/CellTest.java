/**
 * 描述: 
 * CellTest.java
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

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
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
 * CellTest
 */
public final class CellTest extends BaseTest {

	/**
	 * 
	 * 描述: 单元格批注 2007 xlsx格式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommentOf2007() {
		try {
			filePath = "/conf/grid/test/excel-test.xlsx";
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xlsx", inputStream);
			outputPath = ProjectUtil.getAbsolutePath("/doc/excel-comment.xlsx", true);
			
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(1);
			cell = row.getCell(3);
			Drawing draw = sheet.createDrawingPatriarch();
			comment = draw.createCellComment(new XSSFClientAnchor());
			//comment = draw.createCellComment(new XSSFClientAnchor(0,0,0,0,(short)3,3,(short)5,6));
			comment.setAuthor("toad");  
			comment.setVisible(true);
			comment.setString(new XSSFRichTextString("aabb"));
			comment.setColumn(0);
			comment.setRow(0);
			
			cell.setCellComment(comment);
			
			 workbook.write(outputStream);
		} catch (Exception e) {
			log.error("testCommentOf2007 =====> ", e);
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
	 * 描述: 单元格批注 2003 xls格式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommentOf2003() {
		try {
			filePath = "/conf/grid/test/excel-test.xls";
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook("xls", inputStream);
			outputPath = ProjectUtil.getAbsolutePath("/doc/excel-comment.xls", true);
			outputStream = new FileOutputStream(outputPath);
			
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(1);
			cell = row.getCell(3);
			Drawing draw = sheet.createDrawingPatriarch();
			//comment = draw.createCellComment(new HSSFClientAnchor());
			comment = draw.createCellComment(new HSSFClientAnchor(0,0,0,0,(short) 3, 3 ,(short) 5, 6));
			comment.setAuthor("toad");  
			comment.setVisible(true);
			comment.setString(new HSSFRichTextString("aabb"));
			//comment.setColumn(0);
			//comment.setRow(0);
			
			cell.setCellComment(comment);
			
			 workbook.write(outputStream);
		} catch (Exception e) {
			log.error("testCommentOf2003 =====> ", e);
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
	public void testPoiUtilCreateComment() {
		try {
			filePath = "/conf/grid/test/excel-test.xls";
			suffix = FileUtil.getSuffix(filePath);
			inputStream = ClassPathUtil.getInputStream(filePath);
			workbook = POIUtil.buildWorkbook(suffix, inputStream);
			outputStream = new FileOutputStream(ClassPathUtil.getClassPath(filePath));
			
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(1);
			cell = row.getCell(3);
			
			comment = POIUtil.createCellComment("xls", sheet, "批注啊啊");
			
			cell.setCellComment(comment);
			
			 workbook.write(outputStream);
			
		} catch (Exception e) {
			log.error("testPoiUtilCreateComment =====> ", e);
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
