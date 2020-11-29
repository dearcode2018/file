/**
 * 描述: 
 * PoiUtilTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.grid;

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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.grid.ExcelExport;
import com.hua.bean.grid.ExcelImport;
import com.hua.entity.UserTest;
import com.hua.test.BaseTest;
import com.hua.util.FileUtil;
import com.hua.util.POIUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * PoiUtilTest
 */
public final class PoiUtilTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testImport() {
		try {
			inputStream = new FileInputStream(ProjectUtil.getAbsolutePath("/doc/export.xls", true));
			String filePath = ProjectUtil.getAbsolutePath("/doc/export-result.xls", true);
			String suffix = FileUtil.getSuffix(filePath);
			OutputStream outputStream = new FileOutputStream(filePath);
			String[] columns = {"username(*)", "password(*)", "lastLoginTime"};
			UserTest user = null;
			ExcelImport<UserTest> excelImport = new ExcelImport<UserTest>();
			excelImport.setType(suffix);
			excelImport.setOutputStream(outputStream);
			excelImport.setClazz(UserTest.class);
			excelImport.setColumns(columns);
			excelImport.setInputStream(inputStream);
		
			POIUtil.doImport(excelImport);
			System.out.println(excelImport.getMessage());
			//user = excelImport.getDataset().iterator().next();
			//System.out.println(user.getUsername());
			
		} catch (Exception e) {
			log.error("testImport =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExport() {
		try {
			String filePath = ProjectUtil.getAbsolutePath("/doc/export.xlsx", true);
			String suffix = FileUtil.getSuffix(filePath);
			OutputStream outputStream = new FileOutputStream(filePath);
			//List<String[]> data = new ArrayList<String[]>();
			
			ExcelExport<UserTest> export = new ExcelExport<UserTest>();
			String[] headers = {"用户名", "密码", "最后一次登录时间"};
			String[] columns = {"username", "password", "lastLoginTime"};
			
			//headers = new String[] {"编号", "用户名", "密码", "最后一次登录时间"};
			//columns = new String[] {"oid", "username", "password", "lastLoginTime"};

			headers = new String[] {"编号", "用户名", "密码", "最后一次登录时间", "用户状态"};
			columns = new String[] {"oid", "username", "password", "lastLoginTime", "valid"};
			
			String title = "用户帐号";
			//export.setDateTimeFormat(FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss);
			export.setHeaders(headers);
			export.setColumns(columns);
			export.setOutputStream(outputStream);
			//export.setTitle(title);
			export.setType(suffix);

			Collection<UserTest> dataset = new ArrayList<UserTest>();
			UserTest user = null;
			user = new UserTest();
			user.setUsername("张三");
			user.setPassword("654654");
			user.setLastLoginTime(new Date());
			user.setValid(true);
			dataset.add(user);

			user = new UserTest();
			user.setUsername("李四");
			user.setPassword("afasf");
			user.setLastLoginTime(new Date());
			user.setValid(false);
			dataset.add(user);
			
			export.setDataset(dataset);
			
			POIUtil.doExport(export);
			
		/*			
			String[] s1 = null;
			s1 = new String[] {"标题1", "标题2"};
			data.add(s1);

			s1 = new String[] {"内容11", "内容12"};
			data.add(s1);
			
			s1 = new String[] {"内容21", "内容22"};
			data.add(s1);
			
			s1 = new String[] {"内容31", "内容32"};
			data.add(s1);*/
			
		} catch (Exception e) {
			log.error("testExport =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReplaceMethodName() {
		try {
			String methodName = "mess(*)";
			methodName = "mess(++)";
			methodName = "mess(email)";
			System.out.println( methodName.replaceFirst("\\(.+\\)", "") );
		} catch (Exception e) {
			log.error("testReplaceMethodName =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPoiUtil() {
		try {
			
			
		} catch (Exception e) {
			log.error("testPoiUtil =====> ", e);
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
