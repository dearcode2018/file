/**
 * CompressUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import com.hua.constant.Constant;
import com.hua.constant.ZipConstant;

/**
 * CompressUtil 描述: 文件压缩 - 工具类
 * 
 * @author qye.zheng
 */
public final class CompressUtil {

	private static final int bufferSize = 1024;
	
	/**
	 * 构造方法 描述: 私有 - 禁止实例化
	 * 
	 * @author qye.zheng
	 */
	private CompressUtil() {
	}

	/**
	 * 
	 * @description
	 * @param sourceFile
	 * @param destZipPath
	 *            目的zip路径，为空， 压缩到当前目录 若是文件则以文件前缀名命名，若是目录则以目录名称命名
	 * @param charset
	 *            编码, 默认使用UTF-8
	 * @return
	 * @author qye.zheng
	 */
	public static final boolean zip(final File sourceFile, String destZipPath,
			final String charset) {
		boolean flag = false;
		if (StringUtil.isEmpty(destZipPath)) {
			destZipPath = getDefaultZipPath(sourceFile);
		}
		System.out.println("destZipPath = " + destZipPath);
		ZipArchiveOutputStream zipOutputStream = null;
		try {
			zipOutputStream = (ZipArchiveOutputStream) new ArchiveStreamFactory()
					.createArchiveOutputStream(ZipConstant.ZIP_FILE_SUFFIX,
							new FileOutputStream(destZipPath));
			// 路径截取下标
			final int startTrimIndex = getStartTrimIndex(sourceFile);
			// 设置编码
			zipOutputStream.setEncoding(charset);
			zipFile(sourceFile, zipOutputStream, startTrimIndex);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(zipOutputStream);
		}

		return flag;
	}

	/**
	 * 
	 * @description
	 * @param sourceFile
	 * @param zipOutputStream
	 * @author qye.zheng
	 */
	private static final void zipFile(final File sourceFile,
			final ZipArchiveOutputStream zipOutputStream, final int startTrimIndex) {
		File[] files = null;
		ZipArchiveEntry zipEntry = null;
		InputStream inputStream = null;
		try {
			if (sourceFile.isFile()) {
				// 文件
				// 文件，构造大小为1的文件数组
				files = new File[] { sourceFile };
			} else if (sourceFile.isDirectory()) {
				// 加一个斜杠，才能解析为目录，否则 解释为文件
				zipEntry = new ZipArchiveEntry(sourceFile.getPath().substring(startTrimIndex) + Constant.SLASH);
				// 放入 ZipOutputStream 下一个项
				zipOutputStream.putArchiveEntry(zipEntry);
				zipOutputStream.flush();
				// 关闭归档项
				zipOutputStream.closeArchiveEntry();
				// 目录
				files = sourceFile.listFiles();
			}
			if (!EmptyUtil.isEmpty(files)) {
				for (File file : files) {
					if (!file.exists()) {
						// 文件不存在
						continue;
					}
					if (file.isDirectory()) {
						// 递归调用
						zipFile(file, zipOutputStream, startTrimIndex);
						
						continue;
					}
					// 用相对路径作为在zip中的相对路径
					zipEntry = new ZipArchiveEntry(file.getPath().substring(
							startTrimIndex));
					// 放入归档项
					zipOutputStream.putArchiveEntry(zipEntry);
					inputStream = new FileInputStream(file);
					// 拷贝
					IOUtils.copy(inputStream, zipOutputStream, bufferSize);
					IOUtil.close(inputStream);
					// 关闭归档项
					zipOutputStream.closeArchiveEntry();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @description 将一个指定的zip文件所有文件都解压出来
	 * @param sourceFile
	 * @param destUnzipDir
	 * @param charset
	 *            编码, 默认使用UTF-8
	 * @return
	 * @author qye.zheng
	 */
	public static final boolean unzip(final File sourceFile,
			final String destUnzipDir, final String charset) {
		boolean flag = false;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(sourceFile, charset);
			Enumeration<ZipArchiveEntry> zipEntries = zipFile.getEntries();
			ZipArchiveEntry zipEntry = null;
			File file = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			while (zipEntries.hasMoreElements()) {
				zipEntry = zipEntries.nextElement();
				file = new File(destUnzipDir, zipEntry.getName());
				if (zipEntry.isDirectory()) {
					// 创建完整路径
					file.mkdirs();
					
					continue;
				} else {
					// 创建父目录
					file.getParentFile().mkdirs();
				}
				inputStream = zipFile.getInputStream(zipEntry);
				outputStream = new FileOutputStream(file);
				// 拷贝
				IOUtils.copy(inputStream, outputStream, bufferSize);
				
				IOUtil.close(outputStream);
				IOUtil.close(inputStream);
			}

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(zipFile);
		}

		return flag;
	}

	/**
	 * 
	 * 描述: 获取每次压缩目录开始截取的下标
	 * 
	 * @author qye.zheng
	 * @param sourceFile
	 * @return
	 */
	private static int getStartTrimIndex(final File sourceFile) {
		// 获取基本目录
		String basePath = null;
		int startTrimIndex = Constant.NEGATIVE_ONE;
		if (sourceFile.isDirectory()) {
			/*
			 * 基本目录指向父级目录，把当前指定的目录包含在压缩包内
			 */
			basePath = sourceFile.getParent();
			/*
			 * 解决windows 盘符是英文字母和放斜杠构成 当parent是盘符时，后面以反斜杠结束
			 */
			// 判断是否以斜杠结束
			if (basePath.endsWith(File.separator)) {
				// 以斜杠结束，无需 +1排除 前路径分割符
				startTrimIndex = basePath.length();
			} else {
				// 父路径没有以斜杠结束，因此需要+1 排除 前路径分割符
				startTrimIndex = basePath.length() + Constant.ONE;
			}
			System.out.println("basePath = " + basePath);
		} else {
			// 文件 - 获取父级目录
			basePath = sourceFile.getParent();
			// 路径截取下标 (+1 表示排除 前路径分割符)
			startTrimIndex = basePath.length() + Constant.ONE;
		}

		return startTrimIndex;
	}
	
	/**
	 * 
	 * @description 获取默认的 [压缩] 路径
	 * @param sourceFile
	 * @return
	 * @author qye.zheng
	 */
	private static final String getDefaultZipPath(final File sourceFile)
	{
		String destZipPath = null;
		if (sourceFile.isDirectory())
		{
			// 目录
			destZipPath = sourceFile.getParent() + File.separator + sourceFile.getName() +Constant.DOT_MARK + ZipConstant.ZIP_FILE_SUFFIX;
		} else
		{
			// 文件
			destZipPath = sourceFile.getParent() + File.separator + FileUtil.getPrefix(sourceFile.getName()) +Constant.DOT_MARK + ZipConstant.ZIP_FILE_SUFFIX;
		}
		
		return destZipPath;
	}
}
