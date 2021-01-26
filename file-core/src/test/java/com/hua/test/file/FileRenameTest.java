/**
 * 描述: 
 * FileRenameTest.java
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
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FileRenameTest
 */
public final class FileRenameTest extends BaseTest {

	/**
	 * 
	 * 描述: 文件重命名
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileRename() {
		try {
			filePath = ProjectUtil.getAbsolutePath("/doc/out/abc.txt", true);
			System.out.println(filePath);
			file = new File(filePath);
			
			filePath = ProjectUtil.getAbsolutePath("/doc/out/d/abc-rename.txt", true);
			File renameFile = new File(filePath);
			
			file.renameTo(renameFile);
			
		} catch (Exception e) {
			log.error("testFileRename =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 目录重命名
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDirectoryRename() {
		try {
			
			directoryPath = ProjectUtil.getAbsolutePath("/doc/out", true);
			System.out.println(directoryPath);
			
			file = new File(directoryPath);
			System.out.println("directory name = " + file.getName());
			
			directoryPath = ProjectUtil.getAbsolutePath("/doc/out1", true);
			File renameFile = new File(directoryPath);
			file.renameTo(renameFile);
		} catch (Exception e) {
			log.error("testDirectoryRename =====> ", e);
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
