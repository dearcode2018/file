/**
 * 描述: 
 * FileSort.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.sort;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 描述: 
 * @author  qye.zheng
 * 
 * FileSort
 */
public final class FileSort
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	private FileSort()
	{
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param files
	 * @param sortType 排序类型 (升序或降序)
	 */
	public static void sortByName(final File[] files, final String sortType)
	{
		final Comparator<File> comparator = FilenameComparator.getComparator(sortType);
		Arrays.sort(files, comparator);
	}
	
}
