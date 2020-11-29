/**
 * 描述: 
 * ZipUtilTest.java
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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ZipUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ZipUtilTest
 */
public final class ZipUtilTest extends BaseTest {

	private File sourceFile;
	
	private File[] sourceFiles;
	
	private String path;
	
	private String[] paths;
	
	private String destZipPath;
	
	private String destUnzipDir;
	
	/**
	 * 
	 * 描述: 压缩一个空目录
	 * (该目录是一个空目录，其下没有文件或者空目录)
	 * 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipEmptyDirectory() {
		try {
			sourceFiles = new File[2];
			sourceFiles[0] = new File("D:/需要压缩2/empty/");
			sourceFiles[1] = new File("D:/需要压缩2/empty - 副本/");
			//sourceFile = new File("D:/需要压缩1/餐饮通产品需求规格说明书v0.1.doc");
			destZipPath = "D:/compress.zip";
			ZipUtil.zip(sourceFiles, destZipPath);
			
		} catch (Exception e) {
			log.error("testZipEmptyDirectory =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipDiskFile() {
		try {
			sourceFile = new File("D:/需要压缩1");
			sourceFile = new File("D:/资料/Face");
			//sourceFile = new File("D:/需要压缩1/餐饮通产品需求规格说明书v0.1.doc");
			destZipPath = "D:/compress.zip";
			ZipUtil.zip(sourceFile, destZipPath);
			
		} catch (Exception e) {
			log.error("testZipDiskFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipFile() {
		try {
			sourceFile = new File(ClassPathUtil.getClassPath("/file/source/"));
			//sourceFile = new File("D:/需要压缩1/餐饮通产品需求规格说明书v0.1.doc");
			destZipPath = ClassPathUtil.getClassPath("/file/zip/") + "test-zip-1.zip";
			ZipUtil.zip(sourceFile, destZipPath);
			
		} catch (Exception e) {
			log.error("testZipFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipFiles() {
		try {
			sourceFiles = new File[2];
			sourceFiles[0] = new File(ClassPathUtil.getClassPath("/file/source/"));
			sourceFiles[1] = new File(ClassPathUtil.getClassPath("/file/txt/"));
			destZipPath = ClassPathUtil.getClassPath("/file/zip/") + "test-zip-2.zip";
			ZipUtil.zip(sourceFiles, destZipPath);
			
		} catch (Exception e) {
			log.error("testZipFiles =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipPath() {
		try {
			path = ClassPathUtil.getClassPath("/file/source/");
			destZipPath = ClassPathUtil.getClassPath("/file/zip/") + "test-zip-1.zip";
			ZipUtil.zip(path, destZipPath);
		} catch (Exception e) {
			log.error("testZipPath =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipPaths() {
		try {
			paths = new String[2];
			paths[0] = ClassPathUtil.getClassPath("/file/source/");
			paths[1] = ClassPathUtil.getClassPath("/file/txt/");
			destZipPath = ClassPathUtil.getClassPath("/file/zip/") + "test-zip-2.zip";
			ZipUtil.zip(paths, destZipPath);
			
		} catch (Exception e) {
			log.error("testZipPaths =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnzipFile() {
		try {
			sourceFile = new File(ClassPathUtil.getClassPath("/file/zip/test-zip-1.zip"));
			destUnzipDir =ClassPathUtil.getClassPath("/file/unzip/");
			ZipUtil.unzip(sourceFile, destUnzipDir);
		} catch (Exception e) {
			log.error("testUnzipFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnzipFiles() {
		try {
			sourceFiles = new File[2];
			sourceFiles[0] = new File(ClassPathUtil.getClassPath("/file/zip/test-zip-1.zip"));
			sourceFiles[1] = new File(ClassPathUtil.getClassPath("/file/zip/test-zip-2.zip"));
			destUnzipDir =ClassPathUtil.getClassPath("/file/unzip/");
			ZipUtil.unzip(sourceFiles, destUnzipDir);
			
		} catch (Exception e) {
			log.error("testUnzipFiles =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnzipPath() {
		try {
			path = ClassPathUtil.getClassPath("/file/zip/test-zip-1.zip");
			destUnzipDir =ClassPathUtil.getClassPath("/file/unzip/");
			ZipUtil.unzip(path, destUnzipDir);
		} catch (Exception e) {
			log.error("testUnzipPath =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnzipPaths() {
		try {
			paths = new String[2];
			paths[0] = ClassPathUtil.getClassPath("/file/zip/test-zip-1.zip");
			paths[1] = ClassPathUtil.getClassPath("/file/zip/test-zip-2.zip");
			destUnzipDir =ClassPathUtil.getClassPath("/file/unzip/");
			ZipUtil.unzip(paths, destUnzipDir);
			
		} catch (Exception e) {
			log.error("testUnzipPaths =====> ", e);
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
