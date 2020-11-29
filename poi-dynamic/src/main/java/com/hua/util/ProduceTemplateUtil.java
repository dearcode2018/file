/**
 * ProduceTemplateUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import com.hua.entity.FieldConfig;
import com.hua.util.IOUtil;
import com.hua.util.POIUtil;
import com.hua.util.StringUtil;

/**
 * ProduceTemplateUtil
 * 描述: 生成模板 示例工具
 * @author  qye.zheng
 */
public final class ProduceTemplateUtil
{


	/**
	 * 可配置参数: xls(为空则默认该值) / xlsx
	 * 样式参数: 背景颜色、字体、字号、
	 * 根据字段顺序，名称、是否必填(文本颜色一般为红色)、
	 * 
	 */
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private ProduceTemplateUtil()
	{
	}
	
	/**
	 * 
	 * @description 
	 * @param suffix
	 * @param fieldConfigs
	 * @author qye.zheng
	 */
	public static final void produce(final String suffix, final List<FieldConfig> fieldConfigs)
	{
		final Workbook workbook = POIUtil.createWorkbook(suffix);
		final Sheet sheet = workbook.createSheet();
		//sheet.autoSizeColumn(0, true);
		// 标题行
		final Row header = sheet.createRow(0);
		Cell cell = null;
		FieldConfig config = null;
		CellStyle cellStyle = null;
		Font font = null;
		for (int i = 0; i < fieldConfigs.size(); i++)
		{
			cell = header.createCell(i);
			config = fieldConfigs.get(i);
			// 设置名称
			cell.setCellValue(config.getLabel());
			
			// 单元格样式、字体对象 不能公用
			font = workbook.createFont();
			// 字体名称
			font.setFontName("宋体");
			// 字体大小
			font.setFontHeightInPoints((short) 13);
			// 字体样式 (粗 / 细)
			//font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			// 必填
			if (config.isRequired())
			{
				font.setColor(IndexedColors.RED.index);
			}
			
			cellStyle = workbook.createCellStyle();
			cellStyle.setFont(font);
			// 设置背景颜色
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
			// 设置填充模式
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			// 水平居中
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			// 
			sheet.setColumnWidth(i, getColumnWith(config.getLabel()));
			// 无法应对中文宽度问题
			//sheet.autoSizeColumn(i); 
			//sheet.autoSizeColumn(i, true); 
			
			// 设置边框
			cellStyle.setBorderTop(CellStyle.BORDER_THIN);
			cellStyle.setBorderRight(CellStyle.BORDER_THIN);
			cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
			
			
			//cellStyle.setShrinkToFit(false);
			// 设置样式
			cell.setCellStyle(cellStyle);
			
		}
		final String outputPath = ProjectUtil.getAbsolutePath("/doc/temp/template." + suffix, true);
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputPath);
			workbook.write(outputStream);
			
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			IOUtil.close(outputStream);
		}
		
	}
	
	/**
	 * 
	 * @description 根据字符长度，智能调整 列的宽度
	 * 例如 出现 1或2个字符这种情况，需要智能加长
	 * @param value
	 * @return
	 * @author qye.zheng
	 */
	private static final int getColumnWith(final String value)
	{
		// 设置一个最小宽度
		int width = -1;
		if (StringUtil.isEmpty(value))
		{
			return width;
		}
		width = value.length() * 1000;
		if (width < 4000)
		{
			width = 4000;
		}
		
		
		return width;
	}

}
