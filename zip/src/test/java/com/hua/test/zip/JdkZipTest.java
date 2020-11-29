/**
 * 描述: 
 * JdkZipTest.java
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.EmptyUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdkZipTest
 */
public final class JdkZipTest extends BaseTest {
	
	private ZipOutputStream zipOutputStream;
	
	private ZipInputStream zipInputStream;
	
	private ZipEntry zipEntry;
	
	private Charset charset = Charset.forName("UTF-8");
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJdkZip() {
		try {
			
			
		} catch (Exception e) {
			log.error("testJdkZip =====> ", e);
		} finally {
			// 关闭各个流
			try
			{
				if (null != zipOutputStream)
				{
					zipOutputStream.close();
				}
				if (null != zipInputStream)
				{
					zipInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 压缩目录
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipDirectory() {
		try {
			sourceDir = ClassPathUtil.getClassSubpath("/file/source/", true);
			File sourceFile = new File(sourceDir);
			zipFilePath = ClassPathUtil.getClassSubpath("/file/zip/", true) + "广州-directory.zip";
			outputStream = new FileOutputStream(zipFilePath);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			zipOutputStream = new ZipOutputStream(bufferedOutputStream, charset);
			
			// 获取基本目录
			String basePath = null;
			if (sourceFile.isDirectory())
			{
				// 目录绝对路径
				basePath = sourceFile.getPath();
			} else
			{
				// 文件 - 获取父级目录
				basePath = sourceFile.getParent();
			}
			System.out.println("basePath = " + basePath);
			
			int startTrimIndex = basePath.length() + 1;
			
			zipFile(sourceFile, startTrimIndex);
		} catch (Exception e) {
			log.error("testZipDirectory =====> ", e);
		} finally {
			// 关闭各个流
			try
			{
				if (null != zipOutputStream)
				{
					zipOutputStream.close();
				}
				if (null != zipInputStream)
				{
					zipInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 压缩单个文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipFile() {
		try {
			sourceDir = ClassPathUtil.getClassSubpath("/file/source/白熊_01.jpg", true);
			File sourceFile = new File(sourceDir);
			zipFilePath = ClassPathUtil.getClassSubpath("/file/zip/", true) + "广州-file.zip";
			outputStream = new FileOutputStream(zipFilePath);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			zipOutputStream = new ZipOutputStream(bufferedOutputStream, charset);
			
			// 获取基本目录
			String basePath = null;
			if (sourceFile.isDirectory())
			{
				// 目录绝对路径
				basePath = sourceFile.getPath();
			} else
			{
				// 文件 - 获取父级目录
				basePath = sourceFile.getParent();
			}
			// 路径截取下标 (+1 表示排除 前路径分割符)
			int startTrimIndex = basePath.length() + 1;
			
			zipFile(sourceFile, startTrimIndex);
		} catch (Exception e) {
			log.error("testZipFile =====> ", e);
		} finally {
			// 关闭各个流
			try
			{
				if (null != zipOutputStream)
				{
					zipOutputStream.close();
				}
				if (null != zipInputStream)
				{
					zipInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 解压缩 zip 文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnZip() {
		try {
			// 指定编码，解决中文命名解析失败问题
			charset = Charset.forName("GB2312");
			targetPath = ClassPathUtil.getClassSubpath("/file/unzip/", true) + "广州-directory";
			zipFilePath = ClassPathUtil.getClassSubpath("/file/zip/广州-directory.zip", true);
			// 指定编码，解决中文无法解析问题 (必须指定为GB2312, UTF-8解析中文失败)
			zipFile = new ZipFile(zipFilePath, charset);
			File targetFile = null;
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			byte[] data = new byte[1024];
			int length = -1;
			while (zipEntries.hasMoreElements())
			{
				zipEntry = zipEntries.nextElement();
				System.out.println("zipEntry: " + zipEntry.getName());
				targetFile = new File(targetPath + File.separator + zipEntry.getName());
				if (zipEntry.isDirectory())
				{
					// 压缩文件中存在空目录(其下没有文件)
					//System.out.println("空目录...");
					// 创建多级目录，不再往下执行
					if (!targetFile.exists())
					{
						targetFile.mkdirs();
					}
					
					continue;
				} else
				{
					if (!targetFile.getParentFile().exists())
					{
						System.out.println("创建多级父目录");
						// 创建多级父目录
						targetFile.getParentFile().mkdirs();
					}
				}
				System.out.println(targetFile.getAbsolutePath());
				if (zipEntry.getSize() > 0)
				{
					outputStream = new FileOutputStream(targetFile);
					bufferedOutputStream = new BufferedOutputStream(outputStream);
					inputStream = zipFile.getInputStream(zipEntry);
					//zipInputStream = new ZipInputStream(inputStream, charset);
					// 输出流
					while (-1 != (length = inputStream.read(data)))
					{
						bufferedOutputStream.write(data, 0, length);
					}
				} else
				{
					// 空文件
					System.out.println("空文件...");
					
					// 防止空文件存在，而目录没有创建的情况
					if (!targetFile.exists())
					{
						targetFile.mkdirs();
					}
					
					continue;
				}
				
				// 关闭每次循环创建的输出流
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
				outputStream.flush();
				outputStream.close();
				//zipInputStream.close();
				inputStream.close();
			}
			
		} catch (Exception e) {
			log.error("testUnZip =====> ", e);
		} finally {
			// 关闭各个流
			try
			{
				if (null != zipOutputStream)
				{
					zipOutputStream.close();
				}
				if (null != zipInputStream)
				{
					zipInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 解压缩 zip 文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnZipDeprecated() {
		try {
			
			sourceDir = ClassPathUtil.getClassSubpath("/file/zip/广州-directory.zip", true);
			File sourceFile = new File(sourceDir);
			inputStream = new FileInputStream(sourceFile);
			
			unZipFilePath = ClassPathUtil.getClassSubpath("/file/unzip/", true) + "广州-unzip";
			System.out.println(unZipFilePath);
			File unZipFile = new File(unZipFilePath);
			if (!unZipFile.exists())
			{
				unZipFile.mkdirs();
			}
			// 设置为可读写
			unZipFile.setReadable(true);
			unZipFile.setWritable(true);
			
			outputStream = new FileOutputStream(unZipFile);
			
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			zipInputStream = new ZipInputStream(inputStream, charset);
			
			byte[] data = new byte[1024];
			int length = -1;
			
			/**
			 循环遍历，直到获取到的ZipEntry不为空为止
			 zipEntry存放了压缩包中的文件信息
			 */
			while (null != (zipEntry = zipInputStream.getNextEntry()))
			{
				log.info("testUnZip =====> " + zipEntry.getName());
				while (-1 != (length = zipInputStream.read(data)))
				{
					//bufferedOutputStream.write(data, 0, length);
				}
				//log.info("testUnZip =====> " + zipEntry.getExtra().length);
			}
			
			bufferedOutputStream.flush();
		} catch (Exception e) {
			log.error("testUnZip =====> ", e);
		} finally {
			// 关闭各个流
			try
			{
				if (null != zipOutputStream)
				{
					zipOutputStream.close();
				}
				if (null != zipInputStream)
				{
					zipInputStream.close();
				}
				if (null != bufferedOutputStream)
				{
					bufferedOutputStream.close();
				}
				if (null != bufferedInputStream)
				{
					bufferedInputStream.close();
				}
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZipUtil() {
		try {
			
			
		} catch (Exception e) {
			log.error("testZipUtil =====> ", e);
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
			File file = new File(ClassPathUtil.getClassSubpath("/file/txt/小说_文本_01.txt", true));
			file = new File(ClassPathUtil.getClassSubpath("/file/txt/", true));
			System.out.println(file.getPath());
			
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
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param source
	 * @param startTrimIndex
	 */
	private void zipFile(final File source, final int startTrimIndex)
	{
		try {
			File[] files = null;
			if (source.isDirectory())
			{
				// 目录
				files = source.listFiles();
			} else
			{
				// 文件，构造大小为1的文件数组
				files = new File[] {source};
			}
			String pathName = null;
			byte[] data = new byte[1024];
			int length = -1;
				for (File file : files)
				{
					//System.out.println(file.getName());
					if (file.isDirectory())
					{
						// 目录，递归调用处理
						/**
						 pathName = file.getPath().substring(startTrimIndex) + File.separator; -- 会出现空文件
						 pathName = file.getPath().substring(startTrimIndex) + "/"; -- 正常
						 pathName = file.getPath().substring(startTrimIndex); -- 所有目录都会呈现空白状态
						 */
						// pathName = file.getPath().substring(startTrimIndex) + File.separator;
						//pathName = file.getPath().substring(startTrimIndex);
						pathName = file.getPath().substring(startTrimIndex) + "/";
						System.out.println("目录，递归调用处理: " + pathName);
						zipEntry = new ZipEntry(pathName);
						// 放入 ZipOutputStream 下一个项
						zipOutputStream.putNextEntry(zipEntry);
						// 递归调用
						zipFile(file, startTrimIndex);
					} else
					{
						// 文件 - 直接压缩处理
						// 相对路径名称: a.txt 或 b/a.txt (+1 表示 排除 前路径分隔符)
						pathName = file.getPath().substring(startTrimIndex);
						//pathName = file.getPath().substring(basePath.length() + 1);
						System.out.println("文件: " + pathName);
						inputStream = new FileInputStream(file);
						bufferedInputStream = new BufferedInputStream(inputStream);
						zipEntry = new ZipEntry(pathName);
						zipOutputStream.putNextEntry(zipEntry);
						// 输出
						while (-1 != (length = bufferedInputStream.read(data)))
						{
							zipOutputStream.write(data, 0, length);
						}
					}
				}
				
			// 刷新缓存
			zipOutputStream.flush();
		} catch (Exception e) {
			log.error("zipFile =====> ", e);
		}
	}

}
