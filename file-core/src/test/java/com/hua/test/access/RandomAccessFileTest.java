/**
 * 描述: 
 * RandomAccessFileTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.access;

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
import java.io.RandomAccessFile;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 随机访问文件
 * 
 * @author qye.zheng
 * RandomAccessFileTest
 */
public final class RandomAccessFileTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRandomAccessFile() {
		try {
			
			
		} catch (Exception e) {
			log.error("testRandomAccessFile =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 断线续传 - 模拟
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBreakPointContinueSimulate() {
		try {
			/**
			 * 模拟拷贝文件的时候，拷贝指定的字节
			 * 从指定的字节开始读取指定的长度，然后写到指定开始字节
			 */
			int length = 10;
			length = 135749;
			long start = 0;
			start = 10;
			start = 20;
			byte[] data = new byte[length];
			// 该文件 135,769 字节
			String sourcePath = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
			File source = new File(sourcePath);
			
			String destPath = ProjectUtil.getAbsolutePath("/doc/access/randomAccess.jpg", true);
			File dest = new File(destPath);			
			
			// 文件源 - 只读
			RandomAccessFile sourceRAFile = new RandomAccessFile(source, "r");
			// 文件目的地 - 读写
			RandomAccessFile destRAFile = new RandomAccessFile(dest, "rw");
			
			// 定位
			sourceRAFile.seek(start);
			// 读
			sourceRAFile.read(data, 0, length);
			
			// 写
			// 定位
			destRAFile.seek(start);
			destRAFile.write(data, 0, length);

			
			
			destRAFile.close();
			sourceRAFile.close();
		} catch (Exception e) {
			log.error("testBreakPointContinueSimulate =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 断线续传
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBreakPointContinue() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBreakPointContinue =====> ", e);
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
