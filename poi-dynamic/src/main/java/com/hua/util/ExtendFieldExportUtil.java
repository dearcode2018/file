/**
 * ExtendFieldExportUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.hua.entity.FieldConfig;
import com.hua.util.EmptyUtil;
import com.hua.util.IOUtil;
import com.hua.util.POIUtil;
import com.hua.util.StringUtil;

/**
 * ExtendFieldExportUtil 描述:
 * 
 * @author qye.zheng
 */
public final class ExtendFieldExportUtil {

	/**
	 * 构造方法 描述:
	 * 
	 * @author qye.zheng
	 */
	private ExtendFieldExportUtil() {
	}

	/**
	 * 
	 * @description 
	 * @param clazz
	 * @param data
	 * @param fieldConfigs
	 * @param suffix
	 * @author qye.zheng
	 */
	@SuppressWarnings({"unchecked"})
	public static final void export(final Class<?> clazz, final List<?> data,
			final List<FieldConfig> fieldConfigs, final String suffix) {
		final Workbook workbook = POIUtil.createWorkbook(suffix);
		final Sheet sheet = workbook.createSheet();
		// 标题行
		final Row header = sheet.createRow(0);
		Cell cell = null;
		FieldConfig config = null;
		Object value = null;
		// 填写数据
		final String[] fields = new String[fieldConfigs.size()];
		CellStyle cellStyle = null;
		for (int i = 0; i < fieldConfigs.size(); i++) {
			cell = header.createCell(i);
			config = fieldConfigs.get(i);
			// 设置名称
			cell.setCellValue(config.getLabel());
			fields[i] = config.getName();
			cellStyle = workbook.createCellStyle();
			
			// 水平居中
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			// 
			sheet.setColumnWidth(i, POIUtil.getColumnWith(config.getLabel()));	
			
			// 设置样式
			cell.setCellStyle(cellStyle);
		}
		Object item = null;
		Map<String, Object> ext = null;
		Method method = null;
		String getterName = null;
		int j = -1;
		Row row = null;
		OutputStream outputStream = null;
		try {
			if (!EmptyUtil.isEmpty(data))
			{
				for (int i = 0; i < data.size(); i++) {
					item = data.get(i);
					if (null == item)
					{
						continue;
					}
					row = sheet.createRow(i + 1);
					j = 0;
					while (j < fields.length) {
						if (StringUtil.isEmpty(fields[j])) {
							// 注意此处一定要自增，不然会导致死循环
							j++;
							// 忽略该列
							continue;
						}
						cell = row.createCell(j);
						if (fields[j].startsWith("ext")) {
							// 获取 ext 属性
							ext = (Map<String, Object>) clazz.getMethod("getExt")
									.invoke(item);
							value = ext.get(fields[j]);
							setCellValue(workbook, cell, value);
						} else {
							getterName = "get" + StringUtil.capitalize(fields[j]);
							// 反射，执行设置属性的方法 一般是 getXx
							method = clazz.getMethod(getterName);
							method.setAccessible(true);
							value = method.invoke(item);
							setCellValue(workbook, cell, value);
						}
						j++;
					}
				}
			}
			final String outputPath = ProjectUtil.getAbsolutePath(
					"/doc/ExtendFieldExport." + suffix, true);
			outputStream = new FileOutputStream(outputPath);
			workbook.write(outputStream);

			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(outputStream);
		}
	}

	/**
	 * 
	 * @description
	 * @param cell
	 * @param value
	 * @author qye.zheng
	 */
	public static final void setCellValue(final Workbook workbook, final Cell cell, final Object value) {
		if (null == cell || null == value) {
			return;
		}
		if (String.class == value.getClass()) {
			System.out.println("String");
			cell.setCellValue((String) value);
		} else if (Double.class == value.getClass()) {
			System.out.println("Double");
			cell.setCellValue((Double) value);
		} else if (Date.class == value.getClass()) {
			/*
			 * 日期需要设置一下格式，便于显示
			 * 在具体的场景中，应该有字段配置对象
			 * 来决定该格式
			 * 这里只是做一个日期时间的示例
			 */
			final CellStyle cellStyle =  workbook.createCellStyle();
			final DataFormat df = workbook.createDataFormat();
			cellStyle.setDataFormat(df.getFormat("yyyy-MM-dd HH:mm:ss"));
			cell.setCellStyle(cellStyle);
			System.out.println("Date");
			cell.setCellValue((Date) value);
		} else if (Byte.class == value.getClass()) {
			System.out.println("Byte");
			cell.setCellValue((Byte) value);
		} else if (Boolean.class == value.getClass()) {
			System.out.println("Boolean");
			cell.setCellValue((Boolean) value);
		} else if (Short.class == value.getClass()) {
			System.out.println("Short");
			cell.setCellValue((Short) value);
		} else if (Integer.class == value.getClass()) {
			System.out.println("Integer");
			cell.setCellValue((Integer) value);
		} else if (Long.class == value.getClass()) {
			System.out.println("Long");
			cell.setCellValue((Long) value);
		}
	}
	
}
