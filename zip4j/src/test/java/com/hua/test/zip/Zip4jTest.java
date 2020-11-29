/**
 * 描述: 
 * Zip4jTest.java
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.Constant;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * Zip4jTest
 */
public final class Zip4jTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveFileInZip() {
		try {
			/*
			 * 删除zip文件中的文件，路径例如: a/b/c/good.txt
			 */
			String zipFilePath = ProjectUtil.getAbsolutePath("/doc/测试abc.zip", true);
			ZipFile zipFile = new ZipFile(new File(zipFilePath));
			/*
			 * 在中文系统中，需要设置为GB2312
			 * setFileNameCharset 需要在构造ZipFile对象之后立即调用才能有效执行
			 */
			//zipFile.setFileNameCharset(Constant.CHART_SET_UTF_8);
			zipFile.setFileNameCharset(Constant.CHART_SET_GB2312);
			if (!zipFile.isValidZipFile())
			{ // 检查zip文件是否合法
				throw new ZipException("压缩文件不合法,可能被损坏.");
			}
			String password = "";
			if (zipFile.isEncrypted())
			{ // 检查是需要密码
				zipFile.setPassword(password);
			}
			//zipFile.removeFile("project.sql");
			zipFile.removeFile("conf/file/img/pig.png");
			
		} catch (Exception e) {
			log.error("testRemoveFileInZip =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemoveDirInZip() {
		try {
			/*
			 * 删除zip文件中的目录
			 * 先删除目录下的所有文件，最后将目录删除
			 */
			String zipFilePath = ProjectUtil.getAbsolutePath("/doc/测试abc.zip", true);
			ZipFile zipFile = new ZipFile(new File(zipFilePath));
			/*
			 * 在中文系统中，需要设置为GB2312
			 * setFileNameCharset 需要在构造ZipFile对象之后立即调用才能有效执行
			 */
			//zipFile.setFileNameCharset(Constant.CHART_SET_UTF_8);
			zipFile.setFileNameCharset(Constant.CHART_SET_GB2312);
			if (!zipFile.isValidZipFile())
			{ // 检查zip文件是否合法
				throw new ZipException("压缩文件不合法,可能被损坏.");
			}
			String password = "";
			if (zipFile.isEncrypted())
			{ // 检查是需要密码
				zipFile.setPassword(password);
			}
			String removeDir = "conf/";
			FileHeader dirHeader = zipFile.getFileHeader(removeDir);
			List<FileHeader> allHeaders = zipFile.getFileHeaders();
			/**
			 * 一边删除一边访问是会抛 ConcurrentModificationException
			 */
/*			for (FileHeader subHeader : allHeaders)
			{
				System.out.println(subHeader.getFileName());
				// 判断是符合条件的才删除
				if (subHeader.getFileName().startsWith(dirHeader.getFileName())
						// 目标目录要在最后才能删除 (先删除完其下的所有文件)
						&& !subHeader.getFileName().equals(dirHeader.getFileName()))
				{
					zipFile.removeFile(subHeader);
				}
			}*/
			/**
			 * 解决方法是删除一个之后 索引自减
			 */
			FileHeader subHeader = null;
			for (int i = 0; i < allHeaders.size(); i++)
			{
				subHeader = allHeaders.get(i);
				//System.out.println(subHeader.getFileName());
				// 判断是符合条件的才删除
				if (subHeader.getFileName().startsWith(dirHeader.getFileName())
						// 目标目录要在最后才能删除 (先删除完其下的所有文件)
						&& !subHeader.getFileName().equals(dirHeader.getFileName()))
				{
					zipFile.removeFile(subHeader);
					// 删除一个则回退一个索引
					i--;
				}
			}
			
			// 最后删除目标目录
			zipFile.removeFile(removeDir);
			
		} catch (Exception e) {
			log.error("testRemoveDirInZip =====> ", e);
		}
	}	
	
	/**
	 * zip4j 默认采用UTF-8编码，直接支持中文，且支持密码，支持多种压缩算法.
	 * 
	 * 
	 * 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testZip() {
		try {
			String src = ClassPathUtil.getClassPath("/conf");
			String dest = ProjectUtil.getAbsolutePath("/doc/a.zip", true);
			System.out.println("src = " + src + ", dest = " + dest);
			zip(src, dest, true, null);
		} catch (Exception e) {
			log.error("testZip =====> ", e);
		}
	}	
	
    /** 
    * 使用给定密码压缩指定文件或文件夹到指定位置. 
    * <p> 
    * dest可传最终压缩文件存放的绝对路径,也可以传存放目录,也可以传null或者"".<br /> 
    * 如果传null或者""则将压缩文件存放在当前目录,即跟源文件同目录,压缩文件名取源文件名,以.zip为后缀;<br /> 
    * 如果以路径分隔符(File.separator)结尾,则视为目录,压缩文件名取源文件名,以.zip为后缀,否则视为文件名. 
    * @param src 要压缩的文件或文件夹路径 
    * @param dest 压缩文件存放路径 
    * @param isCreateDir 是否在压缩文件里创建目录,仅在压缩文件为目录时有效.<br /> 
    * 如果为false,将直接压缩目录下文件到压缩文件. 
    * @param passwd 压缩使用的密码 
    * @return 最终的压缩文件存放的绝对路径,如果为null则说明压缩失败. 
    */
	 public static String zip(String src, String dest, boolean isCreateDir, String passwd) {  
	        File srcFile = new File(src);  
	        dest = buildDestinationZipFilePath(srcFile, dest);  
	        ZipParameters parameters = new ZipParameters();  
	        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);           // 压缩方式  
	        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);    // 压缩级别  
	        if (!StringUtils.isEmpty(passwd)) {  
	            parameters.setEncryptFiles(true);  
	            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD); // 加密方式  
	            parameters.setPassword(passwd.toCharArray());  
	        }  
	        try {  
	            ZipFile zipFile = new ZipFile(dest);  
	            if (srcFile.isDirectory()) {  
	                // 如果不创建目录的话,将直接把给定目录下的文件压缩到压缩文件,即没有目录结构  
	                if (!isCreateDir) {  
	                    File [] subFiles = srcFile.listFiles();  
	                    ArrayList<File> temp = new ArrayList<File>();  
	                    Collections.addAll(temp, subFiles);  
	                    zipFile.addFiles(temp, parameters);  
	                    return dest;  
	                }  
	                zipFile.addFolder(srcFile, parameters);  
	            } else {  
	                zipFile.addFile(srcFile, parameters);  
	            }  
	            return dest;  
	        } catch (ZipException e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	
     /** 
     * 构建压缩文件存放路径,如果不存在将会创建 
     * 传入的可能是文件名或者目录,也可能不传,此方法用以转换最终压缩文件的存放路径 
     * @param srcFile 源文件 
     * @param destParam 压缩目标路径 
     * @return 正确的压缩文件存放路径 
     */  
    private static String buildDestinationZipFilePath(File srcFile,String destParam) {  
        if (StringUtils.isEmpty(destParam)) {  
            if (srcFile.isDirectory()) {  
                destParam = srcFile.getParent() + File.separator + srcFile.getName() + ".zip";  
            } else {  
                String fileName = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));  
                destParam = srcFile.getParent() + File.separator + fileName + ".zip";  
            }  
        } else {  
            createDestDirectoryIfNecessary(destParam);  // 在指定路径不存在的情况下将其创建出来  
            if (destParam.endsWith(File.separator)) {  
                String fileName = "";  
                if (srcFile.isDirectory()) {  
                    fileName = srcFile.getName();  
                } else {  
                    fileName = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));  
                }  
                destParam += fileName + ".zip";  
            }  
        }  
        return destParam;  
    } 
    
    /** 
     * 在必要的情况下创建压缩文件存放目录,比如指定的存放路径并没有被创建 
     * @param destParam 指定的存放路径,有可能该路径并没有被创建 
     */  
    private static void createDestDirectoryIfNecessary(String destParam) {  
        File destDir = null;  
        if (destParam.endsWith(File.separator)) {  
            destDir = new File(destParam);  
        } else {  
            destDir = new File(destParam.substring(0, destParam.lastIndexOf(File.separator)));  
        }  
        if (!destDir.exists()) {  
            destDir.mkdirs();  
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
