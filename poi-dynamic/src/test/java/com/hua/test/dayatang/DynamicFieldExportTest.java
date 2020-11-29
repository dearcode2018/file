/**
 * 描述: 
 * DynamicFieldExportTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.dayatang;

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
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.dto.ExtendFieldDTO;
import com.hua.entity.FieldConfig;
import com.hua.test.BaseTest;
import com.hua.util.ExtendFieldExportUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DynamicFieldExportTest
 */
public final class DynamicFieldExportTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDynamicFieldExport() {
		try {
			String suffix = "xls";
			List<FieldConfig> configs = new ArrayList<FieldConfig>();
			FieldConfig config = null;
			
			config = new FieldConfig();
			config.setName("id");
			config.setLabel("编号");
			config.setRequired(true);
			configs.add(config);
			
			config = new FieldConfig();
			config.setName("name");
			config.setLabel("名称");
			config.setRequired(false);
			configs.add(config);
			
			config = new FieldConfig();
			config.setName("extField1");
			config.setLabel("扩展1");
			config.setRequired(false);
			configs.add(config);
			
			config = new FieldConfig();
			config.setName("extField2");
			config.setLabel("扩展2");
			config.setRequired(true);
			configs.add(config);
			
			List<ExtendFieldDTO> data = new ArrayList<ExtendFieldDTO>();
			ExtendFieldDTO item = null;
			item = new ExtendFieldDTO();
			item.setId("2001asfasfasfasfasfsdfasdfasfasf");
			item.setName("名称1");
			item.getExt().put("extField1", 12);
			item.getExt().put("extField2", true);
			data.add(item);
			
			item = new ExtendFieldDTO();
			item.setId("2002");
			item.setName("名称2");
			item.getExt().put("extField1", 1255254454);
			item.getExt().put("extField2", false);
			data.add(item);
			
			item = new ExtendFieldDTO();
			item.setId("2003");
			item.setName("名称3");
			item.getExt().put("extField1", new Date());
			Byte b = 12;
			item.getExt().put("extField2", b);
			//item.getExt().put("extField2", 2.34);
			data.add(item);
			
			ExtendFieldExportUtil.export(ExtendFieldDTO.class, data, configs, suffix);
			
		} catch (Exception e) {
			log.error("testDynamicFieldExport =====> ", e);
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
