/**
  * @filename ExtendFieldDTO.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.dto;

 /**
 * @type ExtendFieldDTO
 * @description 
 * @author qye.zheng
 */
public final class ExtendFieldDTO extends CoreDTO {

	/**
	 * 基本属性，加上动态扩展的属性 
	 */
	
	private String id;
	
	private String name;

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

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
	
}
