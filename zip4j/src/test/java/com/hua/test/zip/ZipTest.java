/**
 * 描述: 
 * ZipTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.zip;

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

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ZipTest
 */
public final class ZipTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZip() {
		try {
			String srcPath = null;
			// 压缩一个文件
			//srcPath = ClassPathUtil.getClassPath("/conf/file/img/白熊_01.jpg", true);
			// 压缩目录
			srcPath = ClassPathUtil.getClassPath("/conf/file/img");
			srcPath = ClassPathUtil.getClassPath("/conf");
			String destPath = ProjectUtil.getAbsolutePath("/doc/zip", true);
			File srcFile = new File(srcPath);
			
			ZipParameters zipParameters = new ZipParameters();
			// 设置压缩方法: 默认
			zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			// 设置压缩级别: 默认正常
			zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			
			password = null;
			// 加密
			if (StringUtil.isNotEmpty(password))
			{
				// 使用密码压缩
				zipParameters.setEncryptFiles(true);
				// 加密方法
				zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
				// 设置密码
				zipParameters.setPassword(password);
			}
	        ZipFile zipFile = null;
			String zipFilename = null;
			if (srcFile.isFile())
			{ // 压缩单个文件 获取文件前缀作为压缩文件名
				zipFilename = srcFile.getName().substring(0, srcFile.getName().lastIndexOf('.'));
				zipFilename += ".zip";
				zipFile = new ZipFile(destPath + "/" + zipFilename);  
				zipFile.addFile(srcFile, zipParameters);
			} else
			{ // 压缩目录
				zipFile = new ZipFile(destPath + "/" + srcFile.getName() + ".zip");  
				// 注意这里是 addFolder
				zipFile.addFolder(srcFile, zipParameters);
			}
			
		} catch (Exception e) {
			log.error("testZip =====> ", e);
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
