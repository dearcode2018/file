/**
 * 描述: 
 * FileStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import org.junit.Test;

import com.hua.driver.FileRenameDriver;

/**
 * 描述: 文件启动器
 * @author  qye.zheng
 * 
 * FileStarter
 */
public final class FileStarter
{

	/**
	 * 
	 * 描述: 文件[批量]重命名
	 注意 : 需要确保原文件在体现
	 序号的前部分要保持相同
	 例如 体育运动-第1集xx.yy，而且必须是数字序号。
	 不能是中文序号
	 体育运动-第1集xx.yy
	 体育运动-第12集xx.yy
	 
	 Warning :
	 以下是不规范的，无法确保重命名后的循序和之前windows排列一样
	 体育运动233-第1集xx.yy
	 体育运动898-第23集xx.yy
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void startBatchRename()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 目录 (不以斜杠结束 例如: /a/b/c)
		// 设置例子
		// String directory = "D:/FunshionMedia/代号九耳犬-MP4";
		// String prefix = "代号九耳犬";
		
		String directory = "D:/FunshionMedia/咱们结婚吧-MP4";
		// 文件名-前缀
		String prefix = "咱们结婚吧";
		int index = 1;
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动		
		FileRenameDriver.batchRename(directory, prefix, index);
	}
	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
	}

}
