/**
 * 描述: 
 * FilePathTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.file;

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

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FilePathTest
 */
public final class FilePathTest extends BaseTest {

	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFilePath() {
		try {
			filePath = ClassPathUtil.getClassSubpath("/file/txt/小说_文本_01.txt", true);
			filePath = ClassPathUtil.getClassSubpath("/file/txt/", true);
			//filePath ="D:/fs/";
			file = new File(filePath);
			
			System.out.println("getParent = " + file.getParent());
			System.out.println("getPath = " + file.getPath());
			System.out.println(file.list()[0]);
			
			// 指定根路径，将以当前磁盘为根路径 -- 一般用于指定绝对路径
			file = new File("/a/b/c/");
			/*
				获取File(String pathname) 构造方法的参数值，进行本地化处理
			 */
			System.out.println("getPath = " + file.getPath());
			
			/**
			 获取绝对路径，相对路径经过一定处理之后，变成本地化的绝对路径
			 从根开始
			 */
			System.out.println("getAbsolutePath = " + file.getAbsolutePath());
			
			
			// 不指定根路径，默认当前运行路径为根路径 -- 一般用于指定相对路径
			file = new File("a/b/c/");
			/*
				获取File(String pathname) 构造方法的参数值，进行本地化处理
			 */
			System.out.println("getPath = " + file.getPath());
			
			/**
			 获取绝对路径，相对路径经过一定处理之后，变成本地化的绝对路径
			 从根开始
			 */
			System.out.println("getAbsolutePath = " + file.getAbsolutePath());
			
			System.out.println("getParent = " + file.getParent());
			
		} catch (Exception e) {
			log.error("testFilePath =====> ", e);
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
