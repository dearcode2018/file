/**
  * @filename MultipleDataType.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

 /**
 * @type MultipleDataType
 * @description 多种数据类型
 * @author qye.zheng
 */
public class MultipleDataType {
	
	/**
	 * 在excel中，数值、日期统一为 Double 类型，最后需要获取Integer/Long/Double/Date 需要通过
	 * 相应的工具来获取，
	 * 
	 * 有些是数字像电话号码，位数一般比较长，会解析为科学计数法，此时应该使用
	 * DecimalFormat decimalFormat = new DecimalFormat("#"); 将Double格式化为字符串
	 * 
	 * 解析Double为日期类型，只能通过 HSSFDateUtil.getJavaDate(value, isDate1904) (XLS)
	 * 或 org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value, isDate1904); (XLSX)
	 */
	
	/**
	 * Integer/Long/Double: 通过Double类型来转换
	 * 
	 * Date: 通过Double类型来转换
	 * 
	 * String: 数字式的文本，为Double类型，setter方法参数类型为String，则通过
	 * DecimalFormat decimalFormat = new DecimalFormat("#");方式来转成非科学计数法的字符串
	 * 任何单元格全是数字类型，而且java类型是String，则需要通过格式化的方式取整数部分转为字符串.
	 * 
	 * 
	 * 
	 */
	/* 字符串 */
	private String string;
	
	private String numberString;
	
	private Date dateTime;
	
	private Date date;
	
	private Date time;
	
	private Boolean flag;
	
	private Byte bt;
	
	private Short sh;
	
	private Integer in;
	
	private Float fl;
	
	private Long lng;
	
	private Double dou;
	
	/**
	 * @return the string
	 */
	public final String getString() {
		return string;
	}



	/**
	 * @param string the string to set
	 */
	public final void setString(String string) {
		this.string = string;
	}



	/**
	 * @return the numberString
	 */
	public final String getNumberString() {
		return numberString;
	}



	/**
	 * @param numberString the numberString to set
	 */
	public final void setNumberString(String numberString) {
		this.numberString = numberString;
	}



	/**
	 * @return the dateTime
	 */
	public final Date getDateTime() {
		return dateTime;
	}



	/**
	 * @param dateTime the dateTime to set
	 */
	public final void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}



	/**
	 * @return the date
	 */
	public final Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public final void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the time
	 */
	public final Date getTime() {
		return time;
	}



	/**
	 * @param time the time to set
	 */
	public final void setTime(Date time) {
		this.time = time;
	}



	/**
	 * @return the flag
	 */
	public final Boolean getFlag() {
		return flag;
	}



	/**
	 * @param flag the flag to set
	 */
	public final void setFlag(Boolean flag) {
		this.flag = flag;
	}



	/**
	 * @return the bt
	 */
	public final Byte getBt() {
		return bt;
	}



	/**
	 * @param bt the bt to set
	 */
	public final void setBt(Byte bt) {
		this.bt = bt;
	}



	/**
	 * @return the sh
	 */
	public final Short getSh() {
		return sh;
	}



	/**
	 * @param sh the sh to set
	 */
	public final void setSh(Short sh) {
		this.sh = sh;
	}



	/**
	 * @return the in
	 */
	public final Integer getIn() {
		return in;
	}



	/**
	 * @param in the in to set
	 */
	public final void setIn(Integer in) {
		this.in = in;
	}



	/**
	 * @return the fl
	 */
	public final Float getFl() {
		return fl;
	}



	/**
	 * @param fl the fl to set
	 */
	public final void setFl(Float fl) {
		this.fl = fl;
	}



	/**
	 * @return the lng
	 */
	public final Long getLng() {
		return lng;
	}



	/**
	 * @param lng the lng to set
	 */
	public final void setLng(Long lng) {
		this.lng = lng;
	}



	/**
	 * @return the dou
	 */
	public final Double getDou() {
		return dou;
	}



	/**
	 * @param dou the dou to set
	 */
	public final void setDou(Double dou) {
		this.dou = dou;
	}



	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}
}
