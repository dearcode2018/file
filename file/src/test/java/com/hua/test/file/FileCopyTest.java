/**
 * 描述: 
 * FileCopyTest.java
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FileCopyTest
 */
public final class FileCopyTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileCopy() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/template.xls", true);
			File file = new File(path);
			
			InputStream inputStream = new FileInputStream(file);
			byte[] fileData = new byte[inputStream.available()];
			
			// 将
			inputStream.read(fileData);
			
			//log.info("testFileCopy =====> " + file.createNewFile());
			
			
		} catch (Exception e) {
			log.error("testFileCopy =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 输入流 和 输出流 同时操作一个文件对象
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileInput() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/abc-test.txt", true);
			File file = new File(path);
			
			// 输入流: 读取
			InputStream inputStream = new FileInputStream(file);
			byte[] b = new byte[1];
			while (-1 != inputStream.read(b))
			{
				System.out.println("-----");
			}
			//byte[] fileData = new byte[inputStream.available()];
			//inputStream.read(fileData);
			
			System.out.println("read");
			//log.info("testFileCopy =====> " + file.createNewFile());
			
			
		} catch (Exception e) {
			log.error("testFileInput =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 输入流 和 输出流 同时操作一个文件对象
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileOutput() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/abc-test.txt", true);
			File file = new File(path);
			System.out.println(file.canWrite());
			// 输出流: 写入
			OutputStream outputStream = new FileOutputStream(file);
			System.out.println(file.canWrite());
			System.out.println("write");
			//log.info("testFileCopy =====> " + file.createNewFile());
			outputStream.close();
			
		} catch (Exception e) {
			log.error("testFileOutput =====> ", e);
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
