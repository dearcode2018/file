/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.hua.log.BaseLog;
import com.hua.util.ClassPathUtil;
import com.sun.rowset.internal.Row;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	public String filePath = ClassPathUtil.getClassPath("/conf/grid/excel/");
	
	// 工作簿 (可读不可写)
	public Workbook workbook;
	
	// 工作表
	public Sheet sheet;
	
	// 总行数
	public int totalRow;
	
	// 总列数
	public int totalColumn;
	
	public Row row;
	
	public Cell cell;
	
	public Cell[] cells;
	
	public String contents;
	
	public WritableWorkbook writableWorkbook;
	
	public WritableSheet writableSheet;
	
	public WritableFont writableFont;
	
	public WritableCellFormat writableCellFormat;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}

}
