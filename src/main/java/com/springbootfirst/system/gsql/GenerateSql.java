package com.springbootfirst.system.gsql;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbootfirst.entity.User;
import com.springbootfirst.entity.User2;
import com.springbootfirst.system.annotation.*;
import com.springbootfirst.system.gsql.SqlKeyWord;

/**
 * 
 * @author wangqiao wangzhiziqiao@163.com
 *
 */
public class GenerateSql {

	@SuppressWarnings("unused")
	@Autowired
	private VelocityEngine velocityEngine;

	/**
	 * 一对多的sql
	 * 
	 * @param primary
	 *            主表
	 * @param prop
	 *            主表的字段
	 * @param foreign
	 *            附表
	 * @param prop1
	 *            附表的字段
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String generatesql(Class primary, String prop, Class foreign, String prop1) {
		Map<String, Annotation[]> propMap = new HashMap<String, Annotation[]>();
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append(SqlKeyWord.SELECT);
		for (Field pf : primary.getDeclaredFields()) {
			list.add(pf.getName());
			if (pf.getDeclaredAnnotations().length > 0) {
				propMap.put(pf.getName(), pf.getDeclaredAnnotations());
			}
			sb.append(SqlKeyWord.SPACE).append(pf.getName().toUpperCase()).append(",");
		}
		for (Field ff : foreign.getDeclaredFields()) {
			list.add(ff.getName());
			if (ff.getDeclaredAnnotations().length > 0) {
				propMap.put(ff.getName(), ff.getDeclaredAnnotations());
			}
			sb.append(SqlKeyWord.SPACE).append(ff.getName().toUpperCase()).append(",");
		}
		sb.delete(sb.length() - 1, sb.length()).append(SqlKeyWord.SPACE).append(SqlKeyWord.FROM)
				.append(SqlKeyWord.SPACE).append(primary.getSimpleName().toUpperCase()).append(SqlKeyWord.P)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.LEFT).append(SqlKeyWord.SPACE).append(SqlKeyWord.JOIN)
				.append(SqlKeyWord.SPACE).append(foreign.getSimpleName().toUpperCase()).append(SqlKeyWord.F)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.ON).append(SqlKeyWord.SPACE).append(SqlKeyWord.P)
				.append(SqlKeyWord.DOT).append(prop.toUpperCase()).append(SqlKeyWord.SPACE).append(SqlKeyWord.EQUAL)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.F).append(SqlKeyWord.DOT).append(prop1.toUpperCase())
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.WHERE).append(SqlKeyWord.DEFAULTWHERE)
				.append(SqlKeyWord.SPACE);

		// 添加查询条件

		for (String key : propMap.keySet()) {
			Annotation annotation = propMap.get(key)[0];
			if (annotation.annotationType() == Like.class) {
				// Like like = (Like) annotation;
				sb.append(SqlKeyWord.AND).append(SqlKeyWord.SPACE).append(key.toUpperCase()).append(SqlKeyWord.SPACE)
						.append(SqlKeyWord.EQUAL).append(SqlKeyWord.SPACE).append(SqlKeyWord.MARK)
						.append(SqlKeyWord.SPACE);
			} else if (annotation.annotationType() == LessThan.class) {
				LessThan lessThan = (LessThan) annotation;
				sb.append(SqlKeyWord.AND).append(SqlKeyWord.SPACE).append(key.toUpperCase()).append(SqlKeyWord.SPACE)
						.append(SqlKeyWord.LT);
				if (lessThan.iscontain()) {
					sb.append(SqlKeyWord.EQUAL);
				}
				sb.append(SqlKeyWord.SPACE).append(SqlKeyWord.MARK).append(SqlKeyWord.SPACE);
			} else if (annotation.annotationType() == And.class) {

			} else if (annotation.annotationType() == Between.class) {

			} else if (annotation.annotationType() == GreaterThan.class) {

			} else if (annotation.annotationType() == In.class) {

			} else if (annotation.annotationType() == IsNotNull.class) {

			} else if (annotation.annotationType() == IsNull.class) {

			} else if (annotation.annotationType() == Not.class) {

			} else if (annotation.annotationType() == NotIn.class) {

			} else if (annotation.annotationType() == NotLike.class) {

			} else if (annotation.annotationType() == NotNull.class) {

			} else if (annotation.annotationType() == Or.class) {

			} else if (annotation.annotationType() == OrderBy.class) {

			}
		}
		
		//生成dao，并添加分页信息

		// 生成 与前端对应的vo

		return sb.toString();
	}

	public static void main(String[] args) {
		String sql = generatesql(User.class, "user2id", User2.class, "user2id");
		System.out.println(sql);
	}

}
