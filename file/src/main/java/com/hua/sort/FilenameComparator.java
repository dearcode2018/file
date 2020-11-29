/**
 * 描述: 
 * FilenameComparator.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.sort;

import java.io.File;
import java.util.Comparator;

import com.hua.constant.Constant;
import com.hua.constant.SortConstant;
import com.hua.util.StringUtil;

/**
 * 描述: 文件名比较器
 * @author  qye.zheng
 * 
 * FilenameComparator
 */
public class FilenameComparator
{

	/**
	 * 
	 * 描述: 获取比较器
	 * @author qye.zheng
	 * 
	 * @param sortType 排序类型 (升序或降序)
	 * @return
	 */
	public static Comparator<File> getComparator(final String sortType)
	{
		if (StringUtil.isEmpty(sortType) || SortConstant.ASC.equals(sortType))
		{
			// 若为空，默认使用升序比较器
			return new AscComparator();
		} else if (SortConstant.DESC.equals(sortType))
		{
			//	降序比较器
			return new DescComparator();
		}
		
		return null;
	}

	/**
	 * 
	 * 描述: 升序比较器
	 * @author  qye.zheng
	 * 
	 * AscComparator
	 */
	private static class AscComparator implements Comparator<File> {

		 /**
		 * 描述: 
		 * @author qye.zheng
		 * 
		 * @param f1
		 * @param f2
		 * @return
		 */
		@Override
		public int compare(final File f1, final File f2)
		{
			return common(f1, f2, this.getClass());
		}
		
	}

	/**
	 * 
	 * 描述: 降序比较器
	 * @author  qye.zheng
	 * 
	 * AscComparator
	 */
	private static class DescComparator implements Comparator<File> {

		 /**
		 * 描述: 
		 * @author qye.zheng
		 * 
		 * @param f1
		 * @param f2
		 * @return
		 */
		@Override
		public int compare(final File f1, final File f2)
		{
			return common(f1, f2, this.getClass());
		}
		
	}
	
	/**
	 * 
	 * 描述: 公共部分
	 * @author qye.zheng
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	private static int common(final File f1, final File f2, final Class<?> clazz)
	{
		// 一个是文件，一个是目录，则目录排在后面
		if (f1.isDirectory() && f2.isFile())
		{
			return Constant.NEGATIVE_ONE;
		} else if (f1.isFile() && f2.isDirectory())
		{
			return Constant.ONE;
		}
		
		// 同为 文件 或 目录
		if (AscComparator.class == clazz)
		{
			// 升序
			return StringUtil.digitStringCompare(f1.getName(), f2.getName());
		} else if (DescComparator.class == clazz)
		{
			// 降序
			return StringUtil.digitStringCompare(f2.getName(), f1.getName());
		}
		
		return Constant.ZERO;
	}
	
}
