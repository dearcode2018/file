/**
 * ReflectUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


import com.hua.annotation.FieldCheck;
import com.hua.util.DateTimeUtil;
import com.hua.util.EmptyUtil;
import com.hua.util.StringUtil;

/**
 * ReflectUtil
 * 描述: 反射 - 工具类
 * @author  qye.zheng
 */
public final class ReflectUtil
{

	/**
	 * 构造方法
	 * 描述: 私有 - 禁止实例化
	 * @author  qye.zheng
	 */
	private ReflectUtil()
	{
	}
	
	/**
	 * 
	 * 描述: 搜索参数 - 预警
	 * 对基本类型不敏感
	 * @author  qye.zheng
	 * @param methodName
	 * @param object
	 * @param log
	 */
	public static void alertSearch(final String methodName, final Object object)
	{
		final Class<?> clazz = object.getClass();
		// 获取所有声明的属性
		final Field[] fields = clazz.getDeclaredFields();
		Field field = null;
		String temp = null;
		java.util.Date dateTime = null;
		try
		{
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				// 给指定的属性设置值
				// 设置为可以访问(若不设置，则访问将抛异常)
				/*
				 java.lang.IllegalAccessException: Class com.hua.test.reflect.ReflectTest can not access a 
				 member of class com.hua.entity.User with modifiers "private"
				 */
				field.setAccessible(true);
				
				// 对字符串单独做警告
				if (field.get(object) instanceof String)
				{
					temp = (String) field.get(object);
					if (StringUtil.isEmpty(temp))
					{
					} else 
					{
					}
					continue;
				}
				// 非字符串类型的警告
				if (null == field.get(object))
				{
				} else
				{
					// 格式化日期时间类型 java.util.Date
					if (field.get(object) instanceof java.util.Date)
					{
						dateTime = (java.util.Date) field.get(object);
						temp = DateTimeUtil.format(dateTime);
					} else
					{
					}
				}

			}
		} catch (Exception e)
		{
		}
	}
	
	/**
	 * 
	 * 描述: 非空验证
	 * @author  qye.zheng
	 * @param target 需要验证的对象
	 * @param log
	 * @return true - 验证通过，false - 存在为空数据，验证不通过
	 * 字符串为空单独验证
	 */
	public static boolean notEmptyValidate(final Object target)
	{
		boolean flag = false;
		final Class<?> clazz = target.getClass();
		// 获取所有声明的属性
		final Field[] fields = clazz.getDeclaredFields();
		Field field = null;
		FieldCheck fieldCheck = null;
		String temp = null;
		try
		{
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				// 判断是否施加 FieldCheck 注解
				fieldCheck = field.getAnnotation(FieldCheck.class);
				if (null == fieldCheck)
				{
					// 没有施加指定的注解，结束当前循环，进入下一次循环
					continue;
				}
				
				if (!fieldCheck.nullable())
				{
					// 不能为空，需要非空验证
					// 给指定的属性设置值
					// 设置为可以访问(若不设置，则访问将抛异常)
					/*
					 java.lang.IllegalAccessException: Class com.hua.test.reflect.ReflectTest can not access a 
					 member of class com.hua.entity.User with modifiers "private"
					 */
					field.setAccessible(true);
					// 对字符串单独做验证
					if (field.get(target) instanceof String)
					{
						temp = (String) field.get(target);
						if (StringUtil.isEmpty(temp))
						{
							
							return false;
						} 
						
						continue;
					}
					// 非字符串类型的验证
					if (null == field.get(target))
					{
						
						return false;
					}
				}
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * @description 获取setter方法的参数类型
	 * 符合JavaBean规范的setter方法只有一个参数
	 * @param clazz
	 * @param setterName
	 * @return
	 * @author qye.zheng
	 */
	public static final Class<?> getSetterParameterType(final Class<?> clazz, final String setterName)
	{
		Class<?> result = null;
		if (null == clazz || StringUtil.isEmpty(setterName))
		{
			return result;
		}
		final Method[] ms = clazz.getMethods();
		Class<?>[] clazzs = null;
		for (Method m : ms)
		{
			clazzs = m.getParameterTypes();
			if (!EmptyUtil.isEmpty(clazzs))
			{
				result = clazzs[0];
				if (setterName.equals(m.getName()))
				{
					
					return result;
				}
			}
		}
		
		return null;
	}

}
