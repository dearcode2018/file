/**
 * JxlUtil.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import jxl.WorkbookSettings;

/**
 * JxlUtil
 * 描述: 
 * @author  qye.zheng
 * 
 */
public final class JxlUtil
{
	/**
	 jxl 目前只能读取 office 2003及相对低版本的 excel表格
	 
	 poi 可以读取 office 2003 或 2007 以及更高版本的 excel表格
	 创建的时候需要根据文件后缀名来选择构建方式 (xls / xlsx)
	 
	 */

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * 
	 */
	private JxlUtil()
	{
	}

	/**
	 * 
	 * 描述: 工作簿 - 配置
	 * @author  qye.zheng
	 * 
	 * @return
	 */
	public static WorkbookSettings workbookSettings()
	{
		WorkbookSettings settings = new WorkbookSettings();
		// 关闭警告信息(特别是中文问题警告)
		settings.setSuppressWarnings(true);
		
		// 其他设置

		
		return settings;
	}
	
	
}
