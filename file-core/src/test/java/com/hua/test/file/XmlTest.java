/**
 * 描述: 
 * XmlTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.file;

import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ReadXml;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * XmlTest
 */
public final class XmlTest extends BaseTest {
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadXml() {
		final String filePath = "conf/xml/student-info.xml";
		ReadXml xml = new ReadXml(filePath);
		System.out.println(xml.getProperty("id"));
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		
	}


}
