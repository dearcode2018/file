/**
 * 描述: 
 * ITextTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.itext;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.hua.test.BaseTest;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * ITextTest
 */
public final class ITextTest extends BaseTest {
	
	/**
	 * 
	 * 描述: 亚洲-中文支持
	 * 支持包 : itext-asian.jar
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testChinese() {
		// 新建 pdf 文档
		Document doc = null;
		try {
			final String filename = "chinese.pdf";
			 doc = new Document();
			final OutputStream output = new FileOutputStream(PATH + "/" + filename);
			// 创建Pdf 书写器 与 document 对象关联
			final PdfWriter pdf = PdfWriter.getInstance(doc, output);
			
			// 字体
			BaseFont baseFont = null;
			Font chineseFont = null;
			baseFont = BaseFont.createFont("STSong-Light", 
					"UniGB-UCS2-H", BaseFont.EMBEDDED);
			chineseFont = new Font(baseFont, 12, Font.NORMAL);
			
			// 打开文档
			doc.open();
			// 元素对象 : 段落，中文字体 参数
			final Element e = new Paragraph("你好，中国", chineseFont);
			// 向文档中添加元素
			doc.add(e);
		} catch (Exception e) {
			log.error("test =====> ", e);
		} finally {
			// 关闭文档, 最终生成 pdf 文档
			if (null != doc) {
				doc.close();
				}
			}
	}
	
	/**
	 * 
	 * 描述: 设置密码/权限
	 * 支持包 : bcpkix-jdk15on-1.48.jar
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSafety() {
		try {
			// 新建 pdf 文档
			Document doc = null;
			final String filename = "safety.pdf";
			try {
				// 使用默认的矩形组件
				 doc = new Document();
				final OutputStream output = new FileOutputStream(PATH +  "/" + filename);
				// 创建Pdf 书写器 与 document 对象关联
				final PdfWriter pdf = PdfWriter.getInstance(doc, output);
				// 用户密码
				final byte[] user = {'1', '2', '3'};
				// 所有者密码
				final byte[] owner = {'a', 'b', 'c', 'd'};
				pdf.setEncryption(user, owner, PdfWriter.ALLOW_COPY, 
						PdfWriter.STANDARD_ENCRYPTION_40);
				
				// 打开文档
				doc.open();
				// 元素对象 : 段落
				final Element e = new Paragraph("jia mi");
				// 向文档中添加元素
				doc.add(e);
			} catch (Exception e) {
				log.error("test =====> ", e);
			} finally {
				// 关闭文档, 最终生成 pdf 文档
				if (null != doc) {
					doc.close();
				}
			}
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 创建pdf
	 * 视图/模式设置
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testViewPdf() {
		// 新建 pdf 文档
		Document doc = null;
		final String filename = "view.pdf";
		try {
			// 定义一个A4大小的矩形组件
			final Rectangle rect = new Rectangle(PageSize.A4);
			// 设置背景色为浅灰色
			rect.setBackgroundColor(BaseColor.LIGHT_GRAY);
			// 外边界宽度 (段落内容 与 文档边界 的距离)
			final int borderWidth = 10;
			// 使用默认的矩形组件
			 doc = new Document();
			//doc = new Document(rect, borderWidth, borderWidth, borderWidth, borderWidth);
			//doc = new Document(rect);
			final OutputStream output = new FileOutputStream(PATH + "/" + filename);
			
			// 创建Pdf 书写器 与 document 对象关联
			final PdfWriter pdf = PdfWriter.getInstance(doc, output);
			
			// pdf 阅读器设置
			/**
			 * PdfWriter.PageModeUseThumbs 显示缩略图
			 * PdfWriter.PageLayoutTwoColumnLeft 双列显示，奇数页在左
			 * PdfWriter.HideMenubar 隐藏菜单
			 */
			//pdf.setViewerPreferences(PdfWriter.PageModeUseThumbs);
			//pdf.setViewerPreferences(PdfWriter.PageLayoutTwoColumnLeft);
			//pdf.setViewerPreferences(PdfWriter.HideMenubar);
			pdf.setViewerPreferences(PdfWriter.PageModeFullScreen);
			
			// 打开文档
			doc.open();
			// 元素对象 : 段落
			final Element e = new Paragraph("hello world");
			// 向文档中添加元素
			doc.add(e);
		} catch (Exception e) {
			log.error("test =====> ", e);
		} finally {
			// 关闭文档, 最终生成 pdf 文档
			if (null != doc) {
				doc.close();
			}
		}
	}
	
	
	/**
	 * 
	 * 描述: 简单创建 pdf
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHelloWorld() {
		// 新建 pdf 文档
		Document doc = null;
		try {
			final String filename = "hello.pdf";
			 doc = new Document();
			final OutputStream output = new FileOutputStream(PATH + "/" + filename);
			// 创建Pdf 书写器 与 document 对象关联
			final PdfWriter pdf = PdfWriter.getInstance(doc, output);
			// 打开文档
			doc.open();
			// 元素对象 : 段落
			final Element e = new Paragraph("你好，中国");
			// 向文档中添加元素
			doc.add(e);
		} catch (Exception e) {
			log.error("test =====> ", e);
		} finally {
			// 关闭文档, 最终生成 pdf 文档
			if (null != doc) {
				doc.close();
				}
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
			log.info("test=====> path = " + PATH);
			
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
	public void test() {
		try {
			log.info("test=====> path = " + PATH);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
}
