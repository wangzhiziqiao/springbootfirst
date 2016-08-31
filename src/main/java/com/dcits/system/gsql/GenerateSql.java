package com.dcits.system.gsql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcits.entity.User;
import com.dcits.entity.User2;
import com.dcits.system.gsql.SqlKeyWord;

public class GenerateSql {
	
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
	public static String generatesql(Class primary, String prop, Class foreign, String prop1) {
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append(SqlKeyWord.SELECT);
		for (Field pf : primary.getDeclaredFields()) {
			list.add(pf.getName());
			sb.append(SqlKeyWord.SPACE).append(pf.getName().toUpperCase()).append(",");
		}
		for (Field ff : foreign.getDeclaredFields()) {
			list.add(ff.getName());
			sb.append(SqlKeyWord.SPACE).append(ff.getName().toUpperCase()).append(",");
		}
		sb.delete(sb.length() - 1, sb.length()).append(SqlKeyWord.SPACE).append(SqlKeyWord.FROM)
				.append(SqlKeyWord.SPACE).append(primary.getSimpleName().toUpperCase()).append(SqlKeyWord.P)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.LEFT).append(SqlKeyWord.SPACE).append(SqlKeyWord.JOIN)
				.append(SqlKeyWord.SPACE).append(foreign.getSimpleName().toUpperCase()).append(SqlKeyWord.F)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.ON).append(SqlKeyWord.SPACE).append(SqlKeyWord.P)
				.append(SqlKeyWord.DOT).append(prop.toUpperCase()).append(SqlKeyWord.SPACE).append(SqlKeyWord.EQUAL)
				.append(SqlKeyWord.SPACE).append(SqlKeyWord.F).append(SqlKeyWord.DOT).append(prop1.toUpperCase());

		// 添加查询条件
		
		
		
		//生成 与前端对应的vo
		
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String sql = generatesql(User.class, "user2id", User2.class, "user2id");
		System.out.println(sql);
	}

}
