/**
 * AntZipUtil.java
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

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import com.hua.constant.Constant;
import com.hua.constant.ZipConstant;

/**
 * AntZipUtil
 * 描述: ant zip 工具
 * @author  qye.zheng
 */
public final class AntZipUtil
{

	private static final boolean unClose = false;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private AntZipUtil()
	{
	}

	/**
	 * 
	 * @description 文件/目录压缩
	 * @param source  原文件/目录
	 * @param destZipPath 目的zip路径，为空，压缩到当前目录 若是文件则以文件前缀名命名，若是目录则以目录名称命名
	 * @return
	 * @author qye.zheng
	 */
	public static final boolean zip(final String source, String destZipPath)
	{
		boolean flag = false;
		// 构造文件对象，然后调用File参数的方法
		final File sourceFile = new File(source);
		if (StringUtil.isEmpty(destZipPath))
		{
			destZipPath = getDefaultZipPath(sourceFile);
		}
		final File destZipFile = new File(destZipPath);
		ZipOutputStream zipOutputStream = null;
		try {
			zipOutputStream = new ZipOutputStream(new FileOutputStream(destZipFile));
			// 路径截取下标 
			final int startTrimIndex = getStartTrimIndex(sourceFile);
			zipFile(sourceFile, startTrimIndex, zipOutputStream);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally
		{
			IOUtil.close(zipOutputStream);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @description 
	 * @param sourceFile
	 * @param startTrimIndex
	 * @author qye.zheng
	 */
	private static void zipFile(final File sourceFile, final int startTrimIndex, final ZipOutputStream zipOutputStream)
	{
		InputStream inputStream = null;
		ZipEntry zipEntry = null;
		try
		{
			String pathName = null;
			File[] files = null;
			if (sourceFile.isDirectory())
			{
				// 目录
				files = sourceFile.listFiles();
			} else
			{
				// 文件，构造大小为1的文件数组
				files = new File[] { sourceFile };
			}
			for (File file : files)
			{
				// System.out.println(file.getName());
				if (file.isDirectory())
				{
					// 目录，递归调用处理
					/**
					 * pathName = file.getPath().substring(startTrimIndex) +
					 * File.separator; -- 会出现空文件 pathName =
					 * file.getPath().substring(startTrimIndex) + "/"; -- 正常
					 * pathName = file.getPath().substring(startTrimIndex); --
					 * 所有目录都会呈现空白状态
					 */
					// pathName = file.getPath().substring(startTrimIndex) + File.separator;
					// pathName = file.getPath().substring(startTrimIndex);
					pathName = file.getPath().substring(startTrimIndex) + Constant.SLASH;
					System.out.println("目录，递归调用处理: " + pathName);
					zipEntry = new ZipEntry(pathName);
					// 放入 ZipOutputStream 下一个项
					zipOutputStream.putNextEntry(zipEntry);
					// 递归调用
					zipFile(file, startTrimIndex, zipOutputStream);
				} else
				{
					// 文件 - 直接压缩处理
					// 相对路径名称: a.txt 或 b/a.txt (+1 表示 排除 前路径分隔符)
					pathName = file.getPath().substring(startTrimIndex);
					// pathName = file.getPath().substring(basePath.length() +1);
					System.out.println("文件: " + pathName);
					inputStream = new FileInputStream(file);
					zipEntry = new ZipEntry(pathName);
					zipOutputStream.putNextEntry(zipEntry);
					// 输出
					IOUtil.transport(inputStream, zipOutputStream, unClose);
					// 关闭本次输入流
					IOUtil.close(inputStream);
				}
			} 
			// 刷新缓存
			zipOutputStream.flush();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: 获取每次压缩目录开始截取的下标
	 * @author  qye.zheng
	 * @param sourceFile
	 * @return
	 */
	private static int getStartTrimIndex(final File sourceFile)
	{
		// 获取基本目录
		String basePath = null;
		int startTrimIndex = Constant.NEGATIVE_ONE;
		if (sourceFile.isDirectory())
		{
			/*
			 基本目录指向父级目录，把当前指定的目录包含在压缩包内
			 */
			basePath = sourceFile.getParent();
			/*
			 解决windows 盘符是英文字母和放斜杠构成
			 当parent是盘符时，后面以反斜杠结束
			 */
			// 判断是否以斜杠结束
			if (basePath.endsWith(File.separator))
			{
				// 以斜杠结束，无需 +1排除 前路径分割符
				startTrimIndex = basePath.length();	
			} else
			{
				// 父路径没有以斜杠结束，因此需要+1 排除 前路径分割符
				startTrimIndex = basePath.length() + Constant.ONE;	
			}
			System.out.println("basePath = " + basePath);
		} else
		{
			// 文件 - 获取父级目录
			basePath = sourceFile.getParent();
			// 路径截取下标 (+1 表示排除 前路径分割符)
			startTrimIndex = basePath.length() + Constant.ONE;	
		}
		
		return startTrimIndex;
	}
	
	/**
	 * 
	 * @description 文件 解压缩
	 * @param zipPath  zip文件路径
	 * @param destUnzipDir 目的zip解压路径，为空，解压到当前目录
	 * @return
	 * @author qye.zheng
	 */
	public static final boolean unzip(final String zipPath, String destUnzipDir)
	{
		boolean flag = false;
		final File sourceFile = new File(zipPath);
		if (StringUtil.isEmpty(destUnzipDir))
		{
			destUnzipDir = sourceFile.getParent();
		}
		InputStream inputStream = null;
		OutputStream outputStream = null;
		ZipFile zipFile = null;
		try {
			ZipEntry zipEntry = null;
			// TODO 牵涉到 中文乱码 问题
			zipFile = new ZipFile(zipPath, Constant.CHART_SET_UTF_8);
			File file = null;
			File parent = null;
			final Enumeration<ZipEntry> entries = zipFile.getEntries();
			while (entries.hasMoreElements())
			{
				zipEntry = entries.nextElement();
				System.out.println("entryName = " + zipEntry.getName());
				file = new File(destUnzipDir, zipEntry.getName());
				if (zipEntry.isDirectory())
				{
					// 创建目录
					file.mkdirs();
					
					continue;
				} else
				{
					// 文件
					parent = file.getParentFile();
					if (!parent.exists())
					{
						// 创建父目录
						parent.mkdirs();
					}
					// 创建文件
					file.createNewFile();
					/**
					 * 输入/输出流 都是一次性的
					 */
					inputStream = zipFile.getInputStream(zipEntry);
					outputStream = new FileOutputStream(file);
					IOUtil.transport(inputStream, outputStream);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally 
		{
			// 安静关闭
			ZipFile.closeQuietly(zipFile);
		}
		
		return flag;
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
