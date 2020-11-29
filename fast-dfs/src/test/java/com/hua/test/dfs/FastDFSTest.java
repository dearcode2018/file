/**
 * 描述: 
 * FastDFSTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.dfs;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FastDFSTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class FastDFSTest extends BaseTest {

	
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    //@DisplayName("test")
    @Test
    public void testFastDFS() {
        try {
            // 加载 properties 格式文件配置：
            ClientGlobal.initByProperties("fastdfs-client.properties");
            
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getTrackerServer();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            
            // 上传文件
            NameValuePair[] metaList = new NameValuePair[1];
            String local_filename = "白熊_01.jpg";
            metaList[0] = new NameValuePair("fileName", local_filename);
            String path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            // 制定扩展名，不用带点 do not include dot(.)
            String[] result = storageClient.upload_file(bytes, "jpg", metaList);
            
            /*
             * result[0] = group1  # 文件存储的分组，group1 对应 path0
             * result[1] = M00/00/00/wKjHgV_DEEaAd3wkAAISWXCQWtY2071417 # 分组下的路径
             */
            Assert.assertEquals(2, result.length);
            System.out.println(result[0] + ", " + result[1]);
            
            inputStream.close();
            // 关闭客户端
            storageClient.close();
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
    //@DisplayName("test")
    @Test
    public void testUpload() {
        try {
            // 加载 properties 格式文件配置：
            ClientGlobal.initByProperties("fastdfs-client.properties");
            
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getTrackerServer();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            
            // 上传文件
            NameValuePair[] metaList = new NameValuePair[1];
            String local_filename = "白熊_01.jpg";
            metaList[0] = new NameValuePair("fileName", local_filename);
            String path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            // 制定扩展名，不用带点 do not include dot(.)
            String[] result = storageClient.upload_file(bytes, "jpg", metaList);
            
            /*
             * result[0] = group1  # 文件存储的分组，group1 对应 path0
             * result[1] = M00/00/00/wKjHgV_DEEaAd3wkAAISWXCQWtY2071417 # 分组下的路径
             */
            Assert.assertEquals(2, result.length);
            System.out.println(result[0] + ", " + result[1]);
            
            inputStream.close();
            // 关闭客户端
            storageClient.close();
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
    //@DisplayName("test")
    @Test
    public void testDownload() {
        try {
            // 加载 properties 格式文件配置：
            ClientGlobal.initByProperties("fastdfs-client.properties");
            
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getTrackerServer();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            
            // 下载
            String[] uploadresult = {"group1", "M00/00/00/wKjHgV_DEKmAQYXkAAISWXCQWtY604.jpg"};
            byte[] result = storageClient.download_file(uploadresult[0], uploadresult[1]);
            String localFilename = "my图片.jpg";
            FileUtil.writeByteArray(ProjectUtil.getAbsolutePath("/doc/" + localFilename), result, false);
            
            // 关闭客户端
            storageClient.close();
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
	//@DisplayName("test")
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
	@DisplayName("testTemp")
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
	@DisplayName("testCommon")
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
	@DisplayName("testSimple")
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
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
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
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
