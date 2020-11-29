/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.hua.log.BaseLog;
import com.hua.util.ClassPathUtil;

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
	
	public String outputPath;
	
	public String suffix;
	
	public String filename;
	
	public InputStream inputStream;
	
	public OutputStream outputStream;
	
	public Workbook workbook;
	
	// 工作表 org.apache.poi.ss.usermodel.Sheet
	public Sheet sheet;
	
	// 总行数
	public int totalRow;
	
	// 总列数
	public int totalColumn;
	
	// org.apache.poi.ss.usermodel.Row
	public Row row;
	
	// org.apache.poi.ss.usermodel.Cell
	public Cell cell;
	
	public Cell[] cells;
	
	public String value;
	
	public Comment comment;
	
	public HSSFPatriarch patriarch;

	
	public List<Object[]> data;
	
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
