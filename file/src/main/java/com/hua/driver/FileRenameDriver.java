/**
 * 描述: 
 * FileRenameDriver.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hua.constant.SortConstant;
import com.hua.sort.FileSort;
import com.hua.util.StringUtil;

/**
 * 描述: 文件 - 重命名
 * @author  qye.zheng
 * 
 * FileRenameDriver
 */
public final class FileRenameDriver
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	private FileRenameDriver()
	{
	}
	
	/**
	 * 
	 * 描述: 批量重命名
	 * 从1开始, prfix-01.suffix
	 * @author qye.zheng
	 * 
	 * @param directory 目录 (不以斜杠结束) 例如: /a/b/c
	 * @param prefix 文件名-前缀
	 * @param index 序列开始索引 (应该>=0)
	 */
	public static void batchRename(final String directory, final String prefix, final int index)
	{
		try
		{
			final File file = new File(directory);
			final File[] files = file.listFiles();
			FileSort.sortByName(files, SortConstant.ASC);
			File f = null;
			// 文件总数
			final int total = files.length;
			// 文件名数字部分总位数 (例如 文件在100个以内 总位数为2)
			final int maxLength = String.valueOf(total).length();
			// 避免序列生成混乱，将文件取出放单独一个集合
			final List<File> onlyFiles = new ArrayList<File>();
			for (int i = 0; i < total; i++)
			{
				f = files[i];
				// 忽略目录，只操作文件
				if (f.isFile())
				{
					onlyFiles.add(f);
					System.out.println("filename = " + f.getName());
				}
			}
			// 文件后缀名(每个文件可能不同)
			String suffix = null;
			// 数字序列
			String sequence = null;
			// 文件名 - 重命名前
			String oldName = null;
			// 文件名 - 重命名后
			String newName = null;
			// 重命名后目标对象 (目录不同就拷贝，同一目录则直接修改名字)
			File dest = null;
			for (int i = 0; i < onlyFiles.size(); i++)
			{
				f = onlyFiles.get(i);
				// 忽略目录，只操作文件
				/*if (f.isDirectory())
				{
					System.out.println("忽略目录，只操作文件");
					continue;
				}*/
				oldName = f.getName();
				// 获取文件名后缀
				suffix = oldName.substring(oldName.lastIndexOf(".") + 1);
				// 忽略 - 后缀名为空
				if (StringUtil.isEmpty(suffix))
				{
					System.out.println("忽略 - 后缀名为空");
					continue;
				}
				// 生成序列 (例如: 001) 注意 i 应该加1
				sequence = StringUtil.addZero(i + index, maxLength);
				// abc-001.txt
				newName = prefix + "-" + sequence + "." + suffix;
				// 创建目标文件对象
				dest = new File(directory + "/" + newName);
				// 执行重命名
				//f.renameTo(dest);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	


}
