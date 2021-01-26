/**
 * WriteProperties.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.hua.util.ClassPathUtil;

/**
 * WriteProperties
 * 描述: 
 * @author  qye.zheng
 */
public final class WriteProperties
{
	/* 数据操作工具，可单例 */
	private Properties props;
	
	/* 数据来源，对象化 */
	private InputStream inputStream;
	
	/* 数据输出新配置，对象化 */
	private OutputStream outputStream;

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public WriteProperties(final String filePath)
	{
		props = new Properties();
		inputStream = ClassPathUtil.getInputStream(filePath);
		try {
			/*
			 装载完毕之后，将输入流关闭，然后以文件路径
			 为参数，构造文件输出流，将新设置到props之后，
			 最后通过输出流存储到文件(覆盖旧的配置文件)
			 */
			props.load(inputStream);
			// 一定要关闭输入流，否则输出文件可能会受到影响
			inputStream.close();
			outputStream = new FileOutputStream(ClassPathUtil.getClassPath(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: 新增或修改值
	 * @author  qye.zheng
	 * @param key
	 * @param value
	 * @return
	 */
	public Object setProperty(final String key, final String value)
	{
		return props.setProperty(key, value);
	}
	
	/**
	 * 
	 * 描述:存储值
	 * 关闭流，当前对象 [写属性] 功能结束
	 * 最后输出的属性配置文件:
	 * 配置项的顺序将和以前不同，props对
	 * key进行了排序 (修改配置将会打乱原有的配置顺序)
	 * @author  qye.zheng
	 * @param comment 对此次修改的说明
	 */
	public boolean store(final String comment)
	{
		boolean flag = true;
		try
		{
			// 连接输出流，并添加注释
			props.store(outputStream, comment);
			if (null != outputStream)
			{
				outputStream.flush();
				outputStream.close();
				// 将props置空，释放对象引用
				props = null;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}
	

}
