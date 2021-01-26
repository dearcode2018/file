/**
 * 描述: 
 * FileDeleteTest.java
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

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FileDeleteTest
 */
public final class FileDeleteTest extends BaseTest {

	/**
	 * 
	 * 描述: 删除文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFile() {
		try {
			filePath = ProjectUtil.getAbsolutePath("/doc/out/abc.txt", true);
			
			System.out.println(filePath);
			file = new File(filePath);
			// 删除文件
			file.delete();
			
			// 退出时删除 - 一般用于临时文件
			//file.deleteOnExit();
			
		} catch (Exception e) {
			log.error("testFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除目录
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDirectory() {
		try {
			
			/**
			 只能删除空目录，非空目录不能直接删除，应该
			 先递归删除目录下的所有文件对象，最后再删除该目录
			 */
			
			directoryPath = ProjectUtil.getAbsolutePath("/doc/out", true);
			System.out.println(directoryPath);
			
			file = new File(directoryPath);
			
			// 删除目录
			file.delete();
			
		} catch (Exception e) {
			log.error("testDirectory =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteFileOfApacheIO() {
		try {
			String path = "/data/o2omember/upload/2015/7/21/1c2c0dd6-9e4f-4753-b169-f6fa9c580bf2.白熊_01";
			File file = new File(path);
			FileUtils.deleteQuietly(file);
		} catch (Exception e) {
			log.error("testDeleteFileOfApacheIO =====> ", e);
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
