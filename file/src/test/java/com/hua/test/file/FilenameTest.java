/**
 * 描述: 
 * FilenameTest.java
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
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FilenameTest
 */
public final class FilenameTest extends BaseTest {

	private String filename;
	
	private String prefix;
	
	private String suffix;
	
	/**
	 * 
	 * 描述: 删除文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetFilename() {
		try {
			filePath = ProjectUtil.getAbsolutePath("/doc/out/abc.txt", true);
			
			System.out.println(filePath);
			file = new File(filePath);
			
			System.out.println("filename = " + file.getName());
			
			directoryPath = ProjectUtil.getAbsolutePath("/doc/out", true);
			System.out.println(directoryPath);
			
			file = new File(directoryPath);
			System.out.println("directory name = " + file.getName());
			
			System.out.println("parent path = " + file.getParent());
			
		} catch (Exception e) {
			log.error("testGetFilename =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCoverTimestamp() {
		try {
			filename = "abc.txt";
			log.info("testCoverTimestamp =====> " + FileUtil.coverTimestamp(filename));
			
			filename = "abc";
			log.info("testCoverTimestamp =====> " + FileUtil.coverTimestamp(filename));
			
		} catch (Exception e) {
			log.error("testCoverTimestamp =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFilename() {
		try {
			
			String filename = "abc.txt";
			prefix = FileUtil.getPrefix(filename);
			log.info("testFilename =====> prefix = " + prefix);
			suffix = FileUtil.getSuffix(filename);
			log.info("testFilename =====> suffix = " + suffix);
			
			filename = "/a/b/abc.txt";
			prefix = FileUtil.getPrefix(filename);
			log.info("testFilename =====> prefix = " + prefix);
			suffix = FileUtil.getSuffix(filename);
			log.info("testFilename =====> suffix = " + suffix);
			
			filename = "\\a\\b\\abc.txt";
			prefix = FileUtil.getPrefix(filename);
			log.info("testFilename =====> prefix = " + prefix);
			suffix = FileUtil.getSuffix(filename);
			log.info("testFilename =====> suffix = " + suffix);
			
		} catch (Exception e) {
			log.error("testFilename =====> ", e);
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
			
			String str = "中国";
			//log.info("testTemp =====> " + StringUtil.toUtf8String(str));
			
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
