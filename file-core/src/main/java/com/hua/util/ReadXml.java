/**
 * 描述: 
 * ReadXml.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hua.util.ClassPathUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * ReadXml
 */
public final class ReadXml {
	
	/* 数据操作工具，可单例 */
	private static Properties props;
	
	/* 数据来源，对象化 */
	private InputStream input;
	
	static {
		// 仅实例化一次
		props = new Properties();
	}
	
	public ReadXml(final String filePath) {
		input = ClassPathUtil.getInputStream(filePath);
		try {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: 根据key获取相应的值 
	 * @author qye.zheng
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(final String key) {
		
		return props.getProperty(key);
	}
	
	
	
	
	
	
	
	
}
