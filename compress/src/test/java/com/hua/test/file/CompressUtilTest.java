/**
 * 描述: 
 * CompressUtilTest.java
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

import com.hua.constant.Constant;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.CompressUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CompressUtilTest
 */
public final class CompressUtilTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCompressUtil() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCompressUtil =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZip() {
		try {
			String destZipPath = ProjectUtil.getAbsolutePath("/doc/zip/文件压缩-zip.zip", true);
			String filePath = ClassPathUtil.getClassPath("/file/");
			File sourceFile = new File(filePath);
			CompressUtil.zip(sourceFile, destZipPath, Constant.CHART_SET_UTF_8);
			
		} catch (Exception e) {
			log.error("testZip =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 压缩空目录
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipEmpty() {
		try {
			String destZipPath = ProjectUtil.getAbsolutePath("/doc/zip/文件压缩-empty-zip.zip", true);
			String filePath = ClassPathUtil.getClassPath("/file/empty/");
			File sourceFile = new File(filePath);
			CompressUtil.zip(sourceFile, destZipPath, Constant.CHART_SET_UTF_8);
			
		} catch (Exception e) {
			log.error("testZipEmpty =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipDirectoryNullParam() {
		try {
			String destZipPath = ProjectUtil.getAbsolutePath("/doc/zip/文件压缩-zip.zip", true);
			String filePath = ClassPathUtil.getClassPath("/file/");
			File sourceFile = new File(filePath);
			destZipPath = null;
			CompressUtil.zip(sourceFile, destZipPath, Constant.CHART_SET_UTF_8);
			
		} catch (Exception e) {
			log.error("testZipDirectoryNullParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipFileNullParam() {
		try {
			String destZipPath = ProjectUtil.getAbsolutePath("/doc/zip/文件压缩-zip.zip", true);
			String filePath = ClassPathUtil.getClassPath("/file/img/cat.jpg");
			File sourceFile = new File(filePath);
			destZipPath = null;
			CompressUtil.zip(sourceFile, destZipPath, Constant.CHART_SET_UTF_8);
			
		} catch (Exception e) {
			log.error("testZipFileNullParam =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnzip() {
		try {
			String destUzipPath = ProjectUtil.getAbsolutePath("/doc/unzip/", true);
			String filePath = ClassPathUtil.getClassPath("/file.zip");
			File sourceFile = new File(filePath);
			CompressUtil.unzip(sourceFile, destUzipPath, Constant.CHART_SET_UTF_8);
			
		} catch (Exception e) {
			log.error("testUnzip =====> ", e);
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
