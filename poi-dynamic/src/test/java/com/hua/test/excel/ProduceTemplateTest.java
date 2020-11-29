/**
 * 描述: 
 * ProduceTemplateTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.excel;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.FieldConfig;
import com.hua.test.BaseTest;
import com.hua.util.ProduceTemplateUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ProduceTemplateTest
 */
public final class ProduceTemplateTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testProduceTemplate() {
		try {
			String suffix = "xls";
			List<FieldConfig> configs = new ArrayList<FieldConfig>();
			FieldConfig config = null;
			
			config = new FieldConfig();
			config.setLabel("列1很长的列哈哈哈哈爱和恨啊");
			config.setRequired(true);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("avc列2");
			config.setRequired(false);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("12列3");
			config.setRequired(false);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("avca123sd中国列4");
			config.setRequired(true);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("单");
			config.setRequired(true);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("双字");
			config.setRequired(true);
			configs.add(config);
			
			config = new FieldConfig();
			config.setLabel("三个字");
			config.setRequired(true);
			configs.add(config);
			
			ProduceTemplateUtil.produce(suffix, configs);
			
		} catch (Exception e) {
			log.error("testProduceTemplate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetColumnWidth() {
		try {
			String value = "终端级别";
			
			log.info("testGetColumnWidth =====> " + value.length() * 1000);
			
		} catch (Exception e) {
			log.error("testGetColumnWidth =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
