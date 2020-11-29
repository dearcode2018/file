/**
 * 描述: 
 * JxlTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.grid;

import java.io.File;

import jxl.Workbook;
import jxl.WorkbookSettings;

import org.junit.Test;

import com.hua.test.BaseTest;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * JxlTest
 */
public final class JxlTest extends BaseTest
{
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRead() {
		try {
			String filename = "importData.xls";
			//filename = "test.xls";
			filePath += filename;
			final File file = new File(filePath);
			WorkbookSettings settings = new WorkbookSettings();
			// 关闭警告信息(特别是中文问题警告)
			settings.setSuppressWarnings(true);
			workbook = Workbook.getWorkbook(file, settings);
			
			// 通过输入流来获取
			//workbook = Workbook.getWorkbook(is);
			log.info("testRead =====> " + workbook.getNumberOfSheets());
			
			// 根据[下标]获取 sheet 对象
			sheet = workbook.getSheet(0);
			
			// 根据[工作表名称]获取 sheet 对象
			//sheet = workbook.getSheet("商家信息");
			
			// 总行数
			totalRow = sheet.getRows();
			
			// 总列数
			totalColumn = sheet.getColumns();
			
			// 获取某一行的单元格数组
			cells = sheet.getRow(0);
			
			// 获取某行某列的单元格内容(字符串形式)
			contents = cells[0].getContents();
			
			log.info("testRead =====> " + contents);
			
		} catch (Exception e) {
			log.error("testRead =====> ", e);
		} finally 
		{
			if (null != workbook)
			{
				workbook.close();
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
	public void testWrite() {
		try {
			String filename = "test.xls";
			//filename = "test.xls";
			filePath += filename;
			final File file = new File(filePath);
			// 创建 工作簿
			writableWorkbook = Workbook.createWorkbook(file);
			
			// 创建工作表
			writableSheet = writableWorkbook.createSheet("中文啊", 0);
			
			// 写出 workbook
			writableWorkbook.write();
			
		} catch (Exception e) {
			log.error("testWrite =====> ", e);
		} finally 
		{
			try
			{
				if (null != writableWorkbook)
				{
					writableWorkbook.close();
				}
			} catch (Exception e)
			{
				e.printStackTrace();
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
	public void testFormat() {
		try {
			
			
		} catch (Exception e) {
			log.error("testFormat =====> ", e);
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
