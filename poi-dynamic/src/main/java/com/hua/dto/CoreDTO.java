/**
  * @filename CoreDTO.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

 /**
 * @type CoreDTO
 * @description 
 * @author qye.zheng
 */
public abstract class CoreDTO {

	/* 扩展字段 */
	private Map<String, Object> ext = new HashMap<String, Object>();

	/**
	 * @return the ext
	 */
	public final Map<String, Object> getExt() {
		return ext;
	}

	/**
	 * @param ext the ext to set
	 */
	public final void setExt(Map<String, Object> ext) {
		this.ext = ext;
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
