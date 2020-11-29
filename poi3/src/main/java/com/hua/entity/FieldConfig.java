/**
  * @filename FieldConfig.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

 /**
 * @type FieldConfig
 * @description 
 * @author qye.zheng
 */
public class FieldConfig {

	private String name;
	
	private String label;
	
	/* 需要知道 扩展字段的类型，才能注入相应形式的值，固化字段可以不用设置 */
	private String type;
	
	/* 是否必填 */
	private boolean required;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the label
	 */
	public final String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public final void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the required
	 */
	public final boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public final void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type) {
		this.type = type;
	}
}
